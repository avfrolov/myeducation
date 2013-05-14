package processor.circuit.helper;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.*;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.ElementType;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 16:50
 * To change this template use File | Settings | File Templates.
 */
public class RulesHelper {

    public static Rules create() {
        Rules rules = new Rules();
        rules.getRule().add(createRule());
        return rules;
    }

    public static Rule createRule() {
        Rule rule = new Rule();
        rule.setData(createData());
        rule.setSubtype(ExistSubType.NAME);
        rule.setType(RuleType.EXIST);
        return rule;
    }

    public static Data createData() {
        Data data = new Data();
        data.setValue("R1");
        data.setElement(ElementType.RESISTOR);
        return data;
    }

}
