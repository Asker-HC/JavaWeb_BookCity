package com.hucheng.service.impl;

import com.hucheng.dao.BookDao;
import com.hucheng.dao.impl.BookDaoImpl;
import com.hucheng.pojo.Book;
import com.hucheng.pojo.Page;
import com.hucheng.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    /**
     * 添加图书信息
     *
     * @param book
     */
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    /**
     * 根据id删除图书
     *
     * @param id
     */
    @Override
    public void deleteBookByID(Integer id) {
        bookDao.deleteBookById(id);
    }

    /**
     * 修改图书信息
     *
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    /**
     * 根据id查询图书
     *
     * @param id
     * @return
     */
    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    /**
     * 查询多本图书
     *
     * @return
     */
    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<Book>();
        //设置每页条目数
        page.setPageSize(pageSize);
        //获取数据库总条目数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //计算总页码数，若有余数则页码加1
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        //设置当前页码(检查数据边界)
        page.setPageNo(pageNo);
        //获取当前页码数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> books = bookDao.queryForItems(begin, pageSize);
        page.setItems(books);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {

        Page<Book> page = new Page<Book>();
        //设置每页条目数
        page.setPageSize(pageSize);
        //获取数据库总条目数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);
        //计算总页码数，若有余数则页码加1
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        //设置当前页码(检查数据边界)
        page.setPageNo(pageNo);
        //获取当前页码数据
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> books = bookDao.queryForItemsByPrice(begin, pageSize, min, max);
        page.setItems(books);
        return page;
    }


}
