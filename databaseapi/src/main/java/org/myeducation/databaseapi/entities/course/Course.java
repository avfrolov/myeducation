package org.myeducation.databaseapi.entities.course;

import org.myeducation.databaseapi.entities.user.User;

import javax.persistence.*;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "course_description")
    private String description;

    @Column(name = "course_startdate")
    private Long startDate;

    @Column(name = "course_enddate")
    private Long endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_creator")
    private User creator;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> followers;

    @Column(name = "course_type")
    private CourseType courseType;

    @OneToMany(mappedBy = "exercises", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Week> weeks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }
}
