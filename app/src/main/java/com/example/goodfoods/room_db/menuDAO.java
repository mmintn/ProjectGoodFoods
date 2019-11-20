package com.example.goodfoods.room_db;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface menuDAO {

    @Query("SELECT * FROM menu")
    List<menu> getAll();

    @Insert
    void insert(menu menu);


    @Query("DELETE FROM menu")
    void deleteAll();
}
