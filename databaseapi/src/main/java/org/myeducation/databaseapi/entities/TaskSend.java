package org.myeducation.databaseapi.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 03.03.13
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "tasksend")
public class TaskSend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tasksend_id")
    private long id;

<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserLogin user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "taskSend")
=======
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserLogin user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "taskSend", cascade = CascadeType.ALL)
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254
    private List<AttachData> attachDatas;

    @Column(name = "tasksend_timesend")
    private long timeSend;

}
