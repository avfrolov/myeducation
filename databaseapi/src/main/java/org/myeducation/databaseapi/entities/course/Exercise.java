package org.myeducation.databaseapi.entities.course;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "week_exercise")
    private Week week;

    @Column(name = "exercise_description")
    private String description;

    @Column(name = "exercise_startdate")
    private Long startDate;

    @Column(name = "exercise_endDate")
    private Long endDate;


}
