package azarenka.repository.mybatis;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CrudRepository<ID, T> extends Repository<T> {
    void save(T o);

    T read(ID id);

    List<T> readAll();

    void update(T o);

    void delete(ID id);
}
