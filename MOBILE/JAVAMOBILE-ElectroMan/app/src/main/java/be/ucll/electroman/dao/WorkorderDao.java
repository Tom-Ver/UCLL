package be.ucll.electroman.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import be.ucll.electroman.entities.Workorder;

@Dao
public interface WorkorderDao {

    @Insert
    void inserWorkorders (Workorder... workorders);

    @Query("DELETE FROM workorder")
    void deleteWorkorders();

    @Update
    void updateWorkorder(Workorder workorder);

}
