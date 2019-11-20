package com.example.goodfoods.room_db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



@Entity(tableName = "menu")
public class menu {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "amount")
    public int amount;


    public menu(int id, String name, int amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }
}
