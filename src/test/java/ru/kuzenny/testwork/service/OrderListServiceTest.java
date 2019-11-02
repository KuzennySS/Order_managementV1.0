package ru.kuzenny.testwork.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.kuzenny.testwork.model.OrderList;

import static ru.kuzenny.testwork.OrderListTestData.ORDER_LIST1;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_LIST2;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_LIST3;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_LIST4;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_LIST5;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_LIST6;
import static ru.kuzenny.testwork.OrderListTestData.ORDERS_LIST;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_ID;
import static ru.kuzenny.testwork.OrderListTestData.ORDER_LIST_ID;
import static ru.kuzenny.testwork.OrderListTestData.assertMatch;
import static ru.kuzenny.testwork.OrderListTestData.getCreated;

@SpringJUnitConfig(locations = {
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
class OrderListServiceTest {

    @Autowired
    protected OrderListService service;

    @Autowired
    protected OrderService orderService;

    @Test
    void get() {
        OrderList orderList = service.get(ORDER_LIST_ID);
        assertMatch(orderList, ORDER_LIST1);
    }

    @Test
    void delete() {
        orderService.delete(ORDER_ID);
        service.delete(ORDER_LIST_ID);
        assertMatch(service.getAll(), ORDER_LIST2, ORDER_LIST3, ORDER_LIST4, ORDER_LIST5, ORDER_LIST6);
    }

    @Test
    void getAll() throws Exception {
        assertMatch(service.getAll(), ORDERS_LIST);
    }
}