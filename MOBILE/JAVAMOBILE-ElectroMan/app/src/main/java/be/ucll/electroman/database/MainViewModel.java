package be.ucll.electroman.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import be.ucll.electroman.entities.User;
import be.ucll.electroman.entities.UserWithWorkorders;
import be.ucll.electroman.entities.Workorder;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;



    public MainViewModel(Application application){
        super(application);
        repository = new Repository(application);
    }

    public UserWithWorkorders getUserWithWorkorders(String username) {return repository.getUserWithWorkorders(username);}
    public void insertUser(User user) {repository.insertUser(user);}
    public void updateWorkorder(Workorder workorder) {repository.updateWorkorder(workorder);}
    public void insertWorkorder(User user, Workorder workorder) {repository.insertWorkorder(user, workorder);}
}
