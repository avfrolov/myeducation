package org.myeducation.taskexecuter.core.processor.circuit.validator.required;

import org.apache.log4j.Logger;
import org.myeducation.properties.PropertiesFactory;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rules;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.validator.CircuitValidator;
import org.myeducation.taskexecuter.core.processor.circuit.validator.RuleValidator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 11.05.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class SchemaValidator implements CircuitValidator, RuleValidator {

    private static final Logger LOGGER = Logger.getLogger(SchemaValidator.class);

    @Override
    public boolean validate(Circuit circuit) {
        return validate(circuit, PropertiesFactory.getProperties("processors").getProperty("processor.circuit.circuit.path"));
    }

    @Override
    public boolean validate(Rules rules) {
        return validate(rules, PropertiesFactory.getProperties("processors").getProperty("processor.circuit.rules.path"));
    }

    private boolean validate(Object object, String pathToXsdSchema) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema xsdSchema = schemaFactory.newSchema(new File(pathToXsdSchema));

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setSchema(xsdSchema);
            marshaller.marshal(object, System.out);
            marshaller.marshal(object, new DefaultHandler());  // DefaultHandler use a "/dev/null" implementation of a SAX processor

            return true;
        } catch (JAXBException je) {
            LOGGER.error("Object " + object.toString() + " not valid", je);
            return false;
        } catch (SAXException e) {
            LOGGER.error("XML Schema by path: " + pathToXsdSchema + " not found", e);
            return false;
        }
    }
}
