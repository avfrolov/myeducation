package org.myeducation.databaseapi.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 26.02.13
 * Time: 23:53
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "testdatas")
public class TestDatas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "testdatas_exectype")
    private String execType;

    @Column(name = "testdatas_minpoints")
    private Long minPoints;

    @Column(name = "testdatas_timeout")
    private Long timeOut;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "testdatas_attachdata")
    private AttachDataType attachDataType;

    @OneToMany(mappedBy = "testDatas", fetch = FetchType.EAGER)
    private Set<TestData> testDatas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public AttachDataType getAttachDataType() {
        return attachDataType;
    }

    public void setAttachDataType(AttachDataType attachDataType) {
        this.attachDataType = attachDataType;
    }

    public Set<TestData> getTestDatas() {
        return testDatas;
    }

    public void setTestDatas(Set<TestData> testDatas) {
        this.testDatas = testDatas;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public Long getMinPoints() {
        return minPoints;
    }

    public void setMinPoints(Long minPoints) {
        this.minPoints = minPoints;
    }
}
