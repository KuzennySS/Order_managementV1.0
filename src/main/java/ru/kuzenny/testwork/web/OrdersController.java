package ru.kuzenny.testwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kuzenny.testwork.service.OrderService;

import static ru.kuzenny.testwork.xml.ConverterToXml.marshaller;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @GetMapping("/delete/{numberOrder}")
    public String delete(@PathVariable int numberOrder) {
        orderService.deleteByNumberOrder(numberOrder);
        return "redirect:/";
    }

    @GetMapping("/downloadXml")
    public String downloadXml() {
        marshaller(orderService.getAll());
        return "redirect:/";
    }

}
