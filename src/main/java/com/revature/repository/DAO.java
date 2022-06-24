package com.revature.repository;
import java.sql.SQLException;
import java.util.List;

/*
        Generics: data type placeholders that allow you to provide the same implementation for different data types
        while also adhering to type safety

        List<String>
        List<Flashcard>
 */
public interface DAO<T> {

    T create(T t);

    List<T> getAll();

    T getById(int id);

    T update(T t);

    boolean deleteById(int id);
}
