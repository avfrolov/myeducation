package org.myeducation.taskexecuter.core.processor.circuit;

import org.myeducation.databaseapi.entities.AttachData;
import org.myeducation.databaseapi.entities.ProcessorResult;
import org.myeducation.databaseapi.entities.TestData;
import org.myeducation.properties.PropertiesFactory;
import org.myeducation.taskexecuter.core.processor.AbstractProcessor;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rule;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules.Rules;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.transformator.Transformator;
import org.myeducation.taskexecuter.core.processor.circuit.validator.UserValidator;
import org.myeducation.taskexecuter.core.processor.circuit.validator.UserValidatorFactory;
import org.myeducation.taskexecuter.core.processor.circuit.validator.required.NameValidator;
import org.myeducation.taskexecuter.core.processor.circuit.validator.required.NodeValidator;
import org.myeducation.taskexecuter.core.util.DataSourceUtil;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.05.13
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class SchemeProcessor extends AbstractProcessor<Boolean> {


    @Override
    protected ProcessorResult<Boolean> getResult(AttachData data, TestData testData) throws Exception {
        ProcessorResult<Boolean> processorResult = new ProcessorResult<Boolean>();

        File circuitFile = (File) DataSourceUtil.getSource(data.getContent());
        File rulesFile = (File) DataSourceUtil.getSource(testData.getInputData());

        System.out.println(circuitFile.getAbsolutePath());
        System.out.println(rulesFile.getAbsolutePath());

        // JAXB Validation with unmarshalling
        Circuit circuit = Transformator.file2Circuit(circuitFile);
        Rules rules = Transformator.file2Rules(rulesFile);

        if (circuit == null || rules == null) {
            // Incoming data aren't valid
            processorResult.setResult(false);
            processorResult.setSuccess(false);
            return processorResult;
        } else {
            // Required validation
            if (!(new NameValidator().validate(circuit) && new NodeValidator().validate(circuit))) {
                processorResult.setResult(false);
                processorResult.setSuccess(false);
                return processorResult;
            }

            //UserValidation
            UserValidator uv;
            for (Rule rule : rules.getRule()) {
                uv = UserValidatorFactory.getValidator(rule.getType());
                if (!uv.validate(circuit, rule)) {
                    processorResult.setResult(false);
                    processorResult.setSuccess(false);
                    return processorResult;
                }

            }
        }
        processorResult.setResult(true);
        processorResult.setSuccess(true);
        return processorResult;
    }

    @Override
    protected ProcessorResult<Boolean> processException(Exception ex, AttachData data, TestData testData) {
        ProcessorResult<Boolean> result = new ProcessorResult<Boolean>();
        result.setSuccess(false);
        result.setResult(false);
        return result;
    }

    @Override
    protected boolean needBreakPointResult(ProcessorResult<Boolean> result) {
        return false;
    }

    @Override
    protected boolean needBreakPointException(Exception ex) {
        return false;
    }

    @Override
    public String getProcessorName() {
        return "circuit";
    }

    @Override
    public int getCores() {
        return Integer.parseInt(PropertiesFactory.getProperties("processors").getProperty("processor.circuit.cores"));
    }
}
