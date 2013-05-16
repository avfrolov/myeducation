package processor.circuit.validator;

import org.junit.Assert;
import org.junit.Test;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Capacitor;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Resistor;
import org.myeducation.taskexecuter.core.processor.circuit.validator.required.NameValidator;
import processor.circuit.helper.CircuitHelper;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 16.05.13
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
public class NameValidatorTest {

    @Test
    public void test1() throws Exception {
        Circuit c = CircuitHelper.create();
        Assert.assertTrue(new NameValidator().validate(c));
    }

    @Test
    public void test2() throws Exception {
        Circuit c = CircuitHelper.create();
        Resistor r = new Resistor();
        r.setName("R1");
        c.getNode().get(3).getElements().getResistor().add(r);
        Assert.assertFalse(new NameValidator().validate(c));
    }

    @Test
    public void test3() throws Exception {
        Circuit c = CircuitHelper.create();
        Capacitor capacitor = new Capacitor();
        capacitor.setName("R1");
        c.getNode().get(3).getElements().getCapacitor().add(capacitor);
        Assert.assertFalse(new NameValidator().validate(c));

    }
}
