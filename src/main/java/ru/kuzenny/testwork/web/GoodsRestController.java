package ru.kuzenny.testwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kuzenny.testwork.model.Goods;
import ru.kuzenny.testwork.service.GoodsService;

import java.util.List;

@RestController
@RequestMapping(value = GoodsRestController.REST_GOODS_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class GoodsRestController {

    @Autowired
    private GoodsService goodsService;

    public static final String REST_GOODS_URL = "/rest/goods";

    @GetMapping("")
    public List<Goods> getAllGoods() {
        return goodsService.getAll();
    }

    @GetMapping("/{orderId}")
    public List<Goods> getGoodsByOrderId(@PathVariable int orderId) {
        return goodsService.getAll();
    }

    @GetMapping("/id/{id}")
    public Goods getGoodsById(@PathVariable int id) {
//        return goodsService.get(id);
        return goodsService.get(id).isPresent() ? goodsService.get(id).get() : null;
    }

}
