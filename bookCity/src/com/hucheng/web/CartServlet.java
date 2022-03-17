package com.hucheng.web;

import com.google.gson.Gson;
import com.hucheng.pojo.Book;
import com.hucheng.pojo.Cart;
import com.hucheng.pojo.CartItem;
import com.hucheng.service.BookService;
import com.hucheng.service.impl.BookServiceImpl;
import com.hucheng.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        int bookId = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(bookId);
        CartItem cartItem = new CartItem(bookId, book.getName(), 1, book.getPrice(), book.getPrice());
        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        if (cart != null){
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void clearItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null){
            cart.clear();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        if (cart != null){
            cart.updateCount(id,count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        int bookId = WebUtils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(bookId);
        CartItem cartItem = new CartItem(bookId, book.getName(), 1, book.getPrice(), book.getPrice());
        cart.addItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());
        Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName",cartItem.getName());
        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);
        response.getWriter().write(resultMapJsonString);
    }
}
