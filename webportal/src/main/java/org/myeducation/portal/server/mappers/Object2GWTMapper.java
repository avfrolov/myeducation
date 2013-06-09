package org.myeducation.portal.server.mappers;

import org.myeducation.databaseapi.entities.course.Course;
import org.myeducation.databaseapi.entities.course.Exercise;
import org.myeducation.databaseapi.entities.course.Lecture;
import org.myeducation.databaseapi.entities.course.Week;
import org.myeducation.databaseapi.entities.user.User;
import org.myeducation.databaseapi.entities.user.UserLogin;
import org.myeducation.portal.server.objects.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class Object2GWTMapper {

    public static CourseGWT course2CourseGWT(Course c) {
        CourseGWT cg = new CourseGWT();
        cg.setStartDate(c.getStartDate());
        cg.setEndDate(c.getEndDate());
        cg.setName(c.getName());
        cg.setDescription(c.getDescription());
        cg.setCourseType(CourseTypeGWT.fromValue(c.getCourseType().value()));
        cg.setCreator(Object2GWTMapper.user2UserGWT(c.getCreator()));
        cg.setId(c.getId());
        cg.setFollowers(Object2GWTMapper.users2UserGWTs(c.getFollowers()));
        cg.setWeeks(Object2GWTMapper.week2WeekGWTs(c.getWeeks()));
        return cg;
    }

    public static List<CourseGWT> course2CourseGWT(List<Course> courses) {
        List<CourseGWT> courseGWTs = new ArrayList<CourseGWT>(courses.size());
        for (Course c : courses) {
            courseGWTs.add(Object2GWTMapper.course2CourseGWT(c));
        }
        return courseGWTs;
    }

    public static UserGWT user2UserGWT(User user) {
        if (user == null) return new UserGWT();
        UserGWT ug = new UserGWT();
        ug.setAddress(user.getAddress());
        ug.setCreateDate(user.getCreateDate());
        ug.setEmail(user.getEmail());
        ug.setFirstName(user.getFirstName());
        ug.setId(user.getId());
        ug.setLastName(user.getLastName());
        ug.setLogin(Object2GWTMapper.userLogin2UserLoginGWT(user.getLogin()));
        ug.setPhoneNumber(user.getPhoneNumber());
        ug.setPhoto(user.getPhoto());
        return ug;
    }

    public static UserLoginGWT userLogin2UserLoginGWT(UserLogin ul) {
        if (ul == null) return new UserLoginGWT();
        UserLoginGWT ulg = new UserLoginGWT();
        ulg.setId(ul.getId());
        ulg.setLogin(ul.getLogin());
        ulg.setPassword(ul.getPassword());
        return ulg;
    }

    public static List<UserGWT> users2UserGWTs(List<User> users) {
        if (users == null || users.isEmpty()) return Collections.emptyList();
        List<UserGWT> userGWTs = new ArrayList<UserGWT>(users.size());
        for (User u : users) {
            userGWTs.add(Object2GWTMapper.user2UserGWT(u));
        }
        return userGWTs;
    }

    public static List<WeekGWT> week2WeekGWTs(List<Week> weeks) {
        if (weeks == null || weeks.isEmpty()) return Collections.emptyList();
        List<WeekGWT> weekGWTs = new ArrayList<WeekGWT>(weeks.size());
        for (Week w : weeks) {
            WeekGWT wg = new WeekGWT();
            wg.setId(w.getId());
            wg.setLectures(Object2GWTMapper.lecture2LectureGWTs(w.getLectures()));
            wg.setExercises(Object2GWTMapper.exercise2ExerciseGWTs(w.getExercises()));
            weekGWTs.add(wg);
        }
        return weekGWTs;
    }

    public static List<ExerciseGWT> exercise2ExerciseGWTs(List<Exercise> exercises) {
        if (exercises == null || exercises.isEmpty()) return Collections.emptyList();
        List<ExerciseGWT> exerciseGWTs = new ArrayList<ExerciseGWT>(exercises.size());
        for (Exercise e : exercises) {
            ExerciseGWT eg = new ExerciseGWT();
            eg.setId(e.getId());
            eg.setDescription(e.getDescription());
            eg.setEndDate(e.getEndDate());
            eg.setStartDate(e.getStartDate());
            exerciseGWTs.add(eg);
        }
        return exerciseGWTs;
    }

    public static List<LectureGWT> lecture2LectureGWTs(List<Lecture> lectures) {
        if (lectures == null || lectures.isEmpty()) return Collections.emptyList();
        List<LectureGWT> lectureGWTs = new ArrayList<LectureGWT>(lectures.size());
        for (Lecture l : lectures) {
            LectureGWT lec = new LectureGWT();
            lec.setId(l.getId());
            lec.setFile(l.getFile());
            lec.setName(l.getName());
            lectureGWTs.add(lec);
        }
        return lectureGWTs;
    }

}
