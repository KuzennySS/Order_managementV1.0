package ru.kuzenny.testwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

//@SuppressWarnings("JpaQlInspection")
@NamedQueries(@NamedQuery(name = "Goods.findAll", query = "SELECT g FROM Goods g"))
@Entity
@Table(name = "goods", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "price_goods"}, name = "goods_unique_idx")})
public class Goods extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;

    @Column(name = "price_goods", nullable = false)
    @NotNull
    private BigDecimal priceGoods;

    public String getName() {
        return name;
    }

    public void setName() {
        this.name =  name;
    }

    public BigDecimal getPriceGoods() {
        return priceGoods;
    }

    public void setPriceGoods(BigDecimal priceGoods) {
        this.priceGoods = priceGoods;
    }

    public Goods() {}

    public Goods(String name, BigDecimal priceGoods) {
        this(null, name, priceGoods);
    }

    public Goods(Integer id, String name, BigDecimal priceGoods) {
        super(id);
        this.name = name;
        this.priceGoods = priceGoods;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", priceGoods=" + priceGoods +
                ", id=" + id +
                '}';
    }
}
