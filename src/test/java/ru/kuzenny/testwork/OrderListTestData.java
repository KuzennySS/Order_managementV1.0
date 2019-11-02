package ru.kuzenny.testwork;

import ru.kuzenny.testwork.model.OrderList;

import java.math.BigDecimal;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderListTestData {
    public static final int ORDER_LIST_ID = 7;
    public static final int ORDER_ID = 13;

    public static final OrderList ORDER_LIST1 = new OrderList(ORDER_LIST_ID,     1, new BigDecimal(100.99),   2, new BigDecimal(201.98));
    public static final OrderList ORDER_LIST2 = new OrderList(ORDER_LIST_ID + 1, 2, new BigDecimal(80000.94), 3, new BigDecimal(240002.82));
    public static final OrderList ORDER_LIST3 = new OrderList(ORDER_LIST_ID + 2, 3, new BigDecimal(122.02),   1, new BigDecimal(122.02));
    public static final OrderList ORDER_LIST4 = new OrderList(ORDER_LIST_ID + 3, 4, new BigDecimal(50200.23), 4, new BigDecimal(200800.92));
    public static final OrderList ORDER_LIST5 = new OrderList(ORDER_LIST_ID + 4, 5, new BigDecimal(64.21),   12, new BigDecimal(770.52));
    public static final OrderList ORDER_LIST6 = new OrderList(ORDER_LIST_ID + 5, 6, new BigDecimal(2.01),   112, new BigDecimal(225.12));
    public static final List<OrderList> ORDERS_LIST = List.of(ORDER_LIST1, ORDER_LIST2, ORDER_LIST3, ORDER_LIST4, ORDER_LIST5, ORDER_LIST6);

    public static OrderList getCreated() {
        return new OrderList(null, 7,  new BigDecimal(32.00), 9, new BigDecimal(288));
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
}
