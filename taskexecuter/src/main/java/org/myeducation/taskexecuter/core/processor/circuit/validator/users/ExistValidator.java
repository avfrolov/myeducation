package org.myeducation.taskexecuter.core.processor.circuit.validator.users;

import org.apache.commons.lang.StringUtils;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Data;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rule;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.*;
import org.myeducation.taskexecuter.core.processor.circuit.validator.UserValidator;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 11.05.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class ExistValidator implements UserValidator {

    @Override
    public boolean validate(Circuit circuit, Rule rule) {
        switch (rule.getSubtype()) {
            case NAME:
                return validateByName(circuit.getNode(), rule.getData());
            case COUNT:
                return validateByCount(circuit.getNode(), rule.getData());
            case VALUE:
                return validateByValue(circuit.getNode(), rule.getData());
            default:
                throw new IllegalArgumentException("Rule subtype = " + rule.getSubtype() + " doesn't supported");
        }
    }

    private boolean validateByName(List<Node> nodes, Data data) {
        if (StringUtils.isEmpty(data.getValue())) {
            return false;
        }

        for (Node node : nodes) {
            switch (data.getElement()) {
                case CAPACITOR:
                    if (checkCollectionByName(node.getElements().getCapacitor(), data.getValue())) return true;
                    break;
                case DIODE:
                    if (checkCollectionByName(node.getElements().getDiode(), data.getValue())) return true;
                    break;
                case INDUCTOR:
                    if (checkCollectionByName(node.getElements().getInductor(), data.getValue())) return true;
                    break;
                case RESISTOR:
                    if (checkCollectionByName(node.getElements().getResistor(), data.getValue())) return true;
                    break;
                case SWITCH:
                    if (checkCollectionByName(node.getElements().getSwitch(), data.getValue())) return true;
                    break;
                case TRANSISTOR:
                    if (checkCollectionByName(node.getElements().getTransistor(), data.getValue())) return true;
                    break;
                default:
                    throw new IllegalArgumentException("ElementType = " + data.getElement() + "not supported");
            }
        }
        return false;
    }

    private boolean validateByValue(List<Node> nodes, Data data) {
        double value = 0;
        try {
            value = Double.valueOf(data.getValue());
        } catch (NumberFormatException nfe) {
            return false;
        }

        for (Node node : nodes) {
            switch (data.getElement()) {
                case CAPACITOR:
                    for (Capacitor capacitor : node.getElements().getCapacitor()) {
                        if (capacitor.getValue() == value) {
                            return true;
                        }
                    }
                    break;
                case DIODE:
                    for (Diode diode : node.getElements().getDiode()) {
                        if (diode.getMaxCurrent() == value || diode.getMaxPotential() == value) {
                            return true;
                        }
                    }
                    break;
                case INDUCTOR:
                    for (Inductor inductor : node.getElements().getInductor()) {
                        if (inductor.getValue() == value) {
                            return true;
                        }
                    }
                    break;
                case RESISTOR:
                    for (Resistor resistor : node.getElements().getResistor()) {
                        if (resistor.getValue() == value) {
                            return true;
                        }
                    }
                    break;
                case TRANSISTOR:
                    for (Transistor transistor : node.getElements().getTransistor()) {
                        if (transistor.getGain() == (int) value) {
                            return true;
                        }
                    }
                    break;
                case SWITCH:
                    boolean en;
                    try {
                         en = Boolean.valueOf(data.getValue());
                    } catch (RuntimeException re) {
                        return false;
                    }

                    for (Switch mSwitch : node.getElements().getSwitch()) {
                        if (mSwitch.isEnabled() == en) {
                            return true;
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("ElementType = " + data.getElement() + "not supported");
            }
        }
        return false;
    }

    private boolean validateByCount(List<Node> nodes, Data data) {
        if (data == null) {
            return false;
        }

        try {
            Double.valueOf(data.getValue());
        } catch (RuntimeException re) {
            return false;
        }

        int count = 0;
        for (Node node : nodes) {
            System.out.println("lol");
            switch (data.getElement()) {
                case CAPACITOR:
                    count += node.getElements().getCapacitor().size();
                    break;
                case DIODE:
                    count += node.getElements().getDiode().size();
                    break;
                case INDUCTOR:
                    count += node.getElements().getInductor().size();
                    break;
                case RESISTOR:
                    count += node.getElements().getResistor().size();
                    break;
                case SWITCH:
                    count += node.getElements().getSwitch().size();
                    break;
                case TRANSISTOR:
                    count += node.getElements().getTransistor().size();
                    break;
                default:
                    throw new IllegalArgumentException("ElementType = " + data.getElement() + "not supported");
            }
        }

        return Integer.valueOf(data.getValue()) == count;
    }

    private boolean checkCollectionByName(List<? extends Element> elements, String name) {
        for (Element element : elements) {
            if (element.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
