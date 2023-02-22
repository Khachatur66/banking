package common.banking.service.interfaces;

import common.banking.exception.NotFoundException;

import java.util.List;

public interface AbstractService<T>{

    List<T> getAll();

    void save(T t);

    void update(T t);

    void deleteById(int id);

}
