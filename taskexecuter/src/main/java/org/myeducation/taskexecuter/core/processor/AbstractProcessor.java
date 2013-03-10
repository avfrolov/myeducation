package org.myeducation.taskexecuter.core.processor;

import org.myeducation.databaseapi.entities.AttachData;
<<<<<<< HEAD
=======
import org.myeducation.databaseapi.entities.TestData;
import org.myeducation.databaseapi.entities.TestDatas;
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 03.03.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractProcessor {

    private final ExecutorService executorService;

    public AbstractProcessor(int cores){
        executorService = Executors.newFixedThreadPool(cores);
    }

<<<<<<< HEAD
    public final void execute(AttachData data){
        final AttachData temp = data;
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                executeData(temp);
=======
    public final void execute(AttachData data, TestDatas testDatas){
        final AttachData temp = data;
        final TestDatas datas = testDatas;
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (TestData testData : datas.getTestDatas()){
                    //
                    executeData(temp, testData);
                }
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254
            }
        });
    }

<<<<<<< HEAD
    public abstract void executeData(AttachData data);
=======
    protected abstract void executeData(AttachData data, TestData testData);
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254

    public abstract String getProcessorName();
}
