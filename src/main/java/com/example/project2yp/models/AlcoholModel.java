package com.example.project2yp.models;

public class AlcoholModel {

    private int _id;

    private String _name;

    private double _cost;

    private int _percent;


    public AlcoholModel() {
    }

    public AlcoholModel(int id, String name, double cost, int percent) {
        _id = id;
        _name = name;
        _cost = cost;
        _percent = percent;
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

    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        this._cost = cost;
    }

    public int getPercent() {
        return _percent;
    }

    public void setPercent(int percent) {
        this._percent = percent;
    }
}
