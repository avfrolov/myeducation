package org.myeducation.portal.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;
import org.myeducation.portal.server.objects.CourseGWT;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
@RemoteServiceRelativePath("CourseHelper")
public interface CourseHelper extends RemoteService {

    /**
     * Utility/Convenience class.
     * Use CourseHelper.App.getInstance() to access static instance of CourseHelperAsync
     */
    public static class App {
        private static final CourseHelperAsync ourInstance = (CourseHelperAsync) GWT.create(CourseHelper.class);

        public static CourseHelperAsync getInstance() {
            return ourInstance;
        }
    }

    List<CourseGWT> getCourses();
    CourseGWT addCourse(CourseGWT courseGWT);
}
