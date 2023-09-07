package com.example.project2yp.dao;


import com.example.project2yp.models.FilmModel;
import com.example.project2yp.models.FoodModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FoodDAO implements CRUD<FoodModel> {

    private static int FOOD_COUNT;

    private List<FoodModel> foods;

    {
        foods = new ArrayList<>();

        foods.add(new FoodModel(++FOOD_COUNT, "Бургер", "Фастфуд", 12));

    }


    @Override
    public List<FoodModel> index() {
        return foods;
    }

    @Override
    public FoodModel show(int id) {
        return foods.stream().filter(f -> f.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(FoodModel fod) {
        fod.setId(++FOOD_COUNT);
        foods.add(fod);
    }

    @Override
    public void update(int id, FoodModel f) {
        FoodModel upd = show(id);
        upd.setName(f.getName());
        upd.setCost(f.getCost());
        upd.setType(f.getType());
    }

    @Override
    public void delete(int id) {
        foods.removeIf(f -> f.getId() == id);
    }
}
