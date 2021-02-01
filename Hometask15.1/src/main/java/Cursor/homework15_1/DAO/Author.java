package Cursor.homework15_1.DAO;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class Author implements CRUDInterface<Author> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SneakyThrows
    @Override
    public void create(Author authors) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(authors);
        tr.commit();
        session.close();
    }

    @Override
    public Author read(int id) {
        return this.sessionFactory.openSession().get(Author.class, id);
    }

    @Override
    public void update(Author authors) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(authors);
        tr.commit();
        session.close();
    }

    @Override
    public void delete(Author authors) {
        Session session = this.sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.update(authors);
        tr.commit();
        session.close();
    }



    @Override
    public List<Author> getAll(Class<Author> nameOfAuthors) {
        List<Author> authors = (List<Author>) sessionFactory.openSession()
                .createQuery("From Author")
                .list();
        return authors;
    }


    public void setName(String name) {

    }

    public void setBookList(List<Book> bookList) {

    }
}
