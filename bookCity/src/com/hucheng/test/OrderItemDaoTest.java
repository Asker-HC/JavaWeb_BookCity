package com.hucheng.test;

import com.hucheng.dao.OrderItemDao;
import com.hucheng.dao.impl.OrderItemDaoImpl;
import com.hucheng.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"书",1,new BigDecimal(100),new BigDecimal(100),"1111"));
    }

    @Test
    public void queryOrderItemsByOrderId() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("16461234950612");
        System.out.println(orderItems);
    }
}