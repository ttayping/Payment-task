package org.hibernate.practice.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.practice.model.Account;
import org.hibernate.practice.model.Card;
import org.hibernate.practice.model.Merchant;
import org.hibernate.practice.model.Operation;

public class ConnectionUtil {
    private ConnectionUtil() {
    }

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/aptek");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "admin");

            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.setProperty("hibernate.format_sql", "true");

            configuration.setProperty("hibernate.hbm2ddl.auto", "create");


            configuration.addAnnotatedClass(Account.class); // Add your entity classes here
            configuration.addAnnotatedClass(Card.class); // Add your entity classes here
            configuration.addAnnotatedClass(Merchant.class); // Add your entity classes here
            configuration.addAnnotatedClass(Operation.class); // Add your entity classes here


            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());

            return configuration.buildSessionFactory(serviceRegistryBuilder.build());

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Failed to build SessionFactory: " + ex.getMessage(), ex);
        }
    }public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}

