package be.ucll.electroman.entities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

public class UserWithWorkorders implements Serializable {

    @Embedded
    public User user;
    @Relation(parentColumn = "id", entityColumn = "userId")
    public List<Workorder> workorders;



}
