package org.myeducation.portal.server.objects;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 09.06.13
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public enum ExerciseResultGWT {

    NOT_FINISHED,
    SUCCESS,
    NOT_SUCCESS;

    public String value() {
        return name();
    }

    public static ExerciseResultGWT fromValue(String v) {
        return valueOf(v);
    }

}
