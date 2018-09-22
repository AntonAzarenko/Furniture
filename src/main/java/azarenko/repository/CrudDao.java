package azarenko.repository;

import java.util.List;

public interface CrudDao<ID, T> extends BaseDao<T> {
    void create(T o);

    T read(ID id);

    List<T> readAll();

    void update(T o);

    void delete(ID id);
}
