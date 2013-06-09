package org.myeducation.portal.server.objects;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 22:50
 * To change this template use File | Settings | File Templates.
 */
public class UserLoginGWT implements Serializable {

    private int id;
    private String login;
    private String password;
    private UserGWT user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserGWT getUser() {
        return user;
    }

    public void setUser(UserGWT user) {
        this.user = user;
    }
}
