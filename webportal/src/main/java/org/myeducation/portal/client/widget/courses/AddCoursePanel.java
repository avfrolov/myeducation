package org.myeducation.portal.client.widget.courses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.DateDisplayFormat;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.SubmitValuesEvent;
import com.smartgwt.client.widgets.form.events.SubmitValuesHandler;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import org.myeducation.portal.client.CourseHelper;
import org.myeducation.portal.client.CourseHelperAsync;
import org.myeducation.portal.server.objects.CourseGWT;
import org.myeducation.portal.server.objects.CourseTypeGWT;

import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 03.06.13
 * Time: 0:27
 * To change this template use File | Settings | File Templates.
 */
public class AddCoursePanel extends VLayout {

    CourseHelperAsync courseHelper = CourseHelper.App.getInstance();
    CourseGWT courseGWT = new CourseGWT();
    DateDisplayFormat dateDisplayFormat = DateDisplayFormat.TOEUROPEANSHORTDATE;
    UploadItem lecture = new UploadItem();

    private static final String UPLOAD_ACTION_URL = GWT.getModuleBaseURL() + "upload2";

    public AddCoursePanel() {
        init();
    }

    private void init() {
        setHeight("50dp");
        setWidth100();

        final Label nameLabel = new Label("Название курса");
        final TextBox name = new TextBox();
        HLayout userLayout = new HLayout();
        userLayout.addMember(nameLabel);
        userLayout.addMember(name);

        final Label privacyLabel = new Label("Доступность курса");
        ListBox privacyListBox = new ListBox(false);
        privacyListBox.addItem("Общедоступный");
        privacyListBox.addItem("Частный");
        HLayout privacyLayout = new HLayout();
        privacyLayout.addMember(privacyLabel);
        privacyLayout.addMember(privacyListBox);

        final Label descLabel = new Label("Описание");
        final TextArea desc = new TextArea();
        desc.setCharacterWidth(80);
        desc.setVisibleLines(10);
        HLayout passwordLayout = new HLayout();
        passwordLayout.addMember(descLabel);
        passwordLayout.addMember(desc);

        final DateItem startDateItem = new DateItem();
        startDateItem.setTitle("Дата начала курса");
        startDateItem.setDateFormatter(dateDisplayFormat);
        startDateItem.setUseTextField(true);
        final DateItem endDateItem = new DateItem();
        endDateItem.setTitle("Дата окончания курса");
        endDateItem.setDateFormatter(dateDisplayFormat);
        endDateItem.setUseTextField(true);

        DynamicForm dateForm = new DynamicForm();
        dateForm.setFields(startDateItem, endDateItem);

        Button addWeekButton = new Button("Добавить учебную неделю");
        Button addButton = new Button("Добавить");

        addMember(userLayout);
        addMember(privacyLayout);
        addMember(passwordLayout);
        addMember(dateForm);
        addMember(addWeekButton);
        addMember(addButton);

        addWeekButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                final com.smartgwt.client.widgets.Window winModal = new com.smartgwt.client.widgets.Window();
                winModal.setWidth(460);
                winModal.setHeight(215);
                winModal.setTitle("Добавить учебную неделю");
                winModal.setShowMinimizeButton(false);
                winModal.setIsModal(true);
                winModal.setShowModalMask(true);
                winModal.centerInPage();

                final DynamicForm form = new DynamicForm();
                form.setHeight100();
                form.setWidth100();
                form.setPadding(5);
                form.setLayoutAlign(VerticalAlignment.BOTTOM);
                form.setMethod(FormMethod.POST);
                form.setEncoding(Encoding.MULTIPART);
                form.setAction(UPLOAD_ACTION_URL);
                form.setCanSubmit(true);

                UploadItem uploadItem = new UploadItem("Лекция");
                TextAreaItem descItem = new TextAreaItem("Описание");
                descItem.setWidth(300);
                descItem.setHeight(50);

                DateItem sdItem = new DateItem();
                sdItem.setTitle("Начальный срок сдачи");
                sdItem.setDateFormatter(dateDisplayFormat);
                sdItem.setUseTextField(true);

                DateItem edItem = new DateItem();
                edItem.setTitle("Конечный срок сдачи");
                edItem.setDateFormatter(dateDisplayFormat);
                edItem.setUseTextField(true);

//                ButtonItem buttonItem = new ButtonItem("Ок");

                ButtonItem submitItem = new ButtonItem("OK");

//                form.setFields(uploadItem, descItem, sdItem, edItem, buttonItem);
                form.setFields(uploadItem, descItem, sdItem, edItem, submitItem);
                winModal.addItem(form);
                winModal.show();


//                buttonItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
//                    @Override
//                    public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent clickEvent) {
//                        form.submitForm();
//                    }
//                });

                submitItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
                    @Override
                    public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent clickEvent) {
                        form.submit();

                        form.addSubmitValuesHandler(new SubmitValuesHandler() {
                            @Override
                            public void onSubmitValues(SubmitValuesEvent submitValuesEvent) {
                                Window.alert("fsfsk");
                            }
                        });
                    }
                });

//                form.addSubmitValuesHandler(new SubmitValuesHandler() {
//                    @Override
//                    public void onSubmitValues(SubmitValuesEvent submitValuesEvent) {
//                        Window.alert(submitValuesEvent.getSource().toString());
//                        System.out.println(submitValuesEvent.getSource().toString());
//                    }
//                });


            }
        });

        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                courseGWT.setName(name.getText());
                courseGWT.setDescription(desc.getText());
                CourseTypeGWT typeGWT = privacyLabel.getContents().equals("Общедоступный") ? CourseTypeGWT.PUBLIC : CourseTypeGWT.PRIVATE;
                courseGWT.setCourseType(typeGWT);
                courseGWT.setStartDate(startDateItem.getStartDate().getTime());
                courseGWT.setEndDate(endDateItem.getStartDate().getTime());

                courseHelper.addCourse(courseGWT, new AsyncCallback<CourseGWT>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Курс не добавлен");
                    }

                    @Override
                    public void onSuccess(CourseGWT courseGWT) {
                        Window.alert("Курс успешно добавлен");
                    }
                });
            }
        });

    }
}
