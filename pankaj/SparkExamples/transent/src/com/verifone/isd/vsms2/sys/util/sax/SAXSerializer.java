/*
 * SAXSerializer.java
 *
 * Created on March 9, 2004, 4:42 PM
 */
package com.verifone.isd.vsms2.sys.util.sax;

import java.io.OutputStream;
import java.io.Writer;

import org.apache.xml.serialize.XMLSerializer;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;
import org.apache.xml.serialize.OutputFormat;

/**
 * Simple wrapper class to replace invalid characters (characters < 0x20 and characters
 * > 0x&E) with a space. These characters are converted to entity references by
 * xerces. This would result in the document being treated as invalid xml by the
 * browser to apply transforms.
 *
 * <p>
 * NEED TO REVISIT this character validation logic when xml is to be generated
 * using a different char encoding than UTF-8. </p>
 *
 * @author Bhanu_N2
 */
class SAXSerializer extends XMLSerializer {

    private boolean preserveWhiteSpace;

    SAXSerializer(Writer writer, OutputFormat format, boolean preserveWhiteSpace) {
        this(writer, format);
        this.preserveWhiteSpace = preserveWhiteSpace;
    }

    /**
     * Creates a new instance of SAXSerializer
     *
     * @param writer writer for xml serialization
     * @param format output format for serialization
     */
    SAXSerializer(Writer writer, OutputFormat format) {
        super(writer, format);
    }

    SAXSerializer(OutputStream out, OutputFormat format, boolean preserveWhiteSpace) {
        this(out, format);
        this.preserveWhiteSpace = preserveWhiteSpace;
    }
    
    SAXSerializer(OutputStream out, OutputFormat format) {
        super(out, format);
    }    

    /**
     * Overrides base class method to replace invalid characters with a space.
     * Note that this logic will not work as is when char encodings other than
     * UTF-8 are to be supported.
     *
     * @param chars array holding character content
     * @param beginOffset begin offset of character content
     * @param endOffset end offset of character content
     * @throws org.xml.sax.SAXException on error thrown by the parent class
     */
    @Override
    public void characters(char[] chars, int beginOffset, int endOffset) throws SAXException {
        for (int i = beginOffset; i < endOffset; i++) {
            if (chars[i] < ' ' || chars[i] > '~') {
                if (!(preserveWhiteSpace && Character.isWhitespace(chars[i]))) {
                    chars[i] = ' ';
                }
            }
        }
        super.characters(chars, beginOffset, endOffset);
    }

    /**
     * Overrides base class method to replace invalid characters in the
     * attribute values with a space. Note that this logic will not work as is
     * when char encodings other than UTF-8 are to be supported.
     *
     * @param namespaceURI namespace of the element
     * @param localName local name of the element
     * @param rawName raw name of the element
     * @param attrs attributes on the element
     * @throws org.xml.sax.SAXException on error thrown by the parent class
     */
    @Override
    public void startElement(String namespaceURI, String localName, String rawName,
            Attributes attrs) throws SAXException {
        if (attrs instanceof AttributesImpl) {
            AttributesImpl attrsImpl = (AttributesImpl) attrs;
            int numAttrs = attrsImpl.getLength();
            for (int i = 0; i < numAttrs; i++) {
                String val = attrsImpl.getValue(i);
                if (val != null) {
                    char[] chars = val.toCharArray();
                    int strLen = chars.length;
                    boolean modified = false;
                    for (int k = 0; k < strLen; k++) {
                        if (chars[k] < ' ' || chars[k] > '~') {
                            chars[k] = ' ';
                            modified = true;
                        }
                    }
                    if (modified) {
                        attrsImpl.setValue(i, new String(chars));
                    }
                }
            }
        }
        super.startElement(namespaceURI, localName, rawName, attrs);
    }
}
