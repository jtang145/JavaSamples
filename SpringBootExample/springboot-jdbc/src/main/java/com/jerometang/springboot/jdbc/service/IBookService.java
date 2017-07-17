package com.jerometang.springboot.jdbc.service;

import com.jerometang.springboot.jdbc.entity.Book;

import java.util.List;

/**
 * Created by jtang on 7/13/2017.
 */
public interface IBookService {

    int addBook(Book book);

    int update(Book book);

    int delete(int id);

    Book findBookById(int id);

    List<Book> findBookList();
}
