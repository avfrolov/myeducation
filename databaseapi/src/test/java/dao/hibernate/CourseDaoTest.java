package dao.hibernate;

import org.junit.Before;
import org.junit.Test;
import org.myeducation.databaseapi.dao.CourseDAO;
import org.myeducation.databaseapi.dao.Dao;
import org.myeducation.databaseapi.entities.course.*;
import org.myeducation.databaseapi.entities.user.User;
import org.myeducation.databaseapi.entities.user.UserLogin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 17:11
 * To change this template use File | Settings | File Templates.
 */
public class CourseDaoTest {

    private CourseDAO dao;

    @Before
    public void init(){
        dao = Dao.getFactory().createCourseDao();
    }

    @Test
    public void test() throws Exception {
        User creator = new User();
        creator.setAddress("address");
        creator.setCreateDate(System.currentTimeMillis());
        creator.setEmail("test@gmail.com");
        creator.setFirstName("Vasya");
        creator.setLastName("Pupkin");
        creator.setPhoneNumber("8473749358");

        UserLogin login = new UserLogin();
        login.setLogin("login");
        login.setPassword("pwd");
        login.setUser(creator);

        List<User> followers = new ArrayList<User>();
        followers.add(new User());
        followers.add(new User());
        followers.add(new User());

        List<Week> weeks = new ArrayList<Week>();
        Week week = new Week();
        Lecture lecture = new Lecture();
        lecture.setName("Lecture 1");
        lecture.setFile("file:/Volumes/Learning/Eltech/4-kurs.xls");
        lecture.setWeek(week);
        Lecture lecture2 = new Lecture();
        lecture2.setName("Lecture 2");
        lecture2.setFile("file:/Volumes/Learning/router.rtf");
        lecture2.setWeek(week);
        Exercise exercise = new Exercise();
        exercise.setName("test exercise");
        exercise.setDescription("1 exercise");
        exercise.setEndDate(System.currentTimeMillis() + 10000);
        exercise.setStartDate(System.currentTimeMillis());
        exercise.setWeek(week);
        List<Lecture> lectures = new ArrayList<Lecture>();
        lectures.add(lecture);
        lectures.add(lecture2);
        List<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(exercise);
        week.setLectures(lectures);
        week.setExercises(exercises);
        weeks.add(week);

        Course course = new Course();
        course.setCourseType(CourseType.PUBLIC);
        course.setCreator(creator);
        course.setDescription("this is test of simple course");
        course.setName("Test name");
        course.setStartDate(System.currentTimeMillis());
        course.setEndDate(System.currentTimeMillis() + 5000000);
        course.setFollowers(followers);
        course.setWeeks(weeks);

        course = dao.addCourse(course);
        course.getWeeks();
    }

    @Test
    public void testGet() throws Exception {
        Course course = dao.getCourse(1L);
        course.getWeeks();
    }

}
