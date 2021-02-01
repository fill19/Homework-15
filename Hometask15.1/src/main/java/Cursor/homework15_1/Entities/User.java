package Cursor.homework15_1.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Component
@Entity
@Table(name = "users")
@Proxy(lazy = false)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;


    @Override
    public String toString() {
        return "User{" +
                "name = '" + name + "'" +
                ", books = " + books + "}";
    }
}