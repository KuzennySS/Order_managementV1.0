package ru.kuzenny.testwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

//@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = "OrderList.findAll", query = "SELECT ol FROM OrderList ol ORDER BY ol.id"),
        @NamedQuery(name = "OrderList.delete", query = "DELETE FROM OrderList ol WHERE ol.id=:id")
})
@Entity
@Table(name = "order_list", uniqueConstraints = {@UniqueConstraint(columnNames = {"goods_id", "number"}, name = "order_list_idx")})
public class OrderList extends AbstractBaseEntity {

    @Column(name = "goods_Id", nullable = false)
    @NotNull
    private Integer goodId;

    @Column(name = "price_order", nullable = false)
    @NotNull
    private BigDecimal priceOrder;

    @Column(name = "number", nullable = false)
    @NotNull
    private Integer number;

    @Column(name = "cost", nullable = false)
    @NotNull
    private BigDecimal cost;

    public OrderList() {}

    public OrderList(Integer id, Integer goodId, BigDecimal priceOrder, Integer number, BigDecimal cost) {
        super(id);
        this.goodId = goodId;
        this.priceOrder = priceOrder;
        this.number = number;
        this.cost = cost;
    }

    public OrderList(Integer goodId, BigDecimal priceOrder, Integer number, BigDecimal cost) {
        this(null, goodId, priceOrder, number, cost);
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public BigDecimal getPriceOrder() {
        return priceOrder;
    }

    public void setPriceOrder(BigDecimal priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "goodId=" + goodId +
                ", priceOrder=" + priceOrder +
                ", number=" + number +
                ", cost=" + cost +
                '}';
    }
}
