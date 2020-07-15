/*
 * Created on Aug 30, 2005
 * Copyright(c) 2005 VeriFone, Inc. All Rights Reserved
 */
package com.verifone.isd.vsms2.sys.util.sax;

import java.util.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl; // testing only

/**
 * Simplified XPath sort-of language.  The current version allows only exact paths 
 * -- no predicates, .. (no alternative axes), * or '//'.
 * 
 * This class is designed for use within a ContentHandler.  After creation, use one or more 
 * defineNSPrefix() method calls to set up prefixes, followed by one or more defineXPath() 
 * method calls to set up the xPaths to use.  Once these methods have been called the
 * SimpleXPath object is ready to use, and may be reused multiple times.  See detailed 
 * method descriptions for certain anomalies. 
 * 
 * After the object is built, the reset() method resets it to its initial state.  The pushStep()
 * method progresses to the next sequential node in each defined xPath.  The popStep() returns
 * to the previous node.  
 * 
 * Once a node has been pushed, the checkAttributes() method can be used to check for any 
 * current attributes matching.  If matching attributes are found, the getNodeInfo() method
 * will dereference the xPath name and return the matching Node (namespace,localname) for
 * use.
 * 
 * @author David_E3
 * @see #defineNSPrefix(String)
 * @see #defineXPath(String, String)
 * @see #reset()
 * @see #pushStep(String, String)
 * @see #popStep()
 * @see #checkAttributes(Attributes)
 * @see #getNodeInfo(String)
 */
public class SimpleXPath {
        /**
         * value object returned by pushStep to notify of caller if 
         *      1. the element belongs in any registered xpath - 'requiredElement' would be true in this case
         *      2. if the element completed any registered xpath - 'matchingNames' is the array of all registered 
         *          and matched xpaths.
         * 
         */
        public class PushStepResult {
            public String[] matchingNames;
            public boolean requiredElement;
        }
    
	/**
	 * a generic tuple (namespace,localname) that represents a node
	 */
	public class Node {
        /**
         * namespace for the node
         */
		public String ns = null;
        /**
         * local name for the node
         */
		public String localName = null;		
	}
	
	/**
	 * node tests and predicates can be tests
	 */
	protected interface Test {
        /**
         * Method to be implemented to test for node match
         * @param n node to be compared
         * @return true if the compared node matches the node on which the method is invoked
         */
		public boolean matches(Node n);		
	}
	
	/**
	 * in this simple design, a NodeTest simply compares against a Node
	 */
	protected abstract class NodeTest extends Node implements Test {

	}
	
	/**
	 * specific class to test a QName
	 */
	protected class QNameTest extends NodeTest {
        /**
         * Implementation method
         * @param n node to be compared against
         * @return if the namespace and local name of the node to be compared are identical to the current instance
         */
		public boolean matches(Node n) { 
			return this.ns.equals(n.ns) && this.localName.equals(n.localName);
		}
	}

	/* 
	 * placeholder for future enhancement
	 *
	protected class PredicateTest implements Test {
		public boolean matches(Node n) { return false; }
	}	
	 */
	
	/**
	 * class to bind active xPaths to a given node
	 */	
	protected class TestStep {
        /**
         * node for this step
         */
		public Node node = null;
        /**
         * a collection of xpaths for this step
         */
		public Vector xPaths = null;
	}
	
	/**
	 * each XPath in the set must be named so results of match(s) can be reported.
	 */	
	protected class NamedXPath {
        /**
         * property to indicate whether the named xpath represents an attribute
         */
		public boolean isAttribute = false;
        /**
         * name of the xpath
         */
		public String name = null;
        /**
         * node tests associated with the named xpath
         */
		public NodeTest[] nodeTests = null;
	}
	
	private Hashtable nsPrefixes = null; // hashtable to dereference prefixes to uris
	private Vector xPathsActive = null;  // currently active xPaths (for a given node)
	private Vector xPaths = null;        // all defined xPaths
	private Stack testStepStack = null;  // stack of TestStep objects, one for each child element
	private int step = 0;                // position on the stack (quick check against xPaths)
	private Hashtable xPathSearch = null;// quick reference into xPaths given their name
	
	/**
	 * default constructor
	 */
	public SimpleXPath() {
		super();
		this.nsPrefixes = new Hashtable();
		this.xPaths = new Vector();
		this.testStepStack = new Stack();
		this.xPathSearch = new Hashtable();
	}
	
	/**
	 * call between each use of the SimpleXPath object
	 * From a SAX ContentHandler, usually should be called on the startDocument() method.
	 * @see org.xml.sax.ContentHandler#startDocument()
	 */
	public void reset() {	
		this.testStepStack.clear();
        step = 0;
		this.xPathsActive = (Vector)this.xPaths.clone();
	}
	
	//
	// see how big the array needs to be to hold the nodes
	//
	private int countNodeTests(String xPathString) {
		int count = -1;
		if (xPathString.indexOf('/') == 0) {
			int ix = 0;
			count = 0;
			
			while (ix >= 0) {
				ix = xPathString.indexOf('/',ix+1);
				count++;
			}
		}
		return count;
	}
	
	/**
	 * add an xPath expression to the object.
	 * xPaths should be added after all the namespace prefixes are defined.
	 * @see #defineNSPrefix(String)
	 * @param name identifier for this particular xPath.  Calling code will use this to know which xPath matched.
	 * @param xPathString input string in "xPath" format
	 * @throws Exception if the xPathString is malformed
	 */
	public void defineXPath(String name,String xPathString) throws Exception {
		boolean isAttribute = false;
		int nodeTests = this.countNodeTests(xPathString);
		if (nodeTests == -1) {
			throw new Exception("xPath ["+xPathString+"] must start with '/'");
		}

		NodeTest nodeTestArray[] = new NodeTest[nodeTests];
		for (int i = 0, ix = 0; i < nodeTests; i++) {
			int startIx = ix+1;
			ix = xPathString.indexOf('/',ix+1);
			String qname = ix == -1 ? xPathString.substring(startIx) : xPathString.substring(startIx,ix);
			QNameTest nodeTest = new QNameTest();
			int ixAtpersand = qname.indexOf('@');
			if (ixAtpersand == 0) {
				isAttribute = true;
				qname = qname.substring(1);
			}
			int ixColon = qname.indexOf(':');
			if (ixColon == -1) {
				nodeTest.ns = !isAttribute ? (String)this.nsPrefixes.get("") : "";
				nodeTest.localName = qname;
			} else {
				nodeTest.ns = (String)this.nsPrefixes.get(qname.substring(0,ixColon));
				nodeTest.localName = qname.substring(ixColon+1);
			}
			nodeTestArray[i] = nodeTest;
		}
		NamedXPath xpn = new NamedXPath();
		xpn.name = name;
		xpn.nodeTests = nodeTestArray;
		xpn.isAttribute = isAttribute;

		this.xPaths.add(xpn);
		this.xPathSearch.put(name,xpn);
		this.xPathsActive = (Vector)this.xPaths.clone();
	}
	
	/**
	 * define a namepsace prefix and associate it with a uri.  Note that for documents that >either< use 
	 * don't use a default namespace but for which the schema declares @elementFormDefault=unqualified,
	 * it's necessary to define a namespace "xmlns=\"\"".
	 * @param xmlNSAttr namespace definition in XML document format, e.g. 'xmlns:x="http://ex.com"'
	 * @throws Exception if xmlNSAttr is malformed
	 */
	public void defineNSPrefix(String xmlNSAttr) throws Exception {
		int ixColon = xmlNSAttr.indexOf(':');
		int ixEquals = xmlNSAttr.indexOf('=');
		int ixStartQuote = xmlNSAttr.indexOf('\"');
		int ixEndQuote = -1;
		if (ixStartQuote != -1) {
			ixEndQuote = xmlNSAttr.indexOf('\"',ixStartQuote+1);
		}
		if (ixColon > ixStartQuote) {
			ixColon = -1;
		}
		if (!(xmlNSAttr.startsWith("xmlns:") || xmlNSAttr.startsWith("xmlns=")) || ixEquals <= ixColon || ixStartQuote <= ixEquals || ixEndQuote <= ixStartQuote) {
			throw new Exception("invalid namespace definition string ["+xmlNSAttr+"]");
		}
		
		String prefix = ixColon != -1 ? xmlNSAttr.substring(ixColon+1,ixEquals) : "";
		String ns = xmlNSAttr.substring(ixStartQuote+1,ixEndQuote);
		this.nsPrefixes.put(prefix,ns);
	}

	/**
	 * call to progress to the next node test.  From a SAX ContentHandler, this method should be called
	 * from each startElement.  In the current design, the method will return a PushStepResult instance.
         * PushStepResult#requiredElement lets the caller know if the element is part of any registered xpath.
         *    The caller MUST NOT call popStep for the element UNLESS this value returned true in the corresponding
         *    startElement. This optimization is done to fix the HUGE memory overhead involved in processing tlogs.
         * PushStepResult#matchingNames is an arry of size 0 (no match) or 1 (matching) xPath names.  
         * In future revisions (where predicates are allowed) more than one match might be returned.
	 * @param ns the namespace uri of the current node
	 * @param localName the local name of the current node
	 * @return an array of 0 or more matching xPath names
	 * @see org.xml.sax.ContentHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
        public PushStepResult pushStep(String ns, String localName){
            Node node = new Node();
            node.ns = ns;
            node.localName = localName;
            
            boolean requiredStep = false;
            int position = step;
            Vector reqdXPaths = (Vector)this.xPathsActive.clone();
            NamedXPath[] allXPs = (NamedXPath[])reqdXPaths.toArray(new NamedXPath[0]);
            ArrayList matchArray = new ArrayList();
            for (int k = 0; k < allXPs.length; k++) {
                NamedXPath nxp = allXPs[k];
                if (position < nxp.nodeTests.length && !nxp.isAttribute) {
                    NodeTest nt = nxp.nodeTests[position];
                    if (nt.matches(node)) {
                        requiredStep = true;
                        if (nxp.nodeTests.length == (position+1)) {
                            matchArray.add(nxp.name);
                        }
                    }
                }
            }
            String[] result = (String[])matchArray.toArray(new String[0]);
            matchArray.clear();
            if (requiredStep) {
                TestStep ts = new TestStep();
                ts.node = node;
                ts.xPaths = reqdXPaths;
                this.testStepStack.push(ts);
                this.step++;
            }
            else {
                reqdXPaths.clear();
            }
            PushStepResult psr = new PushStepResult();
            psr.matchingNames = result;
            psr.requiredElement = requiredStep;
            return psr;
	}
	
	/**
	 * call to regress one node test.  From a SAX ContentHandler, this method should
	 * be called from the endElement() implementation ONLY if the pushStep method in the
         * startElement of the same element returned true for PushStepResult#requiredElement.
	 * @see org.xml.sax.ContentHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
	 *
	 */
	public void popStep() {
		TestStep ts = (TestStep)this.testStepStack.pop();
		if (ts != null) {
			this.xPathsActive = ts.xPaths;
			step--;
		}
	}

	/**
	 * look at attributes for matches (as child attributes) at the current node level. From a SAX ContentHandler, 
         * this method should be called from the endElement() implementation ONLY if the pushStep method in the
         * startElement of the same element returned true for PushStepResult#requiredElement and 
         * PushStepResult#matchingNames.length > 0.
	 * @param attrs to examine
	 * @return an array of 0 or more xPath names
	 */
	public String[] checkAttributes(Attributes attrs) {
		int limit = attrs.getLength();
		Node node = new Node();
		int position = step;
		NamedXPath[] allXPs = (NamedXPath[])this.xPathsActive.toArray(new NamedXPath[0]);
                ArrayList matchArray = new ArrayList();
                for (int i = 0; i < limit; i++) {	
			node.ns = attrs.getURI(i);
			node.localName = attrs.getLocalName(i);			
			for (int k = 0; k < allXPs.length; k++) {
                                NamedXPath nxp = allXPs[k];
				if (position < nxp.nodeTests.length && nxp.isAttribute) {
					NodeTest nt = nxp.nodeTests[position];
					if (nt.matches(node)) {
						if (nxp.nodeTests.length == (position+1)) {
							matchArray.add(nxp.name);
						}
					}		
				}
			}
		}
		String[] result = (String[])matchArray.toArray(new String[0]);
                matchArray.clear();
                return result;
	}
	
	/**
     * get the leaf (deepest) node corresponding to an xPath name.  Useful after a call to 
     * checkAttributes() to get the namespace name and attribute name that matched each xPath 
     * expression.
     * @param name the name of the XPath
     * @return the node corresponding to the specified XPath name
     */
	public Node getNodeInfo(String name) {
		NamedXPath xpn = (NamedXPath)this.xPathSearch.get(name);
		int last = xpn.nodeTests.length -1;
		if (last > -1) {
			return xpn.nodeTests[last];
		}
		return null;
	}

	/**
     * for testing only
     * @param args areguments to the main method - not used
     * @throws Exception on error in executing the test
     */
	public static void main(String[] args) throws Exception {
		String ns1 = "xmlns:d1=\"http://verifone.com\"";
		String ns2 = "xmlns:x1=\"\"";
		String ns3 = "xmlns=\"http://valero.com\"";
		
		String x1 = "/one/two/three";
		String x2 = "/one/two/three/four";
		String x3 = "/one/two/three/five";
		String x4 = "/d1:david/x1:bruce/ezell";
		String x5 = "/d1:david/x1:bruce/ezell/@foo";	
		String x6 = "/d1:david/x1:bruce/ezell/@d1:bar";
		String x7 = "/one/two/three/five/@david";
		String x8 = "/one/two/three/@david";
		
		SimpleXPath x = new SimpleXPath();
		x.defineNSPrefix(ns1);
		x.defineNSPrefix(ns2);
		x.defineNSPrefix(ns3);
		
		x.defineXPath("foo",x1);
		x.defineXPath("bar",x2);
		x.defineXPath("baz",x3);
		x.defineXPath("baz1",x4);
		x.defineXPath("baz2",x5);	
		x.defineXPath("baz3",x6);	
		x.defineXPath("baz4",x7);
		x.defineXPath("baz5",x8);
		
                PushStepResult res = null;
		for (int i = 0; i < 100; i++) {
			res = x.pushStep("http://valero.com","one"); 
			assertTrue(res.matchingNames.length == 0,"test1.1 "+i);
			res = x.pushStep("http://valero.com","two");
			assertTrue(res.matchingNames.length == 0,"test1.2 "+i);
			res = x.pushStep("http://valero.com","three");
			assertTrue(res.matchingNames[0].equals("foo"),"test1.3 "+i);
			x.reset();
	
			res = x.pushStep("http://valero.com","one");
			assertTrue(res.matchingNames.length == 0,"test2.1 "+i);
                        
			res = x.pushStep("http://valero.com","two");
			assertTrue(res.matchingNames.length == 0,"test2.2 "+i);
                        
			res = x.pushStep("http://valero.com","x");
			assertTrue(res.matchingNames.length == 0l,"test2.3 "+i);
                        if (res.requiredElement)
                            x.popStep();
                        
			res = x.pushStep("http://valero.com","three");
			assertTrue(res.matchingNames[0].equals("foo"),"test2.4 "+i);
			x.reset();
			
			res = x.pushStep("http://valero.com","one");
			assertTrue(res.matchingNames.length == 0,"test3.1 "+i);

			res = x.pushStep("http://valero.com","two");
			assertTrue(res.matchingNames.length == 0,"test3.2 "+i);
                        
			res = x.pushStep("http://valero.com","three");
                        boolean popReqd = res.requiredElement;
			assertTrue(res.matchingNames[0].equals("foo"),"test3.3 "+i);
			res = x.pushStep("http://valero.com","five");
			assertTrue(res.matchingNames[0].equals("baz"),"test3.4 "+i);
                        if (res.requiredElement)
                            x.popStep();
                        if (popReqd)
                            x.popStep();
			res = x.pushStep("http://valero.com","three");
			assertTrue(res.matchingNames[0].equals("foo"),"test3.5 "+i);
			res = x.pushStep("http://valero.com","four");
			assertTrue(res.matchingNames[0].equals("bar"),"test3.6 "+i);
			x.reset();
			
			res = x.pushStep("http://verifone.com","david");
			assertTrue(res.matchingNames.length == 0,"test4.1 "+i);
			res = x.pushStep("","bruce");
			assertTrue(res.matchingNames.length == 0,"test4.2 "+i);
			res = x.pushStep("http://valero.com","ezell");
			assertTrue(res.matchingNames[0].equals("baz1"),"test4.3 "+i);
			x.reset();
			
			res = x.pushStep("http://verifone.com","david");
			assertTrue(res.matchingNames.length == 0,"test5.1 "+i);
			res = x.pushStep("","bruce");
			assertTrue(res.matchingNames.length == 0,"test5.2 "+i);
			res = x.pushStep("http://valero.com","ezell");
			assertTrue(res.matchingNames[0].equals("baz1"),"test5.3 "+i);
			AttributesImpl a = new AttributesImpl();
			a.addAttribute("http://verifone.com","bar","","","");
			a.addAttribute("","foo","","","");

			String resAr[] = null;
			resAr = x.checkAttributes(a);
			assertTrue(resAr.length == 2,"test6.1"+i);
			assertTrue(resAr[0].equals("baz3"),"test6.2"+i);
			assertTrue(resAr[1].equals("baz2"),"test6.3"+i);
			x.reset();
		}
                System.out.println("Done");
	}
	
	//
	// for testing only
	//
	private static void assertTrue(boolean isOK,String onErr) throws Exception {
		if (!isOK) throw new Exception (onErr);
	}

}
