package org.myeducation.taskexecuter.core.processor.circuit.validator;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.RuleType;
import org.myeducation.taskexecuter.core.processor.circuit.validator.users.EnabledValidator;
import org.myeducation.taskexecuter.core.processor.circuit.validator.users.ExistValidator;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 11.05.13
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
public class UserValidatorFactory {

    public synchronized static UserValidator getValidator(RuleType type) {
        UserValidator validator;
        switch (type) {
            case EXIST:
                validator = new ExistValidator();
                break;
            case ENABLED:
                validator = new EnabledValidator();
                break;
            default:
                throw new IllegalArgumentException("Rule type = " + type.name() + "doesn't supported");
        }

        return validator;
    }

}
