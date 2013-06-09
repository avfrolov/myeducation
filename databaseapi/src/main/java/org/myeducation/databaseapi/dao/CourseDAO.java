package org.myeducation.databaseapi.dao;

import org.myeducation.databaseapi.entities.course.Course;
import org.myeducation.databaseapi.entities.course.Exercise;
import org.myeducation.databaseapi.entities.course.Lecture;
import org.myeducation.databaseapi.entities.course.Week;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
public interface CourseDAO {

    Course addCourse(Course course);
    void addWeek(Course course, Week week);
    void addWeek(Course course, Exercise exercise, Lecture lecture);
    void addExerciseToWeek(Week week, Exercise exercise);
    void addLectureToWeek(Week week, Lecture lecture);

    List<Course> getCourses();
    List<Course> getCourses(Long startDate, Long endDate);
    Course getCourse(Long id);

    Exercise getExerciseById(long id);
}
