package org.myeducation.taskexecuter.core.processor.circuit.transformator;

import org.apache.log4j.Logger;
import org.myeducation.properties.PropertiesFactory;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rules;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 11.05.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class Transformator {

    private static final Logger LOGGER = Logger.getLogger(Transformator.class);

    public static File circuit2File(Circuit circuit) {
        return marshaller(circuit,
                PropertiesFactory.getProperties("processors").getProperty("processor.circuit.circuit.path"));
    }

    public static File rules2File(Rules rules) {
        return marshaller(rules,
                PropertiesFactory.getProperties("processors").getProperty("processor.circuit.rules.path"));
    }

    public static Circuit file2Circuit(File file) {
        return (Circuit) unmarshaller(file,
                PropertiesFactory.getProperties("processors").getProperty("processor.circuit.circuit.path"), Circuit.class);
    }

    public static Rules file2Rules(File file) {
        return (Rules) unmarshaller(file,
                PropertiesFactory.getProperties("processors").getProperty("processor.circuit.rules.path"), Rules.class);
    }

    private static File marshaller(Object object, String pathToXsdSchema) {
        try {
            File file = File.createTempFile("temp", "");
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema xsdSchema = schemaFactory.newSchema(new File(pathToXsdSchema));

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setSchema(xsdSchema);
            marshaller.marshal(object, file);

            return file;
        } catch (JAXBException je) {
            LOGGER.error("Object " + object.toString() + " not valid", je);
            return null;
        } catch (SAXException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        } catch (IOException e) {
            LOGGER.error("Can't create temp file", e);
            return null;
        }
    }

    private static Object unmarshaller(File file, String pathToXsdSchema, Class clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema xsdSchema = schemaFactory.newSchema(new File(pathToXsdSchema));
            unmarshaller.setSchema(xsdSchema);
            Object o = unmarshaller.unmarshal(file);
            return o;
        } catch (JAXBException e) {
            LOGGER.error("File " + file.toString() + "doesn't contain a valid XML-Document", e);
            return null;
        } catch (SAXException e) {
            LOGGER.error(e.getMessage(), e);
            return null;
        }
    }
}
