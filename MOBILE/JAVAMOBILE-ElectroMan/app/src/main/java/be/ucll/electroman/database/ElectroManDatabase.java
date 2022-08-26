package be.ucll.electroman.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import be.ucll.electroman.dao.UserDao;
import be.ucll.electroman.dao.WorkorderDao;
import be.ucll.electroman.entities.User;
import be.ucll.electroman.entities.Workorder;

@Database(entities = {User.class, Workorder.class}, version = 1, exportSchema = false)
public abstract class ElectroManDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract WorkorderDao workorderDao();

    //Singleton
    private static volatile ElectroManDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ElectroManDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (ElectroManDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ElectroManDatabase.class, "electroman_database")
                            .allowMainThreadQueries()
                            .build();
                    ElectroManDatabase.databaseWriteExecutor.execute(() -> INSTANCE.clearAllTables());
                    fillDbWithTestData();
                }
            }
        }
        return INSTANCE;
    }

    static void fillDbWithTestData() {
        databaseWriteExecutor.execute(() -> {
            UserDao userDao = INSTANCE.userDao();
            WorkorderDao workorderDao = INSTANCE.workorderDao();

            User user = new User(1,"Test", "Admin", "testuser", "testpassword");
            userDao.insertUser(user);
            Workorder workorder1 = new Workorder(1,"Leuven", "Wasmachine", "F004", "Jans",
                    false, "Engine Failure","");
            workorderDao.inserWorkorders(workorder1);
            Workorder workorder2 = new Workorder(1,"Brussel", "Droogkast", "AZ008", "Theunis",
                    false, "Power problem","");
            workorderDao.inserWorkorders(workorder2);
            Workorder workorder3 = new Workorder(1,"Aarschot", "Microgolf", "Z0785", "Lovens",
                    true, "Mica defect","Nieuw micaplaat besteld");
            workorderDao.inserWorkorders(workorder3);
            Workorder workorder4 = new Workorder(1,"Brugge", "Wasmachine", "F074", "Bustyns",
                    false, "Overweight","");
            workorderDao.inserWorkorders(workorder4);
            Workorder workorder5 = new Workorder(1,"Landen", "Vaatwas", "QT89", "Caspers",
                    false ,"Waterpump failure","");
            workorderDao.inserWorkorders(workorder5);
            
        });
    }
}
