package org.myeducation.portal.client;

import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.rpc.AsyncCallback;
import org.myeducation.portal.server.objects.CourseGWT;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public interface CourseHelperAsync {
    Request getCourses(AsyncCallback<List<CourseGWT>> async);
    void addCourse(CourseGWT courseGWT, AsyncCallback<CourseGWT> async);
}
