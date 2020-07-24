package cn.naches.examples.springboot.jdbc.service;

import cn.naches.examples.springboot.jdbc.entity.Book;

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
