package com.jerometang.springboot.jdbc.dao.impl;

import com.jerometang.springboot.jdbc.dao.IBookDAO;
import com.jerometang.springboot.jdbc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jtang on 7/13/2017.
 */

@Repository
public class BookDaoImpl  implements IBookDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Book book) {
        return jdbcTemplate.update("insert into book(name, price) values(?, ?)", book.getName(), book.getPrice());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update("UPDATE book set name=?, price=? where id=?", book.getName(), book.getPrice(), book.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from table book where id=?", id);
    }

    @Override
    public Book findBookById(int id) {
        List<Book> list = jdbcTemplate.query("select * from book where id = ?", new Object[]{id}, new BeanPropertyRowMapper<Book>(Book.class));
        if(list != null && list.size() > 0){
            Book book = list.get(0);
            return book;
        }else{
            return null;
        }
    }

    @Override
    public List<Book> findBookList() {
        List<Book> list = jdbcTemplate.query("select * from book", new Object[]{}, new BeanPropertyRowMapper<Book>(Book.class));
        if(list != null && list.size() > 0){
            return list;
        }
        return null;
    }
}
