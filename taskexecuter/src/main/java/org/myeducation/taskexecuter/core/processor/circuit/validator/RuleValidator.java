package org.myeducation.taskexecuter.core.processor.circuit.validator;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rules;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public interface RuleValidator {

    boolean validate(Rules rules);

}
