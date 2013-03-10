package org.myeducation.databaseapi.service;

import org.myeducation.databaseapi.dao.DaoFactory;
import org.myeducation.databaseapi.service.local.LocalServiceFactory;
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
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public class Service {
    private static Logger logger = Logger.getLogger(Service.class.getName());

    private static volatile ServiceFactory serviceFactory = null;

    private Service(){
    }

    public static ServiceFactory getFactory(){
        ServiceFactory factory = serviceFactory;
        if (factory == null){
            synchronized (DaoFactory.class){
                factory = serviceFactory;
                if (factory == null){
<<<<<<< HEAD
                    try{
                        Properties properties = new Properties();
                        String fileName = "service.properties";
                        String folder = "properties";
                        String module = "databaseapi";
                        properties.load(new FileReader(module+ File.separator+folder+File.separator+fileName));
                        String daoType = (String)properties.get("service.factory.type");
                        if (daoType.equals("local")){
                            serviceFactory = factory = new LocalServiceFactory();
                            return serviceFactory;
                        }
                    }catch (IOException ex){
                        logger.log(Level.SEVERE, "Exception : " + ex);
=======
                    Properties properties = PropertiesFactory.getProperties("service");
                    String daoType = (String)properties.get("service.factory.type");
                    if (daoType.equals("local")){
                        serviceFactory = factory = new LocalServiceFactory();
                        return serviceFactory;
>>>>>>> 180b853cfad84588e2e4c3fcb85e9fb8e82e5254
                    }
                }
            }
        }
        return serviceFactory;
    }
}
