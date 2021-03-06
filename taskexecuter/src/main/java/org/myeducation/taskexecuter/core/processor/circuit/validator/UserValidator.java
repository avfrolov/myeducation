package org.myeducation.taskexecuter.core.processor.circuit.validator;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rule;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
public interface UserValidator extends AbstractValidator{

    boolean validate(Circuit circuit, Rule rule);

}
