package com.example.project2yp.dao;


import com.example.project2yp.models.FilmModel;
import com.example.project2yp.models.PillsModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PillsDAO implements CRUD<PillsModel> {


    private static int PILLS_COUNT;

    private List<PillsModel> pills;

    {
        pills = new ArrayList<>();

        pills.add(new PillsModel(++PILLS_COUNT, "Но-шпа", "дротаверина гидрохлорид — 40 мг", 6));
    }

    @Override
    public List<PillsModel> index() {
        return pills;
    }

    @Override
    public PillsModel show(int id) {
        return pills.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(PillsModel pill) {
        pill.setId(++PILLS_COUNT);
        pills.add(pill);
    }

    @Override
    public void update(int id, PillsModel pill) {
        PillsModel upd = show(id);
        upd.setName(pill.getName());
        upd.setStructure(pill.getStructure());
        upd.setMinage(pill.getMinage());
    }

    @Override
    public void delete(int id) {
        pills.removeIf(p -> p.getId() == id);
    }
}
