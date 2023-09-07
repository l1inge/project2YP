package com.example.project2yp.models;

public class FilmModel {

    private int _id;

    private String _name;

    private int _year;

    private String _genre;

    public FilmModel() {
    }

    public FilmModel(int id, String name, int year, String genre) {
        _id = id;
        _name = name;
        _year = year;
        _genre = genre;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getYear() {
        return _year;
    }

    public void setYear(int year) {
        this._year = year;
    }

    public String getGenre() {
        return _genre;
    }

    public void setGenre(String genre) {
        this._genre = genre;
    }
}
