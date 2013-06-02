package org.myeducation.databaseapi.entities.course;

import javax.persistence.*;
import java.io.File;
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
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "week_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "week_exercise")
    private List<Exercise> exercises;

//    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    @JoinColumn(name = "week_lecture")
    private List<String> lectures;

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

    public List<String> getLectures() {
        return lectures;
    }

    public void setLectures(List<String> lectures) {
        this.lectures = lectures;
    }
}
