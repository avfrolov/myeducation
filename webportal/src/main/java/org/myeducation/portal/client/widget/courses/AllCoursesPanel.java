package org.myeducation.portal.client.widget.courses;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FormPanel;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.SubmitValuesEvent;
import com.smartgwt.client.widgets.form.events.SubmitValuesHandler;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import org.myeducation.portal.client.CourseHelper;
import org.myeducation.portal.client.CourseHelperAsync;
import org.myeducation.portal.server.objects.CourseGWT;
import org.myeducation.portal.server.objects.LectureGWT;
import org.myeducation.portal.server.objects.WeekGWT;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AllCoursesPanel extends VLayout {

    CourseHelperAsync courseHelper = CourseHelper.App.getInstance();

    public AllCoursesPanel() {
        init();
    }

    private void init() {
        setHeight("50dp");
        setWidth100();

        final CellTable<CourseGWT> table = new CellTable<CourseGWT>();

        TextColumn<CourseGWT> nameColumn = new TextColumn<CourseGWT>() {
            @Override
            public String getValue(CourseGWT course) {
                System.out.println(course.getName());
                return course.getName();
            }
        };

        TextColumn<CourseGWT> ownerColumn = new TextColumn<CourseGWT>() {
            @Override
            public String getValue(CourseGWT course) {
                return course.getCreator().getFirstName() + " " + course.getCreator().getLastName();
            }
        };

        TextColumn<CourseGWT> privacyColumn = new TextColumn<CourseGWT>() {
            @Override
            public String getValue(CourseGWT course) {
                return course.getCourseType().name();
            }
        };

        TextColumn<CourseGWT> startDateColumn = new TextColumn<CourseGWT>() {
            @Override
            public String getValue(CourseGWT course) {
                return new Date(course.getStartDate()).toString();
            }
        };

        TextColumn<CourseGWT> endDateColumn = new TextColumn<CourseGWT>() {
            @Override
            public String getValue(CourseGWT course) {
                return new Date(course.getEndDate()).toString();
            }
        };

        TextColumn<CourseGWT> descriptionColumn = new TextColumn<CourseGWT>() {
            @Override
            public String getValue(CourseGWT course) {
                return course.getDescription();
            }
        };

        TextColumn<CourseGWT> countFollowersColumn = new TextColumn<CourseGWT>() {
            @Override
            public String getValue(CourseGWT courseGWT) {
                return String.valueOf(courseGWT.getFollowers().size());
            }
        };

        ButtonCell buttonCell = new ButtonCell();
        Column<CourseGWT, String> buttonColumn = new Column<CourseGWT, String>(buttonCell) {

            @Override
            public String getValue(CourseGWT courseGWT) {
                return "Посмотреть";
            }
        };

        buttonColumn.setFieldUpdater(new FieldUpdater<CourseGWT, String>() {
            public void update(int index, final CourseGWT object, String value) {
                final com.smartgwt.client.widgets.Window winModal = new com.smartgwt.client.widgets.Window();
                winModal.setWidth(460);
                winModal.setHeight(215);
                winModal.setTitle("О курсе");
                winModal.setShowMinimizeButton(false);
                winModal.setIsModal(true);
                winModal.setShowModalMask(true);
                winModal.centerInPage();

                final DynamicForm form = new DynamicForm();
                form.setHeight100();
                form.setWidth100();
                form.setPadding(5);
                form.setLayoutAlign(VerticalAlignment.BOTTOM);

                final ComboBoxItem selectItem = new ComboBoxItem("Лекция");
                final LinkedHashMap<String, String> valueMap = new LinkedHashMap<String, String>();
                int counter = 1;
                for (WeekGWT w : object.getWeeks()) {
                    for (LectureGWT lec : w.getLectures()) {
                        valueMap.put(String.valueOf(counter++), lec.getName());
                    }
                }
                selectItem.setShowAllOptions(true);
                selectItem.setValueMap(valueMap);

                ButtonItem dlButton = new ButtonItem("Скачать");

                dlButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        String lec = selectItem.getValue().toString();
                        lec = valueMap.get(lec);
                        String path = "";
                        for (WeekGWT w : object.getWeeks()) {
                            for (LectureGWT lectureGWT : w.getLectures()) {
                                if (lectureGWT.getName().equals(lec)) {
                                    path = lectureGWT.getFile();
                                }
                            }
                        }
//                        FormPanel panel = new FormPanel();
//                        panel.setAction(GWT.getModuleBaseURL() + "download?path=" + path);
//                        panel.setEncoding(FormPanel.METHOD_GET);
//                        panel.setMethod(FormPanel.METHOD_GET);
//
//                        panel.submit();
//
//                        panel.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
//                            @Override
//                            public void onSubmitComplete(FormPanel.SubmitCompleteEvent submitCompleteEvent) {
//                                Window.alert(submitCompleteEvent.getResults());
//                            }
//                        });

                        Window.open(GWT.getModuleBaseURL() + "download?path=" + path, "", "");
                    }
                });

                form.setFields(selectItem, dlButton);

//                form.setMethod(FormMethod.POST);
//                form.setEncoding(Encoding.MULTIPART);
//                form.setAction(UPLOAD_ACTION_URL);
//                form.setCanSubmit(true);

//                UploadItem uploadItem = new UploadItem("Лекция");
//                FileItem uploadItem = new FileItem("Лекция");
//                TextAreaItem descItem = new TextAreaItem("Описание");
//                descItem.setWidth(300);
//                descItem.setHeight(50);
//
//                DateItem sdItem = new DateItem();
//                sdItem.setTitle("Начальный срок сдачи");
//                sdItem.setDateFormatter(dateDisplayFormat);
//                sdItem.setUseTextField(true);
//
//                DateItem edItem = new DateItem();
//                edItem.setTitle("Конечный срок сдачи");
//                edItem.setDateFormatter(dateDisplayFormat);
//                edItem.setUseTextField(true);
//
//                ButtonItem buttonItem = new ButtonItem("Ок");
//
//                SubmitItem submitItem = new SubmitItem("OK");
//
//                form.setFields(uploadItem, descItem, sdItem, edItem, buttonItem);
//                form.setFields(uploadItem, descItem, sdItem, edItem, submitItem);
                winModal.addItem(form);
                winModal.show();


//                buttonItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
//                    @Override
//                    public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent clickEvent) {
//                        form.submitForm();
//                    }
//                });

//                submitItem.addClickHandler(new com.smartgwt.client.widgets.form.fields.events.ClickHandler() {
//                    @Override
//                    public void onClick(com.smartgwt.client.widgets.form.fields.events.ClickEvent clickEvent) {
//                        form.submit();
//
//                        form.addSubmitValuesHandler(new SubmitValuesHandler() {
//                            @Override
//                            public void onSubmitValues(SubmitValuesEvent submitValuesEvent) {
//                                Window.alert("fsfsk");
//                            }
//                        });
//                    }
//                });

//                form.addSubmitValuesHandler(new SubmitValuesHandler() {
//                    @Override
//                    public void onSubmitValues(SubmitValuesEvent submitValuesEvent) {
//                        Window.alert(submitValuesEvent.getSource().toString());
//                        System.out.println(submitValuesEvent.getSource().toString());
//                    }
//                });
            }
        });

        table.addColumn(nameColumn, "Имя");
        table.addColumn(ownerColumn, "Создатель");
        table.addColumn(privacyColumn, "Доступность");
        table.addColumn(startDateColumn, "Дата начала");
        table.addColumn(endDateColumn, "Дата конца");
        table.addColumn(descriptionColumn, "Описание");
        table.addColumn(countFollowersColumn, "Подписчики");
        table.addColumn(buttonColumn, "");


        courseHelper.getCourses(new AsyncCallback<List<CourseGWT>>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Ошибка");
                Window.alert(throwable.getMessage());
            }

            @Override
            public void onSuccess(List<CourseGWT> courses) {
                table.setRowCount(courses.size(), true);
                table.setRowData(0, courses);
            }
        });

        addMember(table);

    }
}
