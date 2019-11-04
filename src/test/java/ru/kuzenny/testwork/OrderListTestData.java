package ru.kuzenny.testwork;

import org.springframework.test.web.servlet.ResultMatcher;
import ru.kuzenny.testwork.dto.OrderDto;
import ru.kuzenny.testwork.model.Goods;
import ru.kuzenny.testwork.model.Order;
import ru.kuzenny.testwork.model.OrderList;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.kuzenny.testwork.TestUtil.readFromJsonMvcResult;

public class OrderListTestData {
    public static final int ORDER_LIST_ID = 7;
    public static final int NUMBER_ORDER_114 = 114;
    public static final int ORDER_ID_13 = 13;
    public static final int ORDER_ID_18 = 18;
    public static final int GOODS_ID_1 = 1;
    public static final LocalDateTime SEPTEMBER_27 = (of(2019, Month.SEPTEMBER, 27, 23, 0));

    public static final OrderList ORDER_LIST1 = new OrderList(ORDER_LIST_ID,     1, new BigDecimal(100.99),   2, new BigDecimal(201.98));
    public static final OrderList ORDER_LIST2 = new OrderList(ORDER_LIST_ID + 1, 2, new BigDecimal(80000.94), 3, new BigDecimal(240002.82));
    public static final OrderList ORDER_LIST3 = new OrderList(ORDER_LIST_ID + 2, 3, new BigDecimal(122.02),   1, new BigDecimal(122.02));
    public static final OrderList ORDER_LIST4 = new OrderList(ORDER_LIST_ID + 3, 4, new BigDecimal(50200.23), 4, new BigDecimal(200800.92));
    public static final OrderList ORDER_LIST5 = new OrderList(ORDER_LIST_ID + 4, 5, new BigDecimal(64.21),   12, new BigDecimal(770.52));
    public static final OrderList ORDER_LIST6 = new OrderList(ORDER_LIST_ID + 5, 6, new BigDecimal(2.01),   112, new BigDecimal(225.12));
    public static final List<OrderList> ORDERS_LIST = List.of(ORDER_LIST1, ORDER_LIST2, ORDER_LIST3, ORDER_LIST4, ORDER_LIST5, ORDER_LIST6);

    public static final OrderDto ORDER_DTO1 = new OrderDto(13, 111, "user1@yandex.ru", of(2019, 9, 29, 0, 1, 1), new BigDecimal(201773.42));
    public static final OrderDto ORDER_DTO2 = new OrderDto(16, 112, "user2@yandex.ru", of(2019, 9, 28, 10, 11, 11), new BigDecimal(240227.94));

    public static final Goods GOODS1 = new Goods(GOODS_ID_1, "макароны", new BigDecimal(100.99));

    public static OrderList getCreatedOrderList() {
        return new OrderList(null, 7,  new BigDecimal(32.00), 9, new BigDecimal(288));
    }

    public static Order getCreatedOrder() {
        return new Order(null, NUMBER_ORDER_114, "admin@yandex.ru", SEPTEMBER_27, null);
    }

    public static void assertMatch(OrderList actual, OrderList expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "cost", "priceOrder");
    }

    public static void assertMatch(Iterable<OrderList> actual, OrderList ... expected) {
        assertMatch(actual, List.of(expected));
    }

    public static void assertMatch(Iterable<OrderList> actual, Iterable<OrderList> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("cost", "priceOrder").isEqualTo(expected);
    }


    public static void assertMatchGoods(Goods actual, Goods expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "priceGoods");
    }

    public static ResultMatcher contentJson(Goods expected) {
        return result -> assertMatchGoods(readFromJsonMvcResult(result, Goods.class), expected);
    }

    public static void assertMatchOrderDto(OrderDto actual, OrderDto expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "sum");
    }

    public static void assertMatchOrderDto(Iterable<OrderDto> actual, OrderDto ... expected) {
        assertMatchOrderDto(actual, List.of(expected));
    }

    public static void assertMatchOrderDto(Iterable<OrderDto> actual, Iterable<OrderDto> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("sum").isEqualTo(expected);
    }

    public static void assertMatchOrder(Order actual, Order expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "time", "orderList");
    }

    public static void assertMatchOrder(Iterable<Order> actual, Order ... expected) {
        assertMatchOrder(actual, List.of(expected));
    }

    public static void assertMatchOrder(Iterable<Order> actual, Iterable<Order> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields( "time", "orderList").isEqualTo(expected);
    }

}
