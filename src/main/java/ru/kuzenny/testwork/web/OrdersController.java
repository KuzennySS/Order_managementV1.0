package ru.kuzenny.testwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kuzenny.testwork.dto.OrderListDto;
import ru.kuzenny.testwork.model.Goods;
import ru.kuzenny.testwork.model.OrderList;
import ru.kuzenny.testwork.service.GoodsService;
import ru.kuzenny.testwork.service.OrderListService;
import ru.kuzenny.testwork.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderListService orderListService;

    @GetMapping("/")
    public String root() {
//        return "index";
        return "redirect:orders";
    }

    @GetMapping("/orders")
    public String users(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @GetMapping("/orders/delete/{numberOrder}")
    public String delete(@PathVariable int numberOrder) {
        orderService.deleteByNumberOrder(numberOrder);
        return "redirect:/orders";
    }


/*    @PostMapping("/orders")
    public String setUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        SecurityUtil.setAuthUserId(userId);
        return "redirect:meals";
    }*/
}
