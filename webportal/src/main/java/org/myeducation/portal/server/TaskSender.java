package org.myeducation.portal.server;

import org.myeducation.databaseapi.dao.Dao;
import org.myeducation.databaseapi.dao.TaskDAO;
import org.myeducation.databaseapi.entities.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 20.05.13
 * Time: 10:59
 * To change this template use File | Settings | File Templates.
 */
public class TaskSender {

    public static TestDataResult sendTask(File circuit, File rules) {
        Task task = new Task();
        task.setName("scheme processor task");
        task.setDescription("description of scheme processor task");
        AttachDataType attachDataType1 = new AttachDataType();
        attachDataType1.setNamePattern("file:" + circuit.getAbsolutePath());
        attachDataType1.setTask(task);

        TestDatas testDatas = new TestDatas();
        testDatas.setExecType("circuit");
        testDatas.setMinPoints(10L);
        testDatas.setTimeOut(400000L);
        testDatas.setAttachDataType(attachDataType1);

        TestData testData1 = new TestData();
        testData1.setInputData("file:" + rules.getAbsolutePath());
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

        TaskDAO dao = Dao.getFactory().createTaskDao();
        send = dao.addTaskSend(send);


        TestDataResult result = dao.getResult(send.getAttachDatas().get(0).getType().getTestDatas().iterator().next().getTestDatas().iterator().next().getId());
        return result;
    }

}
