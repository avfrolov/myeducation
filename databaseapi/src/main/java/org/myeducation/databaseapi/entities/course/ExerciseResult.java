package org.myeducation.databaseapi.entities.course;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 09.06.13
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
public enum  ExerciseResult {

    NOT_FINISHED,
    SUCCESS,
    NOT_SUCCESS;

    public String value() {
        return name();
    }

    public static ExerciseResult fromValue(String v) {
        return valueOf(v);
    }
}
