package org.myeducation.taskexecuter.core.processor.circuit.validator.required;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Element;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Node;
import org.myeducation.taskexecuter.core.processor.circuit.validator.CircuitValidator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 16.05.13
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class NameValidator implements CircuitValidator {

    private Set<String> names = new HashSet<String>();

    @Override
    public boolean validate(Circuit circuit) {
        boolean result = true;
        for (Node node : circuit.getNode()) {
            result = validate(node.getElements().getCapacitor()) &&
                    validate(node.getElements().getResistor()) &&
                    validate(node.getElements().getInductor()) &&
                    validate(node.getElements().getTransistor()) &&
                    validate(node.getElements().getDiode()) &&
                    validate(node.getElements().getSwitch());
            if (!result) {
                break;
            }
        }

        return result;
    }

    private boolean validate(List<? extends Element> elements) {
        for (Element element : elements) {
            if (!names.contains(element.getName())) {
                names.add(element.getName());
            } else {
                return false;
            }
        }
        return true;
    }
}
