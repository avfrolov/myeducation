package processor.circuit.validator;

import org.junit.Assert;
import org.junit.Test;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rule;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.RuleType;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.validator.users.EnabledValidator;
import processor.circuit.helper.CircuitHelper;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 21.05.13
 * Time: 18:16
 * To change this template use File | Settings | File Templates.
 */
public class EnabledValidatorTest {

    @Test
    public void testCorrect1() throws Exception {
        EnabledValidator validator = new EnabledValidator();
        Circuit c = CircuitHelper.create();
        Rule rule = new Rule();
        rule.setType(RuleType.ENABLED);
        Assert.assertTrue(validator.validate(c, rule));
    }

    @Test
    public void testCorrect2() throws Exception {
        EnabledValidator validator = new EnabledValidator();
        Circuit c = CircuitHelper.create();
        c.getNode().get(4).getElements().getSwitch().clear();
        Rule rule = new Rule();
        rule.setType(RuleType.ENABLED);
        Assert.assertTrue(validator.validate(c, rule));
    }

    @Test
    public void testIncorrect1() throws Exception {
        EnabledValidator validator = new EnabledValidator();
        Circuit c = CircuitHelper.create();
        c.getNode().get(4).getElements().getSwitch().iterator().next().setEnabled(false);
        Rule rule = new Rule();
        rule.setType(RuleType.ENABLED);
        Assert.assertFalse(validator.validate(c, rule));
    }


}
