package com.verifone.isd.vsms2.sys.util;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;

/**
 * Utility methods to obtain a secure instance of XMLInputFactory.
 * @author David_G3
 */
public class SecureXMLInputFactory {
    
    private SecureXMLInputFactory() {
    }

    /**
     * Obtain a new instance of a XMLInputFactory but preconfigured for secure parsing.
     * @return instance of a XMLInputFactory
     * @throws FactoryConfigurationError on failure
     */
    public static XMLInputFactory newXIFInstance() throws FactoryConfigurationError {
        return buildXIFFactory(null, null);
    }

    /**
     * Obtain a new instance of a XMLInputFactory but preconfigured for secure parsing.
     * @return instance of a XMLInputFactory
     * @throws FactoryConfigurationError on failure
     */
    public static XMLInputFactory newXIFFactory() throws FactoryConfigurationError {
        return buildXIFFactory(null, null);
    }

    /**
     * Obtain a new instance of a XMLInputFactory but preconfigured for secure parsing.
     * @param factoryId Name of the factory to find, same as a property name.
     * @param classLoader ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class.
     * @return instance of a XMLInputFactory
     * @throws FactoryConfigurationError on failure
     * 
     * @deprecated since XMLInputFactory.newInstance() is deprecated, use {@link #newXIFFactory()} instead.
     */
    @Deprecated
    public static XMLInputFactory newXIFInstance(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        return buildXIFFactory(factoryId, classLoader);
    }
    
    /**
     * Obtain a new instance of a XMLInputFactory but preconfigured for secure parsing.
     * @param factoryId Name of the factory to find, same as a property name.
     * @param classLoader ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class.
     * @return instance of a XMLInputFactory
     * @throws FactoryConfigurationError on failure
     */
    public static XMLInputFactory newXIFFactory(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        return buildXIFFactory(factoryId, classLoader);
    }
    
    /**
     * Obtain a new instance of a XMLInputFactory but preconfigured for secure parsing.
     * @param factoryId Name of the factory to find, same as a property name.
     * @param classLoader ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class.
     * @return instance of a XMLInputFactory
     * @throws FactoryConfigurationError on failure
     */
    private static XMLInputFactory buildXIFFactory(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        XMLInputFactory factory = null;
        if (factoryId == null) {
            factory = XMLInputFactory.newInstance();
        } else {
            factory = XMLInputFactory.newFactory(factoryId, classLoader);
        }
        // Unfortunately SonarQube expects the statements below to be immediately after the line above, cannot move to private method
        // This disables DTDs entirely for that factory
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false); 
        // disable external entities
        factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        return factory;
    }
}
