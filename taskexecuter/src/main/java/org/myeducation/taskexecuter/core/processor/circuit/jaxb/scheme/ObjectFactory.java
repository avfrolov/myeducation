
package org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Circuit_QNAME = new QName("http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/", "circuit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Capacitor }
     * 
     */
    public Capacitor createCapacitor() {
        return new Capacitor();
    }

    /**
     * Create an instance of {@link Inductor }
     * 
     */
    public Inductor createInductor() {
        return new Inductor();
    }

    /**
     * Create an instance of {@link Elements }
     * 
     */
    public Elements createElements() {
        return new Elements();
    }

    /**
     * Create an instance of {@link Transistor }
     * 
     */
    public Transistor createTransistor() {
        return new Transistor();
    }

    /**
     * Create an instance of {@link Circuit }
     * 
     */
    public Circuit createCircuit() {
        return new Circuit();
    }

    /**
     * Create an instance of {@link Resistor }
     * 
     */
    public Resistor createResistor() {
        return new Resistor();
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link Diode }
     * 
     */
    public Diode createDiode() {
        return new Diode();
    }

    /**
     * Create an instance of {@link Switch }
     * 
     */
    public Switch createSwitch() {
        return new Switch();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Circuit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/", name = "circuit")
    public JAXBElement<Circuit> createCircuit(Circuit value) {
        return new JAXBElement<Circuit>(_Circuit_QNAME, Circuit.class, null, value);
    }

}
