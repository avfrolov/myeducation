package org.myeducation.portal.client.widget;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 28.03.13
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */
public class LogInPanel extends VLayout {

    public LogInPanel() {
        init();
    }

    private void init() {
        setDefaultLayoutAlign(VerticalAlignment.CENTER);
        setLayoutMargin(10);
        setHeight("50dp");
        setWidth100();

        Label userLabel = new Label("<font color='black' size='4em' family='Geneva'>Name</font>");
        TextBox userName = new TextBox();
        HLayout userLayout = new HLayout();
        userLayout.addMember(userLabel);
        userLayout.addMember(userName);

        Label passwordLabel = new Label("<font color='black' size='4em' family='Geneva'>Password</font>");
        PasswordTextBox passwordBox = new PasswordTextBox();
        HLayout passwordLayout = new HLayout();
        passwordLayout.addMember(passwordLabel);
        passwordLayout.addMember(passwordBox);

        Button login = new Button("<font color='Black' size='4em' family='Geneva'>Login");

        addMember(userLayout);
        addMember(passwordLayout);
        addMember(login);
    }

}
