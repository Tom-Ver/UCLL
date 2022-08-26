package be.ucll.electroman.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import be.ucll.electroman.entities.User;
import be.ucll.electroman.entities.UserWithWorkorders;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user where userName = :username")
    @Transaction
    UserWithWorkorders getUserWithWorkorders(String username);

}
