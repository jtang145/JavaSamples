package com.jerometang.springboot.jdbc.dao;

import com.jerometang.springboot.jdbc.entity.Book;

import java.util.List;

/**
 * Created by jtang on 7/13/2017.
 */
public interface IBookDAO {
    int add(Book book);

    int update(Book book);

    int delete(int id);

    Book findBookById(int id);

    List<Book> findBookList();
}
