package org.myeducation.databaseapi.dao;

import org.myeducation.databaseapi.dao.hibernate.HibernateDaoFactory;
<<<<<<< HEAD
=======
import org.myeducation.properties.PropertiesFactory;
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: kirilkadurilka
 * Date: 17.02.13
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public class Dao {

    private static Logger logger = Logger.getLogger(Dao.class.getName());

    private static volatile DaoFactory daoFactory = null;

    private Dao(){
    }

    public static DaoFactory getFactory(){
        DaoFactory factory = daoFactory;
        if (factory == null){
            synchronized (DaoFactory.class){
                factory = daoFactory;
                if (factory == null){
<<<<<<< HEAD
                    try{
                        Properties properties = new Properties();
                        String fileName = "dao.properties";
                        String folder = "properties";
                        String module = "databaseapi";
                        properties.load(new FileReader(module+File.separator+folder+File.separator+fileName));
                        String daoType = (String)properties.get("dao.factory.type");
                        if (daoType.equals("hibernate")){
                            daoFactory = factory = new HibernateDaoFactory();
                            return daoFactory;
                        }
                    }catch (IOException ex){
                        logger.log(Level.SEVERE, "Exception : " + ex);
=======
                    Properties properties = PropertiesFactory.getProperties("dao");
                    String daoType = (String)properties.get("dao.factory.type");
                    if (daoType.equals("hibernate")){
                        daoFactory = factory = new HibernateDaoFactory();
                        return daoFactory;
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254
                    }
                }
            }
        }
        return daoFactory;
    }
}
