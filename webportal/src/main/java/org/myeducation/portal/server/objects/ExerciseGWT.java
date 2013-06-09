package org.myeducation.portal.server.objects;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 23:40
 * To change this template use File | Settings | File Templates.
 */
public class ExerciseGWT implements Serializable {

    private Long id;
    private WeekGWT week;
    private String name;
    private String description;
    private Long startDate;
    private Long endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WeekGWT getWeek() {
        return week;
    }

    public void setWeek(WeekGWT week) {
        this.week = week;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }
}
