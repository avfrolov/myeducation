package org.myeducation.databaseapi.dao;

import org.myeducation.databaseapi.entities.task.Task;
import org.myeducation.databaseapi.entities.task.TaskSend;
import org.myeducation.databaseapi.entities.task.TestDataResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 17.02.13
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
public interface TaskDAO {
    void addTask(Task task);
    TaskSend addTaskSend(TaskSend taskSend);
    void addTestResult(TestDataResult result);
    Task getTask(long id);
    TaskSend getTaskSend(long id);
    TestDataResult getResult(long testDataId);
    List<Object[]> getNotProcessTestDatas();
    Object[] getExecuteData(Long dataId, Long testsId);
}
