package ru.kuzenny.testwork.repository;

import ru.kuzenny.testwork.model.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsRepository {

    Optional<Goods> get(Integer id);

    List<Goods> getAll();

}
