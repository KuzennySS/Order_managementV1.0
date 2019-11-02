package ru.kuzenny.testwork.repository;

import ru.kuzenny.testwork.model.Goods;

import java.util.List;

public interface GoodsRepository {

    Goods get(Integer id);

    List<Goods> getAll();

}
