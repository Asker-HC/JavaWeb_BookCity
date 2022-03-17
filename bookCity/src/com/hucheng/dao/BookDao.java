package com.hucheng.dao;

import com.hucheng.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    public int addBook(Book book);

    /**
     * 通过id删除图书
     *
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 修改图书
     *
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     * 通过id查询单本图书
     *
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询多本图书
     *
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 查询数据库总记录数
     *
     * @return
     */
    public Integer queryForPageTotalCount();

    /**
     * 查询当前页数据
     *
     * @return
     */
    public List<Book> queryForItems(int begin, int pageSize);

    public Integer queryForPageTotalCountByPrice(int min, int max);

    public List<Book> queryForItemsByPrice(int begin, int pageSize, int min , int max);
}
