package processor.circuit.processor;

import org.junit.Test;
import org.myeducation.databaseapi.entities.AttachData;
import org.myeducation.databaseapi.entities.TaskSend;
import org.myeducation.taskexecuter.core.Executor;
import processor.circuit.helper.EntityHelper;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 16.05.13
 * Time: 22:08
 * To change this template use File | Settings | File Templates.
 */
public class SchemeProcessorTest {

    private Executor executor = new Executor();

    @Test
    public void testScheme() throws Exception{
        TaskSend send = EntityHelper.createTask_createTaskSend_createTestResult2();
        AttachData attachData = send.getAttachDatas().iterator().next();
        executor.processData(attachData, attachData.getType().getTestDatas().iterator().next());
        executor.shutDown();
    }

}
