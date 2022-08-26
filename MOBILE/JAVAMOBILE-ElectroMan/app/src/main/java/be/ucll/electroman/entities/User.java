package be.ucll.electroman.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    //VARIABLES
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    public String firstName;
    @NonNull
    public String lastName;
    @NonNull
    public String userName;
    @NonNull
    public String password;

    public User(){}

    //CONSTRUCTOR ONLY FOR TEST PURPOSES (THE USER CREATED IN THIS ASSIGNMENT) SEE ElectroManDatabase.CLASS.fillDbWithTestData()
    @Ignore
    public User(int id, @NonNull String firstName, @NonNull String lastName, @NonNull String userName, @NonNull String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    //GETTERS & SETTERS
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @NonNull
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }
    @NonNull
    public String getLastName() {
        return lastName;
    }
    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }
    @NonNull
    public String getUserName() {
        return userName;
    }
    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }
    @NonNull
    public String getPassword() {
        return password;
    }
    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
