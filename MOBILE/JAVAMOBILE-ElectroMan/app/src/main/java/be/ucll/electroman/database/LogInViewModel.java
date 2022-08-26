package be.ucll.electroman.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import be.ucll.electroman.entities.UserWithWorkorders;

public class LogInViewModel extends AndroidViewModel {

    //Variables
    private MutableLiveData<String> userName;
    private MutableLiveData<String> passWord;
    private Repository repository;


    public LogInViewModel(Application application){
        super(application);
        userName = new MutableLiveData<>();
        passWord = new MutableLiveData<>();
        repository = new Repository(application);
    }


    public UserWithWorkorders getUserWithWorkOrders(String username){return repository.getUserWithWorkorders(username);}

    public void setUserName(String s) {
        userName.setValue(s);
    }

    public void setPassWord(String s) {
        passWord.setValue(s);
    }

    //Getters
    public MutableLiveData<String> getUserName() {
        if (userName == null){
            userName = new MutableLiveData<>();
        }
        return userName;
    }

    public MutableLiveData<String> getPassWord() {
        if (passWord == null){
            passWord = new MutableLiveData<>();
        }
        return passWord;
    }
}
