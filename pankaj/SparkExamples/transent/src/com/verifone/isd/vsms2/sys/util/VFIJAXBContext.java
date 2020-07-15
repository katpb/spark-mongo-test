package com.verifone.isd.vsms2.sys.util;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Utility class to return a singleton instance of JAXBContext for the given package name. The application
 * can invoke the newInstance() method without worrying about the JAXBContext instances growing in an 
 * unbounded manner.
 * 
 * @author Bhanu_A1, maintained by Anindya_D1
 *
 */
public class VFIJAXBContext {
    private static final Map<String, JAXBContext> CONTEXTS = new HashMap<String, JAXBContext>();
    
    /**
     * Provide the caller with an instance of JAXBContext for the given package.
     * 
     * @param contextPath JAXB package name
     * @return singleton instance of JAXBContext for the given package
     * @throws JAXBException
     */
	public static synchronized JAXBContext newInstance(String contextPath)
			throws JAXBException {
		JAXBContext ctx = CONTEXTS.get(contextPath);
		if (ctx == null) {
			ctx = JAXBContext.newInstance(contextPath);
			CONTEXTS.put(contextPath, ctx);
		}
		return ctx;
	}
}
