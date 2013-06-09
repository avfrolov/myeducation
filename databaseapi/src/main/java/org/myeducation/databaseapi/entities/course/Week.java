package org.myeducation.databaseapi.entities.course;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "week")
public class Week implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "week_id")
    private Long id;

    @OneToMany(mappedBy = "week", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Exercise> exercises;

    @OneToMany(mappedBy = "week", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lecture> lectures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }
}
