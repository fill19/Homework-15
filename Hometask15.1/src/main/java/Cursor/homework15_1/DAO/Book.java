package Cursor.homework15_1.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Book implements CRUDInterface<Book> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Book books) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(books);
        tr.commit();
        session.close();
    }

    @Override
    public Book read(int id) {
        return this.sessionFactory.openSession().get(Book.class, id);
    }

    @Override
    public void update(Book books) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(books);
        tr.commit();
        session.close();
    }

    @Override
    public void delete(Book books) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(books);
        tr.commit();
        session.close();
    }


    @Override
    public  List<Book> getAll(Class<Book> booksClass) {
        List<Book> books = (List<Book>) sessionFactory.openSession()
                .createQuery("From Author")
                .list();
        return books;
    }



    public void setAuthorList(List<Author> authorList) {

    }

    public void setName(String s) {

    }
}

