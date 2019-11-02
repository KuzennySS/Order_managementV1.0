package ru.kuzenny.testwork.repository;

import ru.kuzenny.testwork.model.OrderList;

import java.util.List;

public interface OrderListRepository {

    OrderList save(OrderList orderList);

    void delete(int id);

    OrderList get(int id);

    List<OrderList> getAll();
}
