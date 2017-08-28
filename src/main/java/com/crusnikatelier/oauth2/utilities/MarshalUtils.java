package com.crusnikatelier.oauth2.utilities;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class MarshalUtils {
	private MarshalUtils () { }
	
	public static <T> String marshal(T obj) throws JAXBException{
		StringWriter stringWriter = new StringWriter();
		marshal(obj, stringWriter);
		return stringWriter.toString();
	}
	
	public static <T> void marshal(T obj, Writer writer) throws JAXBException{
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller m = context.createMarshaller();

		//This makes things readable.
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(obj, writer);
	}
	
	/**
	 * Deserializes a string to specified object.
	 * @param xml string to deserialize
	 * @param clazzs class we will deserialize to
	 * @return
	 * @throws JAXBException if Object cannot be deserialized
	 */
	public static <T> T unmarshal(String xml, Class<T> clazz) throws JAXBException{
		try{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource xmlSource = new InputSource(new StringReader(xml));
			Document doc = dBuilder.parse(xmlSource);
			
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			JAXBElement<T> element = unmarshaller.unmarshal(doc, clazz);
			return element.getValue();
		} 
		catch(IOException | ParserConfigurationException e){
			//This should not occur ever
			throw new IllegalStateException("Unable to read document", e);
		}
		catch (SAXException e) {
			//The Xml input is not formatted properly.
			throw new IllegalArgumentException("Illegal Xml input", e);
		}
	}
}
