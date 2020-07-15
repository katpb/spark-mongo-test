package com.verifone.isd.vsms2.sys.util.log4j;

import java.util.Stack;
import org.apache.log4j.Layout;
/**
 *  Class extracted from EPSHtmlLayout.java for processing XML Tags.
 */
public class DisplayXML
{

    final static int BEGINTAG = 1;
    final static int ENDTAG = 2;
    final static int READINGDATA = 3;
    StringBuffer sbuf;
    int current_state = READINGDATA;
    int last_state = READINGDATA;
    String xmlString;
    Stack<Integer> hmap = new Stack<Integer>();

    public DisplayXML(StringBuffer sbuf, String theXML)
    {
        this.sbuf = sbuf;
        xmlString = theXML;
    }

    public void processXML()
    {
        int len = xmlString.length();
        int idx;
        StringBuilder tmpString = new StringBuilder();
        for (idx = 0; idx < len; idx++)
        {
            if (xmlString.charAt(idx) == '<')
            {
                tmpString.append(xmlString.charAt(idx));
                if (xmlString.length() > idx + 1)
                {
                    // End Tag
                    if (xmlString.charAt(idx + 1) == '/' || xmlString.
                            charAt(idx + 1) == '?')
                    {
                        current_state = ENDTAG;
                    } // New Tag
                    else
                    {
                        current_state = BEGINTAG;
                    }
                }
            } else if (xmlString.charAt(idx) == '>')
            {
                tmpString.append(xmlString.charAt(idx));
                if (idx >= 1 && (xmlString.charAt(idx - 1) == '/'))
                {
                    current_state = ENDTAG;
                    processBeginTAG(tmpString.toString());
                } else if (current_state == ENDTAG)
                {
                    processEndTAG(tmpString.toString());
                    current_state = READINGDATA;
                } else
                {
                    processBeginTAG(tmpString.toString());
                }
                tmpString = new StringBuilder();
                current_state = READINGDATA;
            } else if (xmlString.charAt(idx) == 0x09
                       || xmlString.charAt(idx) == 0x0A
                       || xmlString.charAt(idx) == 0x0D)
            {
                continue;
            } else
            {
                tmpString.append(xmlString.charAt(idx));
            }
        }
    }

    private void processBeginTAG(String tmpStr)
    {
        int numTabs;
        StringBuilder strAux = new StringBuilder();
        strAux.append(Layout.LINE_SEP);

        if (hmap.size() > 0)
        {
            numTabs = (hmap.peek()).intValue();
        } else
        {
            numTabs = 0;
        }
        if (tmpStr.length() > 0)
        {
            for (int i = 0; i < numTabs; i++)
            {
                strAux.append("\t");
            }
            strAux.append(tmpStr);
            sbuf.append(strAux.toString());

            if (current_state != ENDTAG)
            {
                hmap.push(new Integer(numTabs + 1));
                last_state = ENDTAG;
            }
        }
        last_state = BEGINTAG;
    }

    private void processEndTAG(String tmpStr)
    {
        int numTabs = 0;
        if (current_state == ENDTAG && tmpStr.length() > 0)
        {
            StringBuilder strAux = new StringBuilder();
            if (hmap.size() > 0)
            {
                numTabs = (hmap.pop()).intValue() - 1;
            }
            if (last_state == ENDTAG)
            {
                strAux.append(Layout.LINE_SEP);
                for (int i = 0; i < numTabs; i++)
                {
                    strAux.append("\t");
                }
                hmap.push(new Integer(numTabs));
            }

            strAux.append(tmpStr);
            sbuf.append(strAux.toString());
        }
        last_state = ENDTAG;
    }
}