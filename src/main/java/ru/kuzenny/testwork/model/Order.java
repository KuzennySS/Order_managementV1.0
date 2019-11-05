package ru.kuzenny.testwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
        @NamedQuery(name = "Order.findByOrderList", query = "SELECT o FROM Order o WHERE o.orderList.id = ?1"),
        @NamedQuery(name = "Order.findByNumderOrder", query = "SELECT o FROM Order o WHERE o.numberOrder=?1"),
})
@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "order_list_id"}, name = "orders_idx")})
public class Order extends AbstractBaseEntity {

    @Column(name = "number_order", nullable = false)
    @NotNull
    private Integer numberOrder;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "time", nullable = false)
    @NotNull
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_list_id")
    private OrderList orderList;

    public Integer getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(Integer numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public Order() {}

    public Order(Integer id, @NotNull Integer numberOrder, @Email @NotBlank @Size(max = 100) String email, @NotNull LocalDateTime time, @NotNull OrderList orderList) {
        super(id);
        this.numberOrder = numberOrder;
        this.email = email;
        this.time = time;
        this.orderList = orderList;
    }

    public Order(Integer numberOrder, String email, LocalDateTime time, @NotNull OrderList orderList) {
        this(null, numberOrder, email, time, orderList);
    }

    @Override
    public String toString() {
        return "Order{" +
                "numberOrder=" + numberOrder +
                ", email='" + email + '\'' +
                ", time=" + time +
                ", id=" + id +
                '}';
    }
}
