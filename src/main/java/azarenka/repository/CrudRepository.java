package azarenka.repository;

import java.util.List;

public interface CrudRepository<ID, T> extends Repository<T> {
    void save(T o);

    T read(ID id);

    List<T> readAll();

    void update(T o);

    void delete(ID id);
}
