package org.myeducation.databaseapi.dao.hibernate;

import org.myeducation.databaseapi.dao.TaskDAO;
import org.myeducation.databaseapi.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 17.02.13
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
//TODO
//    fix critic situations!!!
public class TaskHibernateDAO implements TaskDAO {

    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("server");
    private static EntityManager manager = managerFactory.createEntityManager();

    public void addTask(Task task) {
        storeObject(task);
    }

    public TaskSend addTaskSend(TaskSend taskSend) {
        taskSend = (TaskSend) mergeObject(taskSend);
        return taskSend;
    }

    public void addTestResult(TestDataResult result) {
        mergeObject(result);
    }

    public Task getTask(long id) {
        Task task = (Task) manager.createQuery("select task from Task as task where task.id=:id").setParameter("id", id).getSingleResult();
        return task;
    }

    public TaskSend getTaskSend(long id) {
        TaskSend tasksend = (TaskSend) manager.createQuery("select tasksend from TaskSend as tasksend where tasksend.id=:id").setParameter("id", id).getSingleResult();
        return tasksend;
    }

    public List<Object[]> getNotProcessTestDatas() {
//        List<Object[]> result = manager.createQuery("select file.id, test.id from AttachData file, TestDatas test " +
//                "where not exists (from TestDataResult as result where result.attachData=file and result.testData in elements(test.testDatas))").getResultList();
        List<Object[]> result = manager.createQuery("select  file.id, test.id from AttachData file, TestDatas test " +
                "where file.type = test.attachDataType and not exists (select result from TestDataResult  result where result.attachData=file)").getResultList();
        return result;
    }

    public Object[] getExecuteData(Long dataId, Long testsId) {
        Object[] result = (Object[]) manager.createQuery("select file, tests from AttachData as file, TestDatas as tests where file.id=:dataId and tests.id=:testsId")
                .setParameter("dataId", dataId).setParameter("testsId", testsId).getSingleResult();
        return result;
    }

    public TestDataResult getResult(long testDataId) {
        List<TestDataResult> result = new ArrayList<TestDataResult>(0);
        while (result.size() == 0) {
            result = (List<TestDataResult>) manager.createQuery("select result from TestDataResult as result where result.testData.id=:testDataId")
                    .setParameter("testDataId", testDataId).getResultList();
        }
        return result.get(0);
    }

    protected void storeObject(Object o) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(o);
        transaction.commit();
    }

    protected Object mergeObject(Object o) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        o = manager.merge(o);
        transaction.commit();
        return o;
    }
}
