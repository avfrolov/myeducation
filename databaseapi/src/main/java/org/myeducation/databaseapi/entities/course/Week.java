package org.myeducation.databaseapi.entities.course;

import javax.persistence.*;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "week")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "week_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "week_exercise")
    private Exercise exercise;


    private File lecture;
}
