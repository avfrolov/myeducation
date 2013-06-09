package org.myeducation.portal.server.mappers;

import org.myeducation.databaseapi.entities.course.*;
import org.myeducation.databaseapi.entities.user.User;
import org.myeducation.databaseapi.entities.user.UserLogin;
import org.myeducation.portal.server.objects.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 03.06.13
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class GWT2ObjectMapper {

    public static Course courseGWT2Course(CourseGWT c) {
        Course cg = new Course();
        cg.setStartDate(c.getStartDate());
        cg.setEndDate(c.getEndDate());
        cg.setName(c.getName());
        cg.setDescription(c.getDescription());
        cg.setCourseType(CourseType.fromValue(c.getCourseType().value()));
        cg.setCreator(GWT2ObjectMapper.userGWT2User(c.getCreator()));
        cg.setId(c.getId());
        cg.setFollowers(GWT2ObjectMapper.usersGWT2Users(c.getFollowers()));
        cg.setWeeks(GWT2ObjectMapper.weekGWT2Weeks(c.getWeeks()));
        return cg;
    }

    public static List<Course> courseGWT2Course(List<CourseGWT> coursesGWT) {
        List<Course> courses = new ArrayList<Course>(coursesGWT.size());
        for (CourseGWT c : coursesGWT) {
            courses.add(GWT2ObjectMapper.courseGWT2Course(c));
        }
        return courses;
    }

    public static User userGWT2User(UserGWT userGWT) {
        if (userGWT == null) return new User();
        User user = new User();
        user.setAddress(userGWT.getAddress());
        user.setCreateDate(userGWT.getCreateDate());
        user.setEmail(userGWT.getEmail());
        user.setFirstName(userGWT.getFirstName());
        user.setId(userGWT.getId());
        user.setLastName(userGWT.getLastName());
        user.setLogin(GWT2ObjectMapper.userLoginGWT2UserLogin(userGWT.getLogin()));
        user.setPhoneNumber(userGWT.getPhoneNumber());
        user.setPhoto(userGWT.getPhoto());
        return user;
    }

    public static UserLogin userLoginGWT2UserLogin(UserLoginGWT loginGWT) {
        if (loginGWT == null) return new UserLogin();
        UserLogin ul = new UserLogin();
        ul.setId(loginGWT.getId());
        ul.setLogin(loginGWT.getLogin());
        ul.setPassword(loginGWT.getPassword());
        return ul;
    }

    public static List<User> usersGWT2Users(List<UserGWT> userGWTs) {
        if (userGWTs == null || userGWTs.isEmpty()) return Collections.emptyList();
        List<User> users = new ArrayList<User>(userGWTs.size());
        for (UserGWT userGWT : userGWTs) {
            users.add(GWT2ObjectMapper.userGWT2User(userGWT));
        }
        return users;
    }

    public static List<Week> weekGWT2Weeks(List<WeekGWT> weekGWTs) {
        if (weekGWTs == null || weekGWTs.isEmpty()) return Collections.emptyList();
        List<Week> weeks = new ArrayList<Week>(weekGWTs.size());
        for (WeekGWT weekGWT : weekGWTs) {
            Week wg = new Week();
            wg.setId(weekGWT.getId());
            wg.setLectures(GWT2ObjectMapper.lectureGWT2Lectures(weekGWT.getLectures()));
            wg.setExercises(GWT2ObjectMapper.exerciseGWT2Exercises(weekGWT.getExercises()));
            weeks.add(wg);
        }
        return weeks;
    }

    public static List<Exercise> exerciseGWT2Exercises(List<ExerciseGWT> exerciseGWTs) {
        if (exerciseGWTs == null || exerciseGWTs.isEmpty()) return Collections.emptyList();
        List<Exercise> exercises = new ArrayList<Exercise>(exerciseGWTs.size());
        for (ExerciseGWT e : exerciseGWTs) {
            Exercise eg = new Exercise();
            eg.setId(e.getId());
            eg.setDescription(e.getDescription());
            eg.setEndDate(e.getEndDate());
            eg.setStartDate(e.getStartDate());
            exercises.add(eg);
        }
        return exercises;
    }

    public static List<Lecture> lectureGWT2Lectures(List<LectureGWT> lectureGWTs) {
        if (lectureGWTs == null || lectureGWTs.isEmpty()) return Collections.emptyList();
        List<Lecture> lectures = new ArrayList<Lecture>(lectureGWTs.size());
        for (LectureGWT l : lectureGWTs) {
            Lecture lec = new Lecture();
            lec.setId(l.getId());
            lec.setFile(l.getFile());
            lec.setName(l.getName());
            lectures.add(lec);
        }
        return lectures;
    }

}
