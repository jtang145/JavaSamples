package cn.naches.examples.springboot.jdbc.service.impl;

import cn.naches.examples.springboot.jdbc.dao.IBookDAO;
import cn.naches.examples.springboot.jdbc.entity.Book;
import cn.naches.examples.springboot.jdbc.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jtang on 7/13/2017.
 */
@Service
public class BookService  implements IBookService{

    @Autowired
    private IBookDAO bookDAO;

    @Override
    public int addBook(Book book) {
        return bookDAO.add(book);
    }

    @Override
    public int update(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public int delete(int id) {
        return bookDAO.delete(id);
    }

    @Override
    public Book findBookById(int id) {
        return bookDAO.findBookById(id);
    }

    @Override
    public List<Book> findBookList() {
        return bookDAO.findBookList();
    }
}
