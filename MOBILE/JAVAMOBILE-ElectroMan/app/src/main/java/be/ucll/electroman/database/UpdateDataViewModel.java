package be.ucll.electroman.database;

import android.app.Application;


import androidx.lifecycle.AndroidViewModel;

import be.ucll.electroman.entities.Workorder;

public class UpdateDataViewModel extends AndroidViewModel {

    private Repository repository;

    public UpdateDataViewModel(Application application) {
        super(application);
        repository = new Repository(application);
    }

    public void updateWorkorder(Workorder workorder){
        repository.updateWorkorder(workorder);
    }
}
