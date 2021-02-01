package Cursor.homework15_1;

import Cursor.homework15_1.DAO.Author;
import Cursor.homework15_1.DAO.Book;
import Cursor.homework15_1.DAO.CRUDInterface;
import Cursor.homework15_1.DAO.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TheEndApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Configurations.class);

        CRUDInterface<Author> authorDao = context.getBean(Author.class);
        CRUDInterface<Book> bookDao = context.getBean(Book.class);
        CRUDInterface<User> userDao = context.getBean(User.class);


        Author authorRKipling = context.getBean(Author.class);
        Book bookOfJungle = context.getBean(Book.class);
        User userBearBalu = context.getBean(User.class);

        bookOfJungle.setName("Harry Potter and the Philosopher's Stone");
        List<Author> authorList = new ArrayList<>();

        authorRKipling.setName("J. K. Rowling");
        authorDao.create(authorRKipling);
        authorList.add(authorRKipling);
        bookOfJungle.setAuthorList(authorList);
        bookDao.create(bookOfJungle);

        userBearBalu.setName("Steven Yablonsky");
        userDao.create(userBearBalu);
        List<Book> bookList = new ArrayList<>();
        bookList.add(bookOfJungle);
        authorRKipling.setBookList(bookList);
        authorDao.update(authorRKipling);
        userBearBalu.setBookList(bookList);
        userDao.update(userBearBalu);


    }
}

