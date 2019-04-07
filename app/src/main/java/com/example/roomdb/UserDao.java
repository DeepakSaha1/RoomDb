package com.example.roomdb;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_details")
    LiveData<List<UserModel>> getAllUsers();

    @Insert
    void insertUser(UserModel userModel);

    @Query("DELETE FROM user_details")
    void deleteAllUsers();
}
