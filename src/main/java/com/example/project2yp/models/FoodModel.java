package com.example.project2yp.models;

public class FoodModel {

    private int _id;

    private String _name;

    private String _type;

    private double _cost;

    public FoodModel() {
    }

    public FoodModel(int id, String name, String type, double cost) {
        _id = id;
        _name = name;
        _type = type;
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

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        this._type = type;
    }

    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        this._cost = cost;
    }
}
