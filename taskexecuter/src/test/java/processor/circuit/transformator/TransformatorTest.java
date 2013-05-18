package processor.circuit.transformator;

import org.junit.Assert;
import org.junit.Test;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rules;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.transformator.Transformator;
import processor.circuit.helper.CircuitHelper;
import processor.circuit.helper.RulesHelper;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public class TransformatorTest {

    @Test
    public void testCorrectCircuit2File() throws Exception {
        Circuit c = CircuitHelper.create();
        Assert.assertNotNull(Transformator.circuit2File(c));
    }

    @Test
    public void testIncorrectCircuit2File() throws Exception {
        Circuit c = CircuitHelper.create();
        c.getNode().clear();
        Assert.assertNull(Transformator.circuit2File(c));
    }

    @Test
    public void testCorrectRules2File() throws Exception {
        Rules rules = RulesHelper.create();
        Assert.assertNotNull(Transformator.rules2File(rules));
    }

    @Test
    public void testIncorrectRules2File() throws Exception {
        Rules rules = RulesHelper.create();
        rules.getRule().clear();
        Assert.assertNull(Transformator.rules2File(rules));
    }

    @Test
    public void testCorrectFile2Circuit() throws Exception {
        File file = new File("taskexecuter/files/circuit/correct.xml");
        Circuit c = Transformator.file2Circuit(file);
        Assert.assertNotNull(c);
    }

    @Test
    public void testIncorrectFile2Circuit() throws Exception {
        File file = new File("");
        Circuit c = Transformator.file2Circuit(file);
        Assert.assertNull(c);
    }

    @Test
    public void testIncorrectFile2Circuit2() throws Exception {
        File file = new File("taskexecuter/files/circuit/incorrect.xml");
        Circuit c = Transformator.file2Circuit(file);
        Assert.assertNull(c);
    }

    @Test
    public void testCorrectFile2Rules() throws Exception {
        File file = new File("taskexecuter/files/rules/correct.xml");
        Rules r = Transformator.file2Rules(file);
        Assert.assertNotNull(r);
    }

    @Test
    public void testIncorrectFile2Rules() throws Exception {
        File file = new File("taskexecuter/files/circuit/correct.xml");
        Rules r = Transformator.file2Rules(file);
        Assert.assertNull(r);
    }

    @Test
    public void testIncorrectFile2Rules2() throws Exception {
        File file = new File("taskexecuter/files/rules/incorrect.xml");
        Rules r = Transformator.file2Rules(file);
        Assert.assertNull(r);
    }
}
