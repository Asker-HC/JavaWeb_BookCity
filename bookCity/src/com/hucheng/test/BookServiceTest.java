package com.hucheng.test;

import com.hucheng.pojo.Book;
import com.hucheng.pojo.Page;
import com.hucheng.service.BookService;
import com.hucheng.service.impl.BookServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"测试书籍",null,"程序员",null,null,""));
    }

    @Test
    public void deleteBookByID() {
        bookService.deleteBookByID(null);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(null,"测试书籍",null,"程序员",null,null,""));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(3);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book:books){
            System.out.println(book);
        }
    }
    @Test
    public void page() {
        Page<Book> page = bookService.page(1, 4);
        System.out.println(page);
    }

    @Test
    public void pageByPrice() {
        Page<Book> page = bookService.pageByPrice(1, 4, 10,100);
        System.out.println(page);
    }

}