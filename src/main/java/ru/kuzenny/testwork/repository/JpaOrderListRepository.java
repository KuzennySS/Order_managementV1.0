package ru.kuzenny.testwork.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kuzenny.testwork.model.OrderList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaOrderListRepository implements OrderListRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public OrderList save(OrderList orderList) {
        if (orderList.isNew()) {
            em.persist(orderList);
            return orderList;
        } else {
            return em.merge(orderList);
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
         em.remove(get(id));
/*        return em.createNamedQuery("OrderList.delete", OrderList.class)
                .setParameter("id", id)
                .executeUpdate() != 0;*/
    }

    @Override
    public OrderList get(int id) {
        return em.find(OrderList.class, id);
    }

    @Override
    public List<OrderList> getAll() {
        return em.createNamedQuery("OrderList.findAll", OrderList.class).getResultList();
    }
}
