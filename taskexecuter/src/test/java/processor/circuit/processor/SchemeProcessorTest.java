package processor.circuit.processor;

import org.junit.Test;
import org.myeducation.databaseapi.entities.task.AttachData;
import org.myeducation.databaseapi.entities.task.TaskSend;
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
    public void testScheme() throws Exception {
        TaskSend send = EntityHelper.createTaskSend("correct31370786518494123000.xml", "/Users/andrey/Documents/workspace/myeducation/taskexecuter/files/rules/correct3.xml");
        AttachData attachData = send.getAttachDatas().iterator().next();
        executor.processData(attachData, attachData.getType().getTestDatas().iterator().next());
        executor.shutDown();
    }

}
