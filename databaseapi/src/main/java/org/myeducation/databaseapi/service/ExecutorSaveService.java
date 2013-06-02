package org.myeducation.databaseapi.service;

import org.myeducation.databaseapi.entities.task.AttachData;
import org.myeducation.databaseapi.entities.task.ProcessorResult;
import org.myeducation.databaseapi.entities.task.TestData;
import org.myeducation.databaseapi.model.ExecutorData;
import org.myeducation.databaseapi.model.ExecutorDataDto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 29.03.13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public interface ExecutorSaveService {
    public void storeResult(ProcessorResult result, AttachData attachData, TestData testData);
    public List<ExecutorDataDto> getNewExecutorData();
    public List<ExecutorData> getExecuterData(List<ExecutorDataDto> dto);
}
