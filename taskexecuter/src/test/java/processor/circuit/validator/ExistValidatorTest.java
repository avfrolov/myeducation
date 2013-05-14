package processor.circuit.validator;

import org.junit.Assert;
import org.junit.Test;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.*;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.ElementType;
import org.myeducation.taskexecuter.core.processor.circuit.validator.users.ExistValidator;
import processor.circuit.helper.CircuitHelper;
import processor.circuit.helper.RulesHelper;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 14.05.13
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public class ExistValidatorTest {

    @Test
    public void testExistName1() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();

        Assert.assertTrue(validator.validate(c, r.getRule().get(0)));
    }

    @Test
    public void testExistName2() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        r.getRule().get(0).getData().setValue("");

        Assert.assertFalse(validator.validate(c, r.getRule().get(0)));
    }

    @Test
    public void testExistName3() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        r.getRule().get(0).getData().setValue(null);

        Assert.assertFalse(validator.validate(c, r.getRule().get(0)));
    }

    @Test
    public void testExistCount1() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        Rule rule = new Rule();
        rule.setType(RuleType.EXIST);
        rule.setSubtype(ExistSubType.COUNT);
        Data data = new Data();
        data.setElement(ElementType.RESISTOR);
        data.setValue("1");
        rule.setData(data);
        r.getRule().add(rule);

        Assert.assertTrue(validator.validate(c, r.getRule().get(1)));
    }


    @Test
    public void testExistCount2() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        Rule rule = new Rule();
        rule.setType(RuleType.EXIST);
        rule.setSubtype(ExistSubType.COUNT);
        Data data = new Data();
        data.setElement(ElementType.RESISTOR);
        data.setValue(null);
        rule.setData(data);
        r.getRule().add(rule);

        Assert.assertFalse(validator.validate(c, r.getRule().get(1)));
    }

    @Test
    public void testExistCount3() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        Rule rule = new Rule();
        rule.setType(RuleType.EXIST);
        rule.setSubtype(ExistSubType.COUNT);
        Data data = new Data();
        data.setElement(ElementType.RESISTOR);
        data.setValue("3");
        rule.setData(data);
        r.getRule().add(rule);

        Assert.assertFalse(validator.validate(c, r.getRule().get(1)));
    }

    @Test
    public void testExistValue1() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        r.getRule().get(0).setSubtype(ExistSubType.VALUE);

        Assert.assertFalse(validator.validate(c, r.getRule().get(0)));
    }

    @Test
    public void testExistValue2() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        r.getRule().get(0).setSubtype(ExistSubType.VALUE);
        Data data = new Data();
        data.setElement(ElementType.RESISTOR);
        data.setValue("1.5");
        r.getRule().get(0).setData(data);

        Assert.assertTrue(validator.validate(c, r.getRule().get(0)));
    }

    @Test
    public void testExistValue3() throws Exception {
        ExistValidator validator = new ExistValidator();
        Circuit c = CircuitHelper.create();
        Rules r = RulesHelper.create();
        r.getRule().get(0).setSubtype(ExistSubType.VALUE);
        Data data = new Data();
        data.setElement(ElementType.DIODE);
        data.setValue("1");
        r.getRule().get(0).setData(data);

        Assert.assertFalse(validator.validate(c, r.getRule().get(0)));
    }
}
