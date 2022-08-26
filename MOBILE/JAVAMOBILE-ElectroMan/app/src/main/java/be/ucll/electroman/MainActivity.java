package be.ucll.electroman;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import be.ucll.electroman.adapters.UserWithWorkordersAdapter;
import be.ucll.electroman.database.MainViewModel;
import be.ucll.electroman.entities.User;
import be.ucll.electroman.entities.UserWithWorkorders;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    UserWithWorkordersAdapter userWithWorkorderAdapter;
    private MainViewModel mainViewModel;
    UserWithWorkorders userWithWorkorders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Intent i = getIntent();

        if (i.getSerializableExtra("userWorkorder") != null){
        userWithWorkorders= (UserWithWorkorders) i.getSerializableExtra("userWorkorder"); }

        if (i.getSerializableExtra("user")!= null) {
            User user = (User) i.getSerializableExtra("user");
            userWithWorkorders = mainViewModel.getUserWithWorkorders(user.userName);
        }

        TextView text = findViewById(R.id.txt_Main_FullUserName);
        text.setEnabled(true);
        text.setText("Welcome: " + userWithWorkorders.user.firstName + ", " + userWithWorkorders.user.lastName);


        recycler_view = findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        userWithWorkorderAdapter = new UserWithWorkordersAdapter(this);
        recycler_view.setAdapter(userWithWorkorderAdapter);
        setRecycler_view(userWithWorkorders);


    }

    public void setRecycler_view(UserWithWorkorders userWithWorkorders) {
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        userWithWorkorderAdapter = new UserWithWorkordersAdapter(this, userWithWorkorders);
        recycler_view.setAdapter(userWithWorkorderAdapter);


    }

}