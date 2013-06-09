package org.myeducation.databaseapi.entities.course;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "exercise")
public class Exercise implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "week_id")
    private Week week;

    @Column(name = "exercise_name")
    private String name;

    @Column(name = "exercise_validation")
    private String validationFile;

    @Column(name = "exercise_success")
    private ExerciseResult result;

    @Column(name = "exercise_description")
    private String description;

    @Column(name = "exercise_startdate")
    private Long startDate;

    @Column(name = "exercise_endDate")
    private Long endDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValidationFile() {
        return validationFile;
    }

    public void setValidationFile(String validationFile) {
        this.validationFile = validationFile;
    }

    public ExerciseResult getResult() {
        return result;
    }

    public void setResult(ExerciseResult result) {
        this.result = result;
    }
}
