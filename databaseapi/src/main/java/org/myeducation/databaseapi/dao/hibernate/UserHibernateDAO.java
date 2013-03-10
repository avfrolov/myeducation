package org.myeducation.databaseapi.dao.hibernate;

import org.myeducation.databaseapi.dao.UserDAO;
import org.myeducation.databaseapi.entities.User;
import org.myeducation.databaseapi.entities.UserLogin;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 11.02.13
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */
//TODO
//    fix critic situations!!!
public class UserHibernateDAO implements UserDAO{

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("server");

    public void addUser(String login, String password, User userInfo){

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        UserLogin userLogin = new UserLogin();
        userLogin.setLogin(login);
        userLogin.setUser(userInfo);
        userLogin.setPassword(password);

        manager.persist(userLogin);

        manager.getTransaction().commit();
        manager.close();
    }

    public void updateUserInfo(String login, User user){

    }

    public void updateUserLogin(String oldLogin, String newLogin){

    }

    public void removeUser(int id){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        UserLogin login = getLogin(id);

        manager.remove(login);

        manager.getTransaction().commit();
    }

    public void removeUser(UserLogin user){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.remove(user);
        manager.getTransaction().commit();
        manager.close();
    }

    public void removeUser(String login){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        UserLogin user = getLogin(login);
        UserLogin removeUser = manager.find(UserLogin.class, user.getId());
        manager.remove(removeUser);
        manager.getTransaction().commit();
        manager.close();
    }

    public UserLogin getLogin(int id){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        UserLogin login = manager.find(UserLogin.class, id);
        manager.remove(login);
        manager.getTransaction().commit();
        manager.close();
        return login;
    }

    public UserLogin getLogin(String login){
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createNamedQuery("select_UserLogin_by_login");
        query.setParameter("login", login);
        UserLogin userLogin =  (UserLogin)query.getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return userLogin;
    }
}
