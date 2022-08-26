package be.ucll.electroman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import be.ucll.electroman.database.UpdateDataViewModel;
import be.ucll.electroman.entities.User;
import be.ucll.electroman.entities.Workorder;

public class UpdateDataActivity extends AppCompatActivity {

    EditText txt_detailedProblem, txt_repairInfo;
    Workorder workorder;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);
        UpdateDataViewModel updateDataViewModel = new ViewModelProvider(this).get(UpdateDataViewModel.class);

        txt_detailedProblem = findViewById(R.id.txt_detailedProblemDescription);
        txt_repairInfo = findViewById(R.id.txt_repairInfo);
        Button btn_back = findViewById(R.id.btn_back);
        Button btn_save = findViewById(R.id.btn_save);

        if(getIntent() != null){
            workorder = (Workorder) getIntent().getSerializableExtra("workorder");
            user = (User) getIntent().getSerializableExtra("user");
            txt_detailedProblem.setText(workorder.getDetailedProblemDescription());
            txt_repairInfo.setText(workorder.getRepairInformation());
            if (!workorder.getProcessed()){
                txt_detailedProblem.setEnabled(false);
                txt_repairInfo.setEnabled(false);
                btn_save.setVisibility(View.INVISIBLE);
            }else{
                txt_detailedProblem.setEnabled(true);
                txt_repairInfo.setEnabled(true);
                btn_save.setVisibility(View.VISIBLE);
            }
        }


        btn_back.setOnClickListener(view -> backToMain());

        btn_save.setOnClickListener(view -> {
            workorder.setDetailedProblemDescription(txt_detailedProblem.getText().toString());
            workorder.setRepairInformation(txt_repairInfo.getText().toString());
            updateDataViewModel.updateWorkorder(workorder);
            backToMain();
        });
    }

    public void backToMain()
    {
        Intent intent = new Intent(this, MainActivity.class).putExtra("user", user);
        startActivity(intent);
    }

}