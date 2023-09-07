package com.example.project2yp.models;

public class WatchModel {

    private int _id;

    private String _name;

    private String _maker;

    private double _cost;

    public WatchModel(){}

    public WatchModel(int id, String name, String maker, double cost) {
        _id = id;
        _name = name;
        _maker = maker;
        _cost = cost;
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

    public String getMaker() {
        return _maker;
    }

    public void setMaker(String maker) {
        this._maker = maker;
    }

    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        this._cost = cost;
    }
}
