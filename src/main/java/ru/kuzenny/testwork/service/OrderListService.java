package ru.kuzenny.testwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzenny.testwork.model.OrderList;
import ru.kuzenny.testwork.repository.OrderListRepository;

import java.util.List;

@Service
public class OrderListService {

    private final OrderListRepository repository;

    @Autowired
    public OrderListService(OrderListRepository repository) {
        this.repository = repository;
    }

    public OrderList get(int id) {
        return repository.get(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public OrderList create(OrderList orderList) {
        return repository.save(orderList);
    }

    public List<OrderList> getAll() { return repository.getAll(); }
}
