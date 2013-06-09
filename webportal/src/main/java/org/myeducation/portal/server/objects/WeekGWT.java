package org.myeducation.portal.server.objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 23:39
 * To change this template use File | Settings | File Templates.
 */
public class WeekGWT implements Serializable {

    private Long id;
    private List<ExerciseGWT> exercises;
    private List<LectureGWT> lectures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ExerciseGWT> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseGWT> exercises) {
        this.exercises = exercises;
    }

    public List<LectureGWT> getLectures() {
        return lectures;
    }

    public void setLectures(List<LectureGWT> lectures) {
        this.lectures = lectures;
    }
}
