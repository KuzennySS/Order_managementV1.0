package ru.kuzenny.testwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzenny.testwork.dto.OrderDto;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.repository.OrderRepository;
import ru.kuzenny.testwork.util.OrderUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.orderRepository = repository;
    }

    public Order get(int id) {
        return orderRepository.get(id);
    }

    public OrderDto getNumberOrderDto(int numdeberOrder) {
        return getAll().stream()
                .filter(orderDto -> orderDto.getNumberOrder().equals(numdeberOrder))
                .findFirst().orElse(null);
    }

    public List<Order> getOrderByNumberOrder(int numdeberOrder){
        return orderRepository.getOrdersByNumberOrder(numdeberOrder);
    }

    public void delete(int id) {
        orderRepository.delete(id);
    }

    public void deleteByNumberOrder(int numberOrder){
        orderRepository.deleteByNumberOrder(numberOrder);
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrderIdByOrderList(Integer orderListId){
        return orderRepository.getOrderByOrderList(orderListId);
    }

    public List<OrderDto> getAll() {
        return OrderUtil.getOrderDtoList(orderRepository.getAll());
    }

    public List<Integer> getOrderListIdByNumberOrder(Integer numberOrder) {
        return OrderUtil.getOrderByNumberOrder(numberOrder, orderRepository.getAll()).stream()
                 .map(this::receiveOrderList)
                 .collect(Collectors.toList());
    }

    private Integer receiveOrderList(Order order){
        if (order.getOrderList() == null) return null;
        return order.getOrderList().getId();
    }


}
