package org.myeducation.portal.client.widget.courses;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.smartgwt.client.types.Encoding;
import com.smartgwt.client.types.FormMethod;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.events.SubmitValuesEvent;
import com.smartgwt.client.widgets.form.events.SubmitValuesHandler;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.StaticTextItem;
import com.smartgwt.client.widgets.form.fields.UploadItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;
import org.myeducation.portal.client.CourseHelper;
import org.myeducation.portal.client.CourseHelperAsync;
import org.myeducation.portal.server.objects.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class AllCoursesPanel extends VLayout {

    CourseHelperAsync courseHelper = CourseHelper.App.getInstance();
    private static final String UPLOAD_ACTION_URL = GWT.getModuleBaseURL() + "upload";
    private long id;

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
                String privacy = course.getCourseType().equals(CourseTypeGWT.PUBLIC) ?
                        "Общедоступный" : "Частный";
                return privacy;
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
                winModal.setHeight(265);
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
                form.setMethod(FormMethod.POST);
                form.setEncoding(Encoding.MULTIPART);
                form.setAction(UPLOAD_ACTION_URL + "?id=");
                form.setCanSubmit(true);

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
                final StaticTextItem nameExerciseItem = new StaticTextItem("Упражнение");
                final StaticTextItem descExerciseItem = new StaticTextItem("Описание");
                final StaticTextItem resExerciseItem = new StaticTextItem("Статус");
                UploadItem sendTask = new UploadItem("Ответ");
                ButtonItem sendButton = new ButtonItem("Отправить");

                form.setFields(selectItem, dlButton, nameExerciseItem, descExerciseItem, sendTask, resExerciseItem, sendButton);
                winModal.addItem(form);
                winModal.show();

                selectItem.addChangedHandler(new ChangedHandler() {
                    @Override
                    public void onChanged(ChangedEvent changedEvent) {
                        String selected = ((ComboBoxItem) changedEvent.getSource()).getDisplayValue();
                        ExerciseGWT exercise = null;
                        for (WeekGWT w : object.getWeeks()) {
                            for (int i = 0; i < w.getLectures().size(); i++) {
                                if (w.getLectures().get(i).getName().equals(selected)) {
                                    exercise = w.getExercises().get(i);
                                    id = exercise.getId();
                                    break;
                                }
                            }
                        }

                        nameExerciseItem.setValue(exercise.getName());
                        descExerciseItem.setValue(exercise.getDescription());
                        String res = "";
                        switch (exercise.getResult()) {
                            case NOT_FINISHED:
                                res = "Упражнение не сдавалось";
                                break;
                            case SUCCESS:
                                res = "Упражнение сдано";
                                break;
                            case NOT_SUCCESS:
                                res = "Упражнение не сдано. Проверьте схему";
                                break;
                        }
                        resExerciseItem.setValue(res);
                    }
                });

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

                        Window.open(GWT.getModuleBaseURL() + "download?path=" + path, "", "");
                    }
                });

                sendButton.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent clickEvent) {
                        form.setAction(form.getAction() + String.valueOf(id));
                        form.submit();
                    }
                });
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
