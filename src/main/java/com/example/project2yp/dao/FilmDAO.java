package com.example.project2yp.dao;


import com.example.project2yp.models.AlcoholModel;
import com.example.project2yp.models.FilmModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmDAO implements CRUD<FilmModel> {


    private static int FILM_COUNT;

    private List<FilmModel> films;

    {
        films = new ArrayList<>();

        films.add(new FilmModel(++FILM_COUNT, "Солнцестояние", 2014, "Ужастик"));

    }


    @Override
    public List<FilmModel> index() {
        return films;
    }

    @Override
    public FilmModel show(int id) {
        return films.stream().filter(f -> f.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(FilmModel film) {
        film.setId(++FILM_COUNT);
        films.add(film);
    }

    @Override
    public void update(int id, FilmModel film) {
        FilmModel updFilm = show(id);
        updFilm.setName(film.getName());
        updFilm.setYear(film.getYear());
        updFilm.setGenre(film.getGenre());
    }

    @Override
    public void delete(int id) {
        films.removeIf(f -> f.getId() == id);
    }
}
