package com.jerometang.springboot.jdbc.web;

import com.jerometang.springboot.jdbc.entity.Book;
import com.jerometang.springboot.jdbc.service.IBookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by jtang on 7/13/2017.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService bookService;

    @ApiOperation(value = "Get book list", notes = "Get all available book list")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Book> getBooks(){
        return bookService.findBookList();
    }


    @ApiOperation(value = "Get book by Id", notes = "Get one book with book Id")
    @ApiImplicitParam(name = "id", value = "Book Id", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") int id){
        return bookService.findBookById(id);
    }

    @ApiOperation(value = "Update book info", notes = "Update book info with book id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Book Id", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "name", value = "Book Name", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "price", value = "Book Price", required = true, dataType = "Double", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "price", required = true)double price){
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setId(id);
        int result = bookService.update(book);
        if(result == 1){
            return book.toString();
        }else {
            return "Update book failed";
        }
    }

    @ApiOperation(value = "Add new book", notes = "Add one new book")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "Book Name", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "price", value = "Book Price", required = true, dataType = "Double", paramType = "path")
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String newBook(@RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "price", required = true) double price){
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        int result = bookService.addBook(book);
        if(result == 1){
            return book.toString();
        }else {
            return "Add book failed";
        }
    }

}
