package ru.kuzenny.testwork.dto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@XStreamAlias("OrderDto")
public class OrderDto {

    @XStreamAlias("orderId")
    private Integer orderId;

    @XStreamAlias("numberOrder")
    private Integer numberOrder;

    @XStreamAlias("Email")
    private String email;

    @XStreamAlias("DateTime")
    private LocalDateTime time;

    @XStreamAlias("Sum")
    private BigDecimal sum;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public OrderDto() {
    }

    public OrderDto(Integer orderId, Integer numberOrder, String email, LocalDateTime time, BigDecimal sum) {
        this.orderId = orderId;
        this.numberOrder = numberOrder;
        this.email = email;
        this.time = time;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderId=" + orderId +
                ", numberOrder=" + numberOrder +
                ", email='" + email + '\'' +
                ", time=" + time +
                ", sum=" + sum +
                '}';
    }
}
