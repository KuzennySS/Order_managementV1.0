package ru.kuzenny.testwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzenny.testwork.dto.OrderDto;
import ru.kuzenny.testwork.service.OrderService;

import java.util.List;

@RestController
@RequestMapping(value = OrdersRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersRestController {

    @Autowired
    private OrderService orderService;

    public static final String REST_URL = "/rest";

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/delete/{numberOrder}")
    public void delete(@PathVariable int numberOrder) {
        orderService.deleteByNumberOrder(numberOrder);
    }

    @GetMapping(value = "/downloadXml", produces = MediaType.TEXT_XML_VALUE)
    public List<OrderDto> downloadXml() {
        return orderService.getAll();
    }
}
