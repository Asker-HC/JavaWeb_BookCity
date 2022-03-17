package com.hucheng.service;

import com.hucheng.pojo.Book;
import com.hucheng.pojo.Page;

import java.util.List;

public interface BookService {
    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book);

    /**
     * 删除图书
     * @param id
     */
    public void deleteBookByID(Integer id);

    /**
     * 修改图书
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 查询单本图书
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询多本图书
     * @return
     */
    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);


    Page<Book> pageByPrice(int pageNo, int pageSize,int min, int max);
}
