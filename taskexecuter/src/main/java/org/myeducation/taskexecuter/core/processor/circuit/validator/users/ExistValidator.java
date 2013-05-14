package org.myeducation.taskexecuter.core.processor.circuit.validator.users;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rules;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.validator.UserValidator;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 11.05.13
 * Time: 22:23
 * To change this template use File | Settings | File Templates.
 */
public class ExistValidator implements UserValidator {

    @Override
    public boolean validate(Circuit circuit, Rules rules) {
        return false;
    }
}
