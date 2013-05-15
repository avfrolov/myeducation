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
                    if (checkCollectionByName(node.getElements().getCapacitors(), data.getValue())) return true;
                    break;
                case DIODE:
                    if (checkCollectionByName(node.getElements().getDiodes(), data.getValue())) return true;
                    break;
                case INDUCTOR:
                    if (checkCollectionByName(node.getElements().getInductors(), data.getValue())) return true;
                    break;
                case RESISTOR:
                    if (checkCollectionByName(node.getElements().getResistors(), data.getValue())) return true;
                    break;
                case SWITCH:
                    if (checkCollectionByName(node.getElements().getSwitches(), data.getValue())) return true;
                    break;
                case TRANSISTOR:
                    if (checkCollectionByName(node.getElements().getTransistors(), data.getValue())) return true;
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
                    if (checkCollectionByValue(node.getElements().getCapacitors(), value)) return true;
                    break;
                case DIODE:
                    if (checkCollectionByValue(node.getElements().getDiodes(), value)) return true;
                    break;
                case INDUCTOR:
                    if (checkCollectionByValue(node.getElements().getInductors(), value)) return true;
                    break;
                case RESISTOR:
                    if (checkCollectionByValue(node.getElements().getResistors(), value)) return true;
                    break;
                case TRANSISTOR:
                    if (checkCollectionByValue(node.getElements().getTransistors(), value)) return true;
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

        for (Node node : nodes) {
            switch (data.getElement()) {
                case CAPACITOR:
                    if (Integer.valueOf(data.getValue()) == node.getElements().getCapacitors().size()) return true;
                    break;
                case DIODE:
                    if (Integer.valueOf(data.getValue()) == node.getElements().getDiodes().size()) return true;
                    break;
                case INDUCTOR:
                    if (Integer.valueOf(data.getValue()) == node.getElements().getInductors().size()) return true;
                    break;
                case RESISTOR:
                    if (Integer.valueOf(data.getValue()) == node.getElements().getResistors().size()) return true;
                    break;
                case SWITCH:
                    if (Integer.valueOf(data.getValue()) == node.getElements().getSwitches().size()) return true;
                    break;
                case TRANSISTOR:
                    if (Integer.valueOf(data.getValue()) == node.getElements().getTransistors().size()) return true;
                    break;
                default:
                    throw new IllegalArgumentException("ElementType = " + data.getElement() + "not supported");
            }
        }
        return false;
    }

    private boolean checkCollectionByName(List<? extends Element> elements, String name) {
        for (Element element : elements) {
            if (element.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCollectionByValue(List<? extends Element> elements, Double value) {
        for (Element element : elements) {
            if (element.getValue() == value) {
                return true;
            }
        }
        return false;
    }

}
