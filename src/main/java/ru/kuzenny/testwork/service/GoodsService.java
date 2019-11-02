package ru.kuzenny.testwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuzenny.testwork.model.Goods;
import ru.kuzenny.testwork.repository.GoodsRepository;

import java.util.List;

@Service
public class GoodsService {

    private final GoodsRepository repository;

    @Autowired
    public GoodsService(GoodsRepository repository) {
        this.repository = repository;
    }

    public Goods get(int id) { return repository.get(id); }

    public List<Goods> getAll() { return repository.getAll(); }
}
