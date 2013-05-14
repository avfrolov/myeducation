package processor.circuit.validator;

import junit.framework.Assert;
import org.junit.Test;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.validator.required.NodeValidator;
import processor.circuit.helper.CircuitHelper;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 21:48
 * To change this template use File | Settings | File Templates.
 */
public class NodeValidatorTest {

    @Test
    public void testCorrect1() throws Exception {
        Circuit c = CircuitHelper.create();
        NodeValidator validator = new NodeValidator();
        Assert.assertTrue(validator.validate(c));
    }

    @Test
    public void testCorrect2() throws Exception {
        Circuit c = CircuitHelper.create();
        c.getNode().add(CircuitHelper.createNode(4, 1, CircuitHelper.createElements14()));
        NodeValidator validator = new NodeValidator();
        Assert.assertTrue(validator.validate(c));
    }

    @Test
    public void testIncorrect1() throws Exception {
        Circuit c = CircuitHelper.create();
        c.getNode().add(CircuitHelper.createNode(4, 1, CircuitHelper.createElements13()));
        NodeValidator validator = new NodeValidator();
        Assert.assertFalse(validator.validate(c));
    }

    @Test
    public void testIncorrect2() throws Exception {
        Circuit c = CircuitHelper.create();
        c.getNode().add(CircuitHelper.createNode(1, 4, CircuitHelper.createElements14()));
        NodeValidator validator = new NodeValidator();
        Assert.assertFalse(validator.validate(c));
    }
}
