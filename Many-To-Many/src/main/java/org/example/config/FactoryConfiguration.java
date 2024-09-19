package org.example.config;

import org.example.entity.Address;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {


    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Student.class);
        configuration.configure().addAnnotatedClass(Address.class);
        sessionFactory= (SessionFactory) configuration.buildSessionFactory();

    }
    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }


    public Session getSession(){
        return sessionFactory.openSession();

    }
}
