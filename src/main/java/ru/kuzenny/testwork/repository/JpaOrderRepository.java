package ru.kuzenny.testwork.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kuzenny.testwork.model.AbstractBaseEntity;
import ru.kuzenny.testwork.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Order save(Order order) {
        if (order.isNew()) {
            em.persist(order);
            return order;
        } else {
            return em.merge(order);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        em.remove(get(id));
    }

    @Override
    @Transactional
    public void deleteByNumberOrder(int numberOrder) {
        List<Order> orderList = getByNumberOrder(numberOrder);
        orderList.stream()
                .map(AbstractBaseEntity::getId)
                .forEach(id -> em.remove(get(id)));
    }

    @Override
    public Order get(int id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> getByNumberOrder(int numdeberOrder) {
        return em.createNamedQuery("Order.findByNumderOrder", Order.class)
                .setParameter(1, numdeberOrder)
                .getResultList();
    }

    @Override
    public List getAll() {
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    @Override
    public List<Order> getOrdersByNumberOrder(int numdeberOrder){
        return em.createQuery("SELECT o FROM Order o WHERE o.numberOrder = ?1",Order.class)
                .setParameter(1, numdeberOrder)
                .getResultList();
    }

    @Override
    public Order getOrderByOrderList(Integer orderListId){
        return em.createQuery("SELECT o FROM Order o WHERE o.orderList.id = ?1", Order.class)
                .setParameter(1, orderListId)
                .getSingleResult();
    }

}
