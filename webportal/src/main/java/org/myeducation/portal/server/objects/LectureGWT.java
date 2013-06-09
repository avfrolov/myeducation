package org.myeducation.portal.server.objects;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 09.06.13
 * Time: 0:59
 * To change this template use File | Settings | File Templates.
 */
public class LectureGWT implements Serializable {

    private Long id;
    private String file;
    private String name;
    private WeekGWT week;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeekGWT getWeek() {
        return week;
    }

    public void setWeek(WeekGWT week) {
        this.week = week;
    }
}
