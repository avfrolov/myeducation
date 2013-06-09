package org.myeducation.portal.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.myeducation.databaseapi.dao.Dao;
import org.myeducation.databaseapi.entities.course.Course;
import org.myeducation.portal.client.CourseHelper;
import org.myeducation.portal.server.mappers.GWT2ObjectMapper;
import org.myeducation.portal.server.mappers.HibernateConverter;
import org.myeducation.portal.server.mappers.Object2GWTMapper;
import org.myeducation.portal.server.objects.CourseGWT;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class CourseHelperImpl extends RemoteServiceServlet implements CourseHelper {

    public List<CourseGWT> getCourses() {
        List<Course> courses = Dao.getFactory().createCourseDao().getCourses();
        courses = HibernateConverter.convert(courses);
        List<CourseGWT> courseGWTs = Object2GWTMapper.course2CourseGWT(courses);
        return courseGWTs;
    }

    @Override
    public CourseGWT addCourse(CourseGWT courseGWT) {
        Course course = GWT2ObjectMapper.courseGWT2Course(courseGWT);
        course = Dao.getFactory().createCourseDao().addCourse(course);
        return Object2GWTMapper.course2CourseGWT(course);
    }

}