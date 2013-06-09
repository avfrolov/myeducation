package org.myeducation.databaseapi.entities.course;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
public enum CourseType {

    PUBLIC,
    PRIVATE;

    public String value() {
        return name();
    }

    public static CourseType fromValue(String v) {
        return valueOf(v);
    }
}
