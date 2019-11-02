package ru.kuzenny.testwork.dto;

import java.math.BigDecimal;

public class OrderListDto {

    private Integer goodsId;

    private String nameGoods;

    private BigDecimal priceOrder;

    private Integer number;

    private BigDecimal cost;

    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
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

    public OrderListDto() {
    }

    public OrderListDto(Integer goodsId, String nameGoods, BigDecimal priceOrder, Integer number, BigDecimal cost, Integer orderId) {
        this.goodsId = goodsId;
        this.nameGoods = nameGoods;
        this.priceOrder = priceOrder;
        this.number = number;
        this.cost = cost;
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderListDto{" +
                "goodsId=" + goodsId +
                ", nameGoods='" + nameGoods + '\'' +
                ", priceOrder=" + priceOrder +
                ", number=" + number +
                ", cost=" + cost +
                ", orderId=" + orderId +
                '}';
    }
}
