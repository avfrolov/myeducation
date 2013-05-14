package org.myeducation.taskexecuter.core.processor.circuit;

import org.myeducation.databaseapi.entities.AttachData;
import org.myeducation.databaseapi.entities.ProcessorResult;
import org.myeducation.databaseapi.entities.TestData;
import org.myeducation.taskexecuter.core.processor.AbstractProcessor;

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
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected ProcessorResult<Boolean> processException(Exception ex, AttachData data, TestData testData) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected boolean needBreakPointResult(ProcessorResult<Boolean> result) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected boolean needBreakPointException(Exception ex) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getProcessorName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getCores() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
