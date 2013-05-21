package org.myeducation.taskexecuter.core.processor.circuit.validator.users;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rule;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Node;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Switch;
import org.myeducation.taskexecuter.core.processor.circuit.validator.UserValidator;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 21.05.13
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
public class EnabledValidator implements UserValidator {

    @Override
    public boolean validate(Circuit circuit, Rule rule) {
        for (Node node : circuit.getNode()) {
            for (Switch sw : node.getElements().getSwitch()) {
                if (!sw.isEnabled()) {
                    return false;
                }
            }
        }
        return true;
    }
}
