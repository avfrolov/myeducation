package org.myeducation.portal.server.objects;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 22:36
 * To change this template use File | Settings | File Templates.
 */
public class CourseGWT implements Serializable{

    private Long id;
    private String name;
    private String description;
    private Long startDate;
    private Long endDate;
    private UserGWT creator;
    private List<UserGWT> followers;
    private CourseTypeGWT courseType;
    private List<WeekGWT> weeks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserGWT getCreator() {
        return creator;
    }

    public void setCreator(UserGWT creator) {
        this.creator = creator;
    }

    public List<UserGWT> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserGWT> followers) {
        this.followers = followers;
    }

    public CourseTypeGWT getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseTypeGWT courseType) {
        this.courseType = courseType;
    }

    public List<WeekGWT> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<WeekGWT> weeks) {
        this.weeks = weeks;
    }
}
