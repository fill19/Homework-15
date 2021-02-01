package Cursor.homework15_1.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public  class User implements CRUDInterface<User> {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(User users) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(users);
        tr.commit();
        session.close();
    }

    @Override
    public User read(int id) {
        return this.sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public void update(User users) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(users);
        tr.commit();
        session.close();
    }

    @Override
    public void delete(User users) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(users);
        tr.commit();
        session.close();
    }


    @Override
    public List<User> getAll(Class<User> typeOfUsers) {
        List<User> books = (List<User>) sessionFactory.openSession()
                .createQuery("From Author")
                .list();
        return books;
    }

    public void setName(String name) {

    }

    public void setBookList(List<Book> bookList) {

    }
}
