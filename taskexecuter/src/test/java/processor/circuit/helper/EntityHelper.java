package processor.circuit.helper;

import org.myeducation.databaseapi.entities.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 17.05.13
 * Time: 0:07
 * To change this template use File | Settings | File Templates.
 */
public class EntityHelper {

    public static TaskSend createTask_createTaskSend_createTestResult2() throws Exception {
        Task task = new Task();
        task.setName("test simple scheme processor task");
        task.setDescription("this is description of simple task");
        AttachDataType attachDataType1 = new AttachDataType();
        attachDataType1.setNamePattern("taskexecuter/files/circuit/correct.xml");
        attachDataType1.setTask(task);

        TestDatas testDatas = new TestDatas();
        testDatas.setExecType("circuit");
        testDatas.setMinPoints(10L);
        testDatas.setTimeOut(400000L);
        testDatas.setAttachDataType(attachDataType1);

        TestData testData1 = new TestData();
        testData1.setInputData("file:taskexecuter/files/rules/correct.xml");
        testData1.setOutputData("true");
        testData1.setPoints(10);
        testData1.setTestDatas(testDatas);

        Set<TestData> testDataSet = new HashSet<TestData>();
        testDataSet.add(testData1);
        testDatas.setTestDatas(testDataSet);

        Set<TestDatas> testDatasSet = new HashSet<TestDatas>();
        testDatasSet.add(testDatas);
        attachDataType1.setTestDatas(testDatasSet);

        Set<AttachDataType> attachDataTypes = new HashSet<AttachDataType>();
        attachDataTypes.add(attachDataType1);
        task.setAttachDataTypes(attachDataTypes);

        // create task send

        TaskSend send = new TaskSend();

        AttachData attachData = new AttachData();
        attachData.setType(attachDataType1);
        attachData.setTaskSend(send);
        attachData.setContent("file:" + attachDataType1.getNamePattern());


        ArrayList<AttachData> attachDatas = new ArrayList<AttachData>();
        attachDatas.add(attachData);

        send.setTimeSend(System.currentTimeMillis());
        send.setAttachDatas(attachDatas);

        return send;
    }

}
