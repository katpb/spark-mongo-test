package com.verifone.ptc;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.SchemaFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import com.transset.Trans;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import static java.lang.System.out;
import static java.lang.System.err;

public class TransactionXMLToJSONConverter {

	public static void main(String[] args) {
//		XmlMapper xmlMapper = new XmlMapper();
//	    xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//		XMLInputFactory xmlif = XMLInputFactory.newFactory();
//		FileReader fr;
//		try {
//			fr = new FileReader("T2.xml");
//			XMLStreamReader xmlsr = xmlif.createXMLStreamReader(fr);
//			Trans planet = xmlMapper.readValue(xmlsr, Trans.class);
//			ObjectMapper jsonMapper = new ObjectMapper();
//			String json = jsonMapper.writeValueAsString(planet);
//			System.out.println(json);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (XMLStreamException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

	      final TransactionXMLToJSONConverter instance = new TransactionXMLToJSONConverter();
	      final String fullyQualifiedClassName = "com.transset.Trans";
	      final ObjectMapper objectMapper = instance.createJaxbObjectMapper();
	      instance.writeToStandardOutputWithDeprecatedJsonSchema(objectMapper, fullyQualifiedClassName);

	}
	
	/**
	    * Create instance of ObjectMapper with JAXB introspector
	    * and default type factory.
	    *
	    * @return Instance of ObjectMapper with JAXB introspector
	    *    and default type factory.
	    */
	   private ObjectMapper createJaxbObjectMapper()
	   {
	      final ObjectMapper mapper = new ObjectMapper();
	      final TypeFactory typeFactory = TypeFactory.defaultInstance();
	      final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(typeFactory);
	      // make deserializer use JAXB annotations (only)
	      mapper.getDeserializationConfig().with(introspector);
	      // make serializer use JAXB annotations (only)
	      mapper.getSerializationConfig().with(introspector);
	      return mapper;
	   }
	   /**
	    * Write out JSON Schema based upon Java source code in
	    * class whose fully qualified package and class name have
	    * been provided.
	    *
	    * @param mapper Instance of ObjectMapper from which to
	    *     invoke JSON schema generation.
	    * @param fullyQualifiedClassName Name of Java class upon
	    *    which JSON Schema will be extracted.
	    */
	   private void writeToStandardOutputWithDeprecatedJsonSchema(
	      final ObjectMapper mapper, final String fullyQualifiedClassName)
	   {
	      try
	      {
	         final JsonSchema jsonSchema = mapper.generateJsonSchema(Class.forName(fullyQualifiedClassName));
	         out.println(jsonSchema);
	      }
	      catch (ClassNotFoundException cnfEx)
	      {
	         err.println("Unable to find class " + fullyQualifiedClassName);
	      }
	      catch (JsonMappingException jsonEx)
	      {
	         err.println("Unable to map JSON: " + jsonEx);
	      }
	   }

	
	
	/**
	 * Write out JSON Schema based upon Java source code in
	 * class whose fully qualified package and class name have
	 * been provided. This method uses the newer module JsonSchema
	 * class that replaces the deprecated databind JsonSchema.
	 *
	 * @param fullyQualifiedClassName Name of Java class upon
	 *    which JSON Schema will be extracted.
	 */
//	private void writeToStandardOutputWithModuleJsonSchema(
//	   final String fullyQualifiedClassName)
//	{
//	   final SchemaFactory visitor = new SchemaFactoryWrapper();
//	   final ObjectMapper mapper = new ObjectMapper();
//	   try
//	   {
//	      mapper.acceptJsonFormatVisitor(mapper.constructType(Class.forName(fullyQualifiedClassName)), visitor);
//	      final com.fasterxml.jackson.module.jsonSchema.JsonSchema jsonSchema = visitor.finalSchema();
//	      out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
//	   }
//	   catch (ClassNotFoundException cnfEx)
//	   {
//	      err.println("Unable to find class " + fullyQualifiedClassName);
//	   }
//	   catch (JsonMappingException jsonEx)
//	   {
//	      err.println("Unable to map JSON: " + jsonEx);
//	   }
//	   catch (JsonProcessingException jsonEx)
//	   {
//	      err.println("Unable to process JSON: " + jsonEx);
//	   }
//	}

}
