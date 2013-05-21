package org.myeducation.properties;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 21.05.13
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorPath {

    public static synchronized String getExecutorPath() {
        String userDir = System.getProperty("user.dir");
        return userDir.contains("myeducation") ? userDir + "/configuration/src/main/resources/META-INF/"  : userDir + "/WEB-INF/classes/META-INF/";
    }

}
