package org.myeducation.portal.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import org.myeducation.portal.client.widget.MainPanel;
import org.myeducation.portal.client.widget.courses.AllCoursesPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MainPage implements EntryPoint {

    private MainPanel panel = new MainPanel();

    public void onModuleLoad() {
        //Window.Location.assign(GWT.getHostPageBaseURL() + "Login.html");
//        panel.setContent(new LogInPanel());
//        panel.setContent(new CircuitPanel());
        panel.setContent(new AllCoursesPanel());
//        panel.setContent(new AddCoursePanel());
        RootPanel.get().add(panel);
    }

}
