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
        boolean result;
        switch (rule.getSubtype()) {
            case NAME:
                result = validateByName(circuit.getNode(), rule.getData());
                break;
            case COUNT:
                result = validateByCount(circuit.getNode(), rule.getData());
                break;
            case VALUE:
                result = validateByValue(circuit.getNode(), rule.getData());
                break;
            default:
                throw new IllegalArgumentException("Rule subtype = " + rule.getSubtype() + " doesn't supported");
        }
        return result;
    }

    private boolean validateByName(List<Node> nodes, Data data) {

        if (StringUtils.isEmpty(data.getValue())) {
            return false;
        }

        for (Node node : nodes) {
            switch (data.getElement()) {
                case CAPACITOR:
                    for (Capacitor capacitor : node.getElements().getCapacitors()) {
                        if (capacitor.getName().equalsIgnoreCase(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case DIODE:
                    for (Diode diode : node.getElements().getDiodes()) {
                        if (diode.getName().equalsIgnoreCase(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case INDUCTOR:
                    for (Inductor inductor : node.getElements().getInductors()) {
                        if (inductor.getName().equalsIgnoreCase(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case RESISTOR:
                    for (Resistor resistor : node.getElements().getResistors()) {
                        if (resistor.getName().equalsIgnoreCase(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case SWITCH:
                    for (Switch mSwitch : node.getElements().getSwitches()) {
                        if (mSwitch.getName().equalsIgnoreCase(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case TRANSISTOR:
                    for (Transistor transistor : node.getElements().getTransistors()) {
                        if (transistor.getName().equalsIgnoreCase(data.getValue())) {
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

    private boolean validateByValue(List<Node> nodes, Data data) {

        try {
            Double.valueOf(data.getValue());
        } catch (NumberFormatException nfe) {
            return false;
        }

        for (Node node : nodes) {
            switch (data.getElement()) {
                case CAPACITOR:
                    for (Capacitor capacitor : node.getElements().getCapacitors()) {
                        if (capacitor.getValue() == Double.valueOf(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case DIODE:
                    for (Diode diode : node.getElements().getDiodes()) {
                        if (diode.getMaxCurrent() == Double.valueOf(data.getValue()) ||
                                diode.getMaxPotential() == Double.valueOf(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case INDUCTOR:
                    for (Inductor inductor : node.getElements().getInductors()) {
                        if (inductor.getValue() == Double.valueOf(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case RESISTOR:
                    for (Resistor resistor : node.getElements().getResistors()) {
                        if (resistor.getValue() == Double.valueOf(data.getValue())) {
                            return true;
                        }
                    }
                    break;

                case TRANSISTOR:
                    for (Transistor transistor : node.getElements().getTransistors()) {
                        if (transistor.getGain() == Integer.valueOf(data.getValue())) {
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

        for (Node node : nodes) {
            switch (data.getElement()) {
                case CAPACITOR:
                    return Integer.valueOf(data.getValue()) == node.getElements().getCapacitors().size();

                case DIODE:
                    return Integer.valueOf(data.getValue()) == node.getElements().getDiodes().size();

                case INDUCTOR:
                    return Integer.valueOf(data.getValue()) == node.getElements().getInductors().size();

                case RESISTOR:
                    return Integer.valueOf(data.getValue()) == node.getElements().getResistors().size();

                case SWITCH:
                    return Integer.valueOf(data.getValue()) == node.getElements().getSwitches().size();

                case TRANSISTOR:
                    return Integer.valueOf(data.getValue()) == node.getElements().getTransistors().size();

                default:
                    throw new IllegalArgumentException("ElementType = " + data.getElement() + "not supported");
            }
        }
        return false;
    }

}
