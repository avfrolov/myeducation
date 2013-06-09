package org.myeducation.databaseapi.dao.hibernate;

import org.myeducation.databaseapi.dao.CourseDAO;
import org.myeducation.databaseapi.entities.course.Course;
import org.myeducation.databaseapi.entities.course.Exercise;
import org.myeducation.databaseapi.entities.course.Lecture;
import org.myeducation.databaseapi.entities.course.Week;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class CourseHibernateDAO implements CourseDAO {

    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("server");
    private static EntityManager manager = managerFactory.createEntityManager();

    public Course addCourse(Course course) {
        course = (Course) mergeObject(course);
        return course;
    }

    public void addWeek(Course course, Week week) {
        if (course.getWeeks() == null) {
            course.setWeeks(new ArrayList<Week>());
        }
        course.getWeeks().add(week);
        mergeObject(course);
    }

    public void addWeek(Course course, Exercise exercise, Lecture lecture) {
        Week week = new Week();
        week.setExercises(new ArrayList<Exercise>());
        week.setLectures(new ArrayList<Lecture>());
        if (course.getWeeks() == null) {
            course.setWeeks(new ArrayList<Week>());
        }

        week.getExercises().add(exercise);
        week.getLectures().add(lecture);
        course.getWeeks().add(week);
        mergeObject(course);
    }

    public void addExerciseToWeek(Week week, Exercise exercise) {
        if (week.getExercises() == null) {
            week.setExercises(new ArrayList<Exercise>());
        }
        week.getExercises().add(exercise);
        mergeObject(week);
    }

    public void addLectureToWeek(Week week, Lecture lecture) {
        if (week.getLectures() == null) {
            week.setLectures(new ArrayList<Lecture>());
        }
        week.getLectures().add(lecture);
        mergeObject(week);
    }

    public List<Course> getCourses() {
        List<Course> courses = manager.createQuery("select c from Course as c").getResultList();
        return courses;
    }

    public List<Course> getCourses(Long startDate, Long endDate) {
        List<Course> courses = manager.createQuery("select c from Course as c where c.startDate >= :startDate and c.endDate <= :endDate")
                .setParameter("startDate", startDate).setParameter("endDate", endDate).getResultList();
        return courses;
    }

    public Course getCourse(Long id) {
        Course course = (Course) manager.createQuery("select c from Course as c where c.id = :id").setParameter("id", id).getSingleResult();
        return course;
    }

    protected void storeObject(Object o) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(o);
        transaction.commit();
    }

    protected Object mergeObject(Object o) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        o = manager.merge(o);
        transaction.commit();
        return o;
    }
}
