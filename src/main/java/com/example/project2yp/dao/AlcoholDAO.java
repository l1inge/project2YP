package com.example.project2yp.dao;

import com.example.project2yp.models.AlcoholModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AlcoholDAO implements CRUD<AlcoholModel> {
    private static int ALCOHOL_COUNT;

    private List<AlcoholModel> drinks;

    {
        drinks = new ArrayList<>();

        drinks.add(new AlcoholModel(++ALCOHOL_COUNT, "Жигули", 66.0, 6));

    }


    @Override
    public List<AlcoholModel> index() {
        return drinks;
    }

    @Override
    public AlcoholModel show(int id) {
        return drinks.stream().filter(d -> d.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(AlcoholModel alcoholModel) {
        alcoholModel.setId(++ALCOHOL_COUNT);
        drinks.add(alcoholModel);
    }

    @Override
    public void update(int id, AlcoholModel alc) {
        AlcoholModel updateAlc = show(id);
        updateAlc.setCost(alc.getCost());
        updateAlc.setName(alc.getName());
        updateAlc.setPercent(alc.getPercent());
    }

    @Override
    public void delete(int id) {
        drinks.removeIf(d -> d.getId() == id);
    }
}
