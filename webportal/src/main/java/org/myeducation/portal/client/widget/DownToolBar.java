package org.myeducation.portal.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.MouseDownEvent;
import com.smartgwt.client.widgets.events.MouseDownHandler;
import com.smartgwt.client.widgets.layout.HStack;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 28.03.13
 * Time: 0:15
 * To change this template use File | Settings | File Templates.
 */
public class DownToolBar extends VLayout {

    //will be changed to css style
    private String color = "black";
    private String devMode = "?gwt.codesvr=127.0.0.1:9997";
    //private String devMode = "";

    public DownToolBar() {
        init();
//        addMember(new Label("Down toolbar about us"));
    }


    private void init() {
        setDefaultLayoutAlign(VerticalAlignment.CENTER);
        setBackgroundColor(color);
        setLayoutMargin(10);
        setHeight("50dp");
        setWidth100();

        Label banner = new Label();
        banner.setContents("<font color='white' size='4em' family='Geneva'/>");
        banner.setWidth100();
        banner.setHeight(20);
        banner.setBackgroundColor(color);

        HStack linkPanel = new HStack();
        linkPanel.setBackgroundColor(color);
        linkPanel.setMembersMargin(35);
        linkPanel.setLayoutRightMargin(20);
        linkPanel.setAlign(Alignment.CENTER);


        HyperLinkButton faqLink = new HyperLinkButton("FAQ");
        faqLink.addMouseDownHandler(new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                Window.Location.assign(GWT.getHostPageBaseURL() + "FAQ.html" + devMode);
            }
        });

        HyperLinkButton aboutLink = new HyperLinkButton("О проекте");
        aboutLink.addMouseDownHandler(new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                Window.Location.assign(GWT.getHostPageBaseURL() + "About.html" + devMode);
            }
        });

        HyperLinkButton teamLink = new HyperLinkButton("Команда");
        aboutLink.addMouseDownHandler(new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                Window.Location.assign(GWT.getHostPageBaseURL() + "Team.html" + devMode);
            }
        });

        HyperLinkButton helpLink = new HyperLinkButton("Помощь");
        aboutLink.addMouseDownHandler(new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent mouseDownEvent) {
                Window.Location.assign(GWT.getHostPageBaseURL() + "Help.html" + devMode);
            }
        });

        linkPanel.addMember(faqLink);
        linkPanel.addMember(teamLink);
        linkPanel.addMember(aboutLink);
        linkPanel.addMember(helpLink);

        addMember(banner);
        addMember(linkPanel);
    }
}
