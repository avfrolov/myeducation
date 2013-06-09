package org.myeducation.portal.server.objects;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 02.06.13
 * Time: 22:49
 * To change this template use File | Settings | File Templates.
 */
public class UserGWT implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;
    private long createDate;
    private String photo;
    private UserLoginGWT login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public UserLoginGWT getLogin() {
        return login;
    }

    public void setLogin(UserLoginGWT login) {
        this.login = login;
    }
}
