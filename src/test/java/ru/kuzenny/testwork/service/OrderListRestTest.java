package ru.kuzenny.testwork.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.web.AbstractControllerTest;
import ru.kuzenny.testwork.web.GoodsRestController;
import ru.kuzenny.testwork.web.OrderListRestController;
import ru.kuzenny.testwork.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.kuzenny.testwork.OrderListTestData.GOODS1;
import static ru.kuzenny.testwork.OrderListTestData.GOODS_ID_1;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_DTO1;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_DTO2;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_ID_18;
import static ru.kuzenny.testwork.OrderListTestData.assertMatchOrder;
import static ru.kuzenny.testwork.OrderListTestData.assertMatchOrderDto;
import static ru.kuzenny.testwork.OrderListTestData.contentJson;
import static ru.kuzenny.testwork.OrderListTestData.getCreatedOrder;
import static ru.kuzenny.testwork.TestUtil.readFromJson;

public class OrderListRestTest extends AbstractControllerTest {

    @Autowired
    private OrderService orderService;

    private static final String REST_URL = OrderListRestController.REST_ORDER_LIST_URL + '/';

    @Test
    void getGoodsById() throws Exception {
        mockMvc.perform(get(GoodsRestController.REST_GOODS_URL + "/id/" + GOODS_ID_1))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(GOODS1));
    }

    @Test
    public void deleteOrder() throws Exception {
        mockMvc.perform(get(REST_URL + "delete/" + ORDER_ID_18))
                .andExpect(status().isOk());
        var orders = orderService.getAll();
        assertMatchOrderDto(orders, ORDER_DTO1, ORDER_DTO2);
    }

    @Test
    public void createOrder() throws Exception {
        Order created = getCreatedOrder();
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created)))
                .andExpect(status().isCreated());
        Order returned = readFromJson(action, Order.class);
        created.setId(returned.getId());
        assertMatchOrder(returned, created);
        assertMatchOrder(orderService.get(returned.getId()), created);
    }

}
