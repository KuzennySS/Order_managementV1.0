package ru.kuzenny.testwork.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kuzenny.testwork.model.Goods;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaGoodsRepository implements GoodsRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Goods get(Integer id) {
        return em.find(Goods.class, id);
    }

    @Override
    public List<Goods> getAll() {
        return em.createNamedQuery("Goods.findAll", Goods.class).getResultList();
    }
}
