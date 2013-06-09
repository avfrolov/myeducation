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
        creator.setFirstName("Андрей");
        creator.setLastName("Фролов");
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
        lecture.setName("Лекция 1. Основы");
        lecture.setFile("/Volumes/Learning/Eltech/4-kurs.xls");
        lecture.setWeek(week);
        Lecture lecture2 = new Lecture();
        lecture2.setName("Лекция 2. Основные приемы");
        lecture2.setFile("/Volumes/Learning/router.rtf");
        lecture2.setWeek(week);

        Exercise exercise = new Exercise();
        exercise.setName("Упражнение 1");
        exercise.setDescription("Составить схему, содержащую 3 резистора и конденсатор с емкостью = 1 мкФ. Схема должна быть замкнута");
        exercise.setEndDate(System.currentTimeMillis() + 500000000);
        exercise.setStartDate(System.currentTimeMillis());
        exercise.setValidationFile("/Users/andrey/Documents/workspace/myeducation/taskexecuter/files/rules/correct3.xml");
        exercise.setResult(ExerciseResult.NOT_FINISHED);
        exercise.setWeek(week);

        Exercise exercise2 = new Exercise();
        exercise2.setName("Упражнение 2");
        exercise2.setDescription("Составить схему, содержащую резистор с емкостью = 10 Ом. Схема должна быть замкнута");
        exercise2.setEndDate(System.currentTimeMillis() + 500000000);
        exercise2.setStartDate(System.currentTimeMillis());
        exercise2.setValidationFile("/Users/andrey/Documents/workspace/myeducation/taskexecuter/files/rules/correct4.xml");
        exercise2.setResult(ExerciseResult.NOT_FINISHED);
        exercise2.setWeek(week);
        List<Lecture> lectures = new ArrayList<Lecture>();
        lectures.add(lecture);
        lectures.add(lecture2);
        List<Exercise> exercises = new ArrayList<Exercise>();
        exercises.add(exercise);
        exercises.add(exercise2);
        week.setLectures(lectures);
        week.setExercises(exercises);
        weeks.add(week);

        Course course = new Course();
        course.setCourseType(CourseType.PUBLIC);
        course.setCreator(creator);
        course.setDescription("Учебный курс предназначен для специалистов информационно-проектирующих систем.");
        course.setName("Основы проектирования");
        course.setStartDate(System.currentTimeMillis());
        course.setEndDate(System.currentTimeMillis() + 5000000000L);
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
