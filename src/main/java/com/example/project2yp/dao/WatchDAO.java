package com.example.project2yp.dao;


import com.example.project2yp.models.WatchModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WatchDAO implements CRUD<WatchModel> {

    private static int WATCH_COUNT;

    private List<WatchModel> watches;

    {
        watches = new ArrayList<>();

        watches.add(new WatchModel(++WATCH_COUNT, "X5 PRO", "Hamilton", 5600.00));

    }


    @Override
    public List<WatchModel> index() {
        return watches;
    }

    @Override
    public WatchModel show(int id) {
        return watches.stream().filter(w -> w.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(WatchModel w) {
        w.setId(++WATCH_COUNT);
        watches.add(w);
    }

    @Override
    public void update(int id, WatchModel w) {
        WatchModel upd = show(id);
        upd.setName(w.getName());
        upd.setCost(w.getCost());
        upd.setMaker(w.getMaker());
    }

    @Override
    public void delete(int id) {
        watches.removeIf(w -> w.getId() == id);
    }
}
