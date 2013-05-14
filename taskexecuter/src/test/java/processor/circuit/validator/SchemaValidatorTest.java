package processor.circuit.validator;

import org.junit.Assert;
import org.junit.Test;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rules;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.validator.required.SchemaValidator;
import processor.circuit.helper.CircuitHelper;
import processor.circuit.helper.RulesHelper;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public class SchemaValidatorTest {

    @Test
    public void testCorrectCircuit() throws Exception {
        Circuit c = CircuitHelper.create();
        SchemaValidator validator = new SchemaValidator();
        Assert.assertTrue(validator.validate(c));
    }

    @Test
    public void testIncorrectCircuit() throws Exception {
        Circuit c = CircuitHelper.create();
        c.getNode().clear();
        SchemaValidator validator = new SchemaValidator();
        Assert.assertFalse(validator.validate(c));
    }

    @Test
    public void testCorrectRules() throws Exception {
        Rules rules = RulesHelper.create();
        SchemaValidator validator = new SchemaValidator();
        Assert.assertTrue(validator.validate(rules));
    }

    @Test
    public void testIncorrectRules() throws Exception {
        Rules rules = RulesHelper.create();
        rules.getRule().clear();
        SchemaValidator validator = new SchemaValidator();
        Assert.assertFalse(validator.validate(rules));
    }
}
