package org.myeducation.portal.server.objects;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 22:51
 * To change this template use File | Settings | File Templates.
 */
public enum  CourseTypeGWT implements Serializable {

    PUBLIC,
    PRIVATE;

    public String value() {
        return name();
    }

    public static CourseTypeGWT fromValue(String v) {
        return valueOf(v);
    }

}
