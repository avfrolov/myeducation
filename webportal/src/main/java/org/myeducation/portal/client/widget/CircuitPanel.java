package org.myeducation.portal.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 18.05.13
 * Time: 20:58
 * To change this template use File | Settings | File Templates.
 */
public class CircuitPanel extends VLayout {

    private static final String UPLOAD_ACTION_URL = GWT.getModuleBaseURL() + "upload";

    public CircuitPanel() {
        init();
    }

    private void init() {
        setHeight("50dp");
        setWidth100();

        final FormPanel form = new FormPanel();
        form.setAction(UPLOAD_ACTION_URL);
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);

        VerticalPanel panel = new VerticalPanel();
        form.setWidget(panel);

        Label circuitLabel = new Label("Upload circuit XML-Document");
        final FileUpload circuitUpload = new FileUpload();
        Label rulesLabel = new Label("Upload rules XML-Document");
        final FileUpload rulesUpload = new FileUpload();

        circuitLabel.setWidth(145);
        circuitLabel.setHeight(10);
        rulesLabel.setWidth(150);
        rulesLabel.setHeight(10);
        circuitUpload.setName("<input type=\"file\" name=\"circuitFile\"/>");
        rulesUpload.setName("<input type=\"file\" name=\"rulesFile\"/>");

        Button startButton = new Button("Start");

        final Label resultLabel = new Label("<font color='black' size='4em' family='Geneva'>Result </font>");

        panel.add(circuitLabel);
        panel.add(circuitUpload);
        panel.add(rulesLabel);
        panel.add(rulesUpload);
        panel.add(startButton);
        panel.add(resultLabel);

        startButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                form.submit();
            }
        });

        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent submitEvent) {
                if (circuitUpload.getFilename().isEmpty()) {
                    Window.alert("No circuit file specified!");
                    submitEvent.cancel();
                }

                if (rulesUpload.getFilename().isEmpty()) {
                    Window.alert("No rules file specified!");
                    submitEvent.cancel();
                }
            }
        });

        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent submitCompleteEvent) {
                Boolean res =  submitCompleteEvent.getResults().contains("true");
                    String color = res? "blue" : "red";
                if (res) {
                    resultLabel.setContents(resultLabel.getContents() + "<font color='" + color +"' size='4em' family='Geneva'>" + res + "</font> ");
                } else {
                    resultLabel.setContents(resultLabel.getContents() + "<font color='red' size='4em' family='Geneva'>" + submitCompleteEvent.getResults() + "</font> ");
                }
            }
        });

        addMember(form);

    }
}
