package ru.kuzenny.testwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.service.OrderService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = OrderListRestController.REST_ORDER_LIST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderListRestController {

    @Autowired
    private OrderService orderService;

    public static final String REST_ORDER_LIST_URL = "/rest/orderList";

    @GetMapping("/{numberOrder}")
    public List<Order> getOrdersByNumberOrder(@PathVariable int numberOrder) {
        return orderService.getOrderByNumberOrder(numberOrder);
    }

    @GetMapping("/delete/{orderId}")
    public void delete(@PathVariable int orderId) {
        orderService.delete(orderId);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order created = orderService.create(order);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_ORDER_LIST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

}
