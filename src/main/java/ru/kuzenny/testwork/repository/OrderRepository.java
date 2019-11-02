package ru.kuzenny.testwork.repository;

import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.model.OrderList;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    void delete(int id);

    void deleteByNumberOrder(int id);

    Order get(int id);

    List<Order> getByNumberOrder(int numdeberOrder);

    List<Order> getAll();

    List<Order> getOrdersByNumberOrder(int numdeberOrder);

   Order getOrderByOrderList(Integer orderListId);

}
