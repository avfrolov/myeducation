package org.myeducation.portal.server.mappers;

import org.myeducation.databaseapi.entities.course.Course;
import org.myeducation.databaseapi.entities.course.Exercise;
import org.myeducation.databaseapi.entities.course.Lecture;
import org.myeducation.databaseapi.entities.course.Week;
import org.myeducation.databaseapi.entities.user.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 08.06.13
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public class HibernateConverter {

    public static Course convert(Course c) {
        Course newC = new Course();
        newC.setEndDate(c.getEndDate());
        newC.setName(c.getName());
        newC.setDescription(c.getDescription());
        newC.setCourseType(c.getCourseType());
        newC.setCreator(c.getCreator());
        newC.setStartDate(c.getStartDate());
        newC.setId(c.getId());

        List<User> followers = new ArrayList<User>();
        for (User u : c.getFollowers()) {
            followers.add(u);
        }
        newC.setFollowers(followers);

        List<Week> weeks = new ArrayList<Week>();
        for (Week w : c.getWeeks()) {
            Week newW = new Week();
            newW.setId(w.getId());

            List<Exercise> exercises = new ArrayList<Exercise>();
            for (Exercise ex : w.getExercises()) {
                exercises.add(ex);
            }
            newW.setExercises(exercises);

            List<Lecture> lectures = new ArrayList<Lecture>();
            for (Lecture l : w.getLectures()) {
                lectures.add(l);
            }
            newW.setLectures(lectures);

            weeks.add(newW);
        }
        newC.setWeeks(weeks);
        return newC;
    }

    public static List<Course> convert(List<Course> courses) {
        List<Course> newCourses = new ArrayList<Course>(courses.size());
        for (Course c : courses) {
            newCourses.add(HibernateConverter.convert(c));
        }
        return newCourses;
    }

}
