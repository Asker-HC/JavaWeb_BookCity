package com.hucheng.test;

import com.hucheng.dao.BookDao;
import com.hucheng.dao.impl.BookDaoImpl;
import com.hucheng.pojo.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(12);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDao.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalItems() {
        List<Book> books = bookDao.queryForItems(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,200));
    }

    @Test
    public void queryForPageTotalItemsByPrice() {
        List<Book> books = bookDao.queryForItemsByPrice(0, 4,10,200);
        for (Book book : books) {
            System.out.println(book);
        }
    }

}