package be.ucll.electroman.database;

import android.app.Application;

import be.ucll.electroman.dao.UserDao;
import be.ucll.electroman.dao.WorkorderDao;
import be.ucll.electroman.entities.User;
import be.ucll.electroman.entities.UserWithWorkorders;
import be.ucll.electroman.entities.Workorder;

class Repository {

    private UserDao userDao;
    private WorkorderDao workorderDao;





    public Repository(Application application) {
        ElectroManDatabase db = ElectroManDatabase.getDatabase(application);
        workorderDao = db.workorderDao();
        userDao = db.userDao();
    }

    public UserWithWorkorders getUserWithWorkorders(String username) {return userDao.getUserWithWorkorders(username);}


    void insertUser(User user) {
        ElectroManDatabase.databaseWriteExecutor.execute(() -> userDao.insertUser(user));
    }

    void updateWorkorder(Workorder workorder) {
        ElectroManDatabase.databaseWriteExecutor.execute(() -> workorderDao.updateWorkorder(workorder));
    }

    void insertWorkorder(User user, Workorder workorder) {
        ElectroManDatabase.databaseWriteExecutor.execute(() -> {
            workorder.setUserId(user.getId());
            workorderDao.inserWorkorders(workorder);
        });
    }

}
