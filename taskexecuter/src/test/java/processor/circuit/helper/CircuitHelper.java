package processor.circuit.helper;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.*;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 *
 * It's following circuit scheme
 *
 *
 * 1-----R1-----4-------C1-----2
 * |            |              |
 * |            |              |
 * |            L1             SW1
 * |            |              |
 * |            |              |
 * |            |              |
 * -----TR1-----3---------------
 */
public class CircuitHelper {

    public static Circuit create() {
        Circuit c = new Circuit();
        c.getNode().add(createNode(1, 4, createElements14()));
        c.getNode().add(createNode(1, 3, createElements13()));
        c.getNode().add(createNode(4, 2, createElements42()));
        c.getNode().add(createNode(4, 3, createElements43()));
        c.getNode().add(createNode(2, 3, createElements23()));
        return c;
    }

    public static Node createNode(int from, int to, Elements elements) {
        Node node = new Node();
        node.setElements(elements);
        node.setFrom(from);
        node.setTo(to);
        return node;
    }

    public static Elements createElements14() {
        Elements elements = new Elements();
        elements.getResistor().add(createResistor());
        return elements;
    }

    public static Elements createElements13() {
        Elements elements = new Elements();
        elements.getTransistor().add(createTransistor());
        return elements;
    }

    public static Elements createElements42() {
        Elements elements = new Elements();
        elements.getCapacitor().add(createCapacitor());
        return elements;
    }

    public static Elements createElements43() {
        Elements elements = new Elements();
        elements.getInductor().add(createInductor());
        return elements;
    }

    public static Elements createElements23() {
        Elements elements = new Elements();
        elements.getSwitch().add(createSwitch());
        return elements;
    }

    public static Resistor createResistor() {
        Resistor resistor = new Resistor();
        resistor.setValue(1.5);
        resistor.setCountOfInputs(2);
        resistor.setName("R1");
        return resistor;
    }

    public static Capacitor createCapacitor() {
        Capacitor capacitor = new Capacitor();
        capacitor.setName("C1");
        capacitor.setCountOfInputs(2);
        capacitor.setValue(0.001);
        return capacitor;
    }

    public static Inductor createInductor() {
        Inductor inductor = new Inductor();
        inductor.setName("L1");
        inductor.setCountOfInputs(2);
        inductor.setValue(10);
        return inductor;
    }

    public static Transistor createTransistor() {
        Transistor transistor = new Transistor();
        transistor.setCountOfInputs(2);
        transistor.setName("tr1");
        transistor.setGain(2);
        return transistor;
    }

    public static Diode createDiode() {
        Diode diode = new Diode();
        diode.setCountOfInputs(2);
        diode.setName("d1");
        diode.setMaxCurrent(10);
        diode.setMaxPotential(10);
        return diode;
    }

    public static Switch createSwitch() {
        Switch mSwitch = new Switch();
        mSwitch.setEnabled(true);
        mSwitch.setName("sw1");
        mSwitch.setCountOfInputs(2);
        return mSwitch;
    }



}
