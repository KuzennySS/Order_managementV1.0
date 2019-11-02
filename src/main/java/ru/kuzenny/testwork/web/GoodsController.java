package ru.kuzenny.testwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuzenny.testwork.dto.OrderListDto;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.model.OrderList;
import ru.kuzenny.testwork.service.GoodsService;
import ru.kuzenny.testwork.service.OrderListService;
import ru.kuzenny.testwork.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/{orderId}")
    public String goods(Model model, @PathVariable int orderId) {
        model.addAttribute("goods", goodsService.getAll());
        return "goods";
    }

    @PostMapping("/add")
    public String addGoods(HttpServletRequest request) {
        var goodId = Integer.parseInt(request.getParameter("id"));
        var goods = goodsService.get(goodId);
        var numberItem = Integer.parseInt(request.getParameter("numberItem"));
        var orderList = new OrderList(
                goodId,
                goods.getPriceGoods(),
                numberItem,
                goods.getPriceGoods().multiply(new BigDecimal(numberItem))
        );
        orderListService.create(orderList);
        var orderId = Integer.parseInt(request.getParameter("orderId"));
        var orderOld = orderService.get(orderId);
        var numberOrder = orderOld.getNumberOrder();
        var order = new Order(
                numberOrder,
                orderOld.getEmail(),
                LocalDateTime.now(),
                orderList
        );
        orderService.create(order);
        if (orderService.get(orderId).getOrderList() == null) {
            orderService.delete(orderId);
        }
        return "redirect:/look/" + numberOrder;
    }


}
