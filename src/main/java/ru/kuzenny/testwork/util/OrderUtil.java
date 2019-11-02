package ru.kuzenny.testwork.util;

import ru.kuzenny.testwork.dto.OrderDto;
import ru.kuzenny.testwork.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrderUtil {

    public static List<OrderDto> getOrderDtoList(List<Order> orders) {
        List<Integer> numberOrders = orders.stream()
                .map(Order::getNumberOrder)
                .distinct()
                .collect(Collectors.toList());
        return numberOrders.stream()
                .map(number -> getOrderDto(number, orders))
                .collect(Collectors.toList());
    }

    private static OrderDto getOrderDto(Integer numberOrder, List<Order> orders) {
        BigDecimal sum = new BigDecimal("0");
        for (Order order: orders) {
            if (order.getNumberOrder().equals(numberOrder) && order.getOrderList() != null){
                sum = sum.add(order.getOrderList().getCost());
            }
        }
        final var sumFinal = sum;
        return orders.stream()
                .filter(order -> order.getNumberOrder().equals(numberOrder))
                .map(order -> new OrderDto(
                        order.getId(),
                        order.getNumberOrder(),
                        order.getEmail(),
                        LocalDateTime.now(),
                        sumFinal))
                .findFirst().orElse(null);
    }

    public static List<Order> getOrderByNumberOrder(Integer numberOrder, List<Order> orders){
        return orders.stream()
                .filter(order -> order.getNumberOrder().equals(numberOrder))
                .collect(Collectors.toList());
    }

}
