package Cursor.homework15_1;

import Cursor.homework15_1.Entities.Author;
import Cursor.homework15_1.Entities.Book;
import Cursor.homework15_1.Entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("Cursor.homework15_1")
public class Configurations {

    @Bean
    SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            org.hibernate.cfg.Configuration configuration =
                    new org.hibernate.cfg.Configuration().configure();
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Author.class);
            StandardServiceRegistryBuilder builder =
                    new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Exception fail) {
            System.out.println("Some troubles in app " + fail);
        }
        return sessionFactory;
    }
}
