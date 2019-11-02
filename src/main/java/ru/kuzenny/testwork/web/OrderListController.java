package ru.kuzenny.testwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuzenny.testwork.dto.OrderDto;
import ru.kuzenny.testwork.dto.OrderListDto;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.model.OrderList;
import ru.kuzenny.testwork.service.GoodsService;
import ru.kuzenny.testwork.service.OrderListService;
import ru.kuzenny.testwork.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/look")
public class OrderListController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/add/{orderId}")
    public String add(@PathVariable int orderId) {
        return "redirect:/goods/{orderId}";
    }

    @GetMapping("/{numberOrder}")
    public String view(@PathVariable int numberOrder, Model model) {
        model.addAttribute("orders", orderService.getNumberOrderDto(numberOrder));
        model.addAttribute("looks", getOrderListDtos(numberOrder));
        return "ordersList";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request, Model model) {
        model.addAttribute("orderForm", orderService.getNumberOrderDto(getNumberOrder(request)));
        return "orderForm";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("orderForm", new OrderDto());
        return "orderForm";
    }

    @GetMapping("/delete/{orderId}")
    public String delete(@PathVariable int orderId, Model model) {
        var numberOrder = orderService.get(orderId).getNumberOrder();
        orderService.delete(orderId);
        List<OrderListDto> orderListDtos = getOrderListDtos(numberOrder);
        model.addAttribute("orders", orderService.getNumberOrderDto(numberOrder));
        model.addAttribute("looks", orderListDtos);
        return "redirect:/look/" + numberOrder;
    }

    @PostMapping("/orderForm")
    public String updateOrder(HttpServletRequest request) {
        var newNumberOrder = Integer.parseInt(request.getParameter("newNumberOrder"));
        var newEmail = request.getParameter("email");
        if (request.getParameter("oldNumberOrder").isEmpty()) {
            var order = new Order();
            setNewField(order, newNumberOrder, newEmail);

        } else {
            var oldNumberOrder = Integer.valueOf(request.getParameter("oldNumberOrder"));
            orderService.getOrderByNumberOrder(oldNumberOrder)
                    .forEach(order -> setNewField(order, newNumberOrder, newEmail));
        }
        return "redirect:/look/" + newNumberOrder;
    }

    private void setNewField(Order order, Integer numberOrder, String email) {
        order.setEmail(email);
        order.setNumberOrder(numberOrder);
        order.setTime(LocalDateTime.now());
        orderService.create(order);
    }

    public List<OrderListDto> getOrderListDtos(int numberOrder) {
        List<Integer> orderListId = orderService.getOrderListIdByNumberOrder(numberOrder);
        if (orderListId.contains(null)) return Collections.EMPTY_LIST;
        List<OrderList> orderLists = orderListId.stream()
                .map(id -> orderListService.get(id))
                .collect(Collectors.toList());
        List<OrderListDto> orderListDtos = new ArrayList<>();
        orderLists.forEach(orderList -> orderListDtos.add(
                new OrderListDto(
                        orderList.getGoodId(),
                        goodsService.get(orderList.getGoodId()).getName(),
                        orderList.getPriceOrder(),
                        orderList.getNumber(),
                        orderList.getCost(),
                        orderService.getOrderIdByOrderList(orderList.getId()).getId()
                )
        ));
        return orderListDtos;
    }

    private int getNumberOrder(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("numberOrder"));
        return Integer.valueOf(paramId);
    }

}
