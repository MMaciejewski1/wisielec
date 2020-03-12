package com.example.myapplication1;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RowDataModel extends RealmObject implements Serializable {
    @PrimaryKey
    int id;
    String name;


    private static int m_Counter = 0;
    public RowDataModel(){
        this.id = m_Counter++;
        this.name = "elo";
    }
    public RowDataModel(String name){
        this.id = m_Counter++;
        this.name = name;
    }
    }