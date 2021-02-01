package Cursor.homework15_1.DAO;

import java.util.List;

public interface CRUDInterface<T> {
    void create(T model);

    T read(int id);

    void update(T model);

    void delete(T model);

    List<T> getAll(Class<T> type);


}
