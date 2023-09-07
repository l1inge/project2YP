package com.example.project2yp.models;

public class PillsModel {

    private int _id;

    private String _name;

    private String _structure;

    private int _minage;

    public PillsModel(){}

    public PillsModel(int id, String name, String structure, int minage) {
        _id = id;
        _name = name;
        _structure = structure;
        _minage = minage;
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

    public String getStructure() {
        return _structure;
    }

    public void setStructure(String structure) {
        this._structure = structure;
    }

    public int getMinage() {
        return _minage;
    }

    public void setMinage(int minage) {
        this._minage = minage;
    }
}
