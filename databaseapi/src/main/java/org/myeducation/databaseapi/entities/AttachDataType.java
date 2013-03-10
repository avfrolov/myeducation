package org.myeducation.databaseapi.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 26.02.13
 * Time: 23:40                                                       (n
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "attachdatatype")
public class AttachDataType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachdatatype_id")
    private long id;

    @Column(name = "attachdata_namepattern", length = 500)
    private String namePattern;

<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "attachdatatype_task")
    private Task task;

    @OneToMany(mappedBy = "attachDataType", fetch = FetchType.EAGER)
    private Set<TestDatas> testDatas;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
=======
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "attachdatatype_task")
    private Task task;

    @OneToMany(mappedBy = "attachDataType", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TestDatas> testDatas;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254
    private Set<AttachData> datas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePattern() {
        return namePattern;
    }

    public void setNamePattern(String namePattern) {
        this.namePattern = namePattern;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Set<TestDatas> getTestDatas() {
        return testDatas;
    }

    public void setTestDatas(Set<TestDatas> testDatas) {
        this.testDatas = testDatas;
    }

    public Set<AttachData> getDatas() {
        return datas;
    }

    public void setDatas(Set<AttachData> datas) {
        this.datas = datas;
    }
}
