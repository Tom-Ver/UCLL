package be.ucll.electroman;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import be.ucll.electroman.database.LogInViewModel;
import be.ucll.electroman.entities.UserWithWorkorders;


public class LogInActivity extends AppCompatActivity {

    /*
    * Author:   Vervaeren Tom
    * Title:    Electroman - Java Mobile Assignment
    * Date:     15/04/2022
    * Lecturer: Serneels Koen
    * TESTUSER:
    *   Username: testuser
    *   Password: testpassword
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //OnCreate + SetContentView
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        LogInViewModel logInViewModel= new ViewModelProvider(this).get(LogInViewModel.class);

        //Set Variables
        Button btnGo = findViewById(R.id.btn_loginGo);
        EditText userName = findViewById(R.id.txt_loginUserName);
        EditText passWord = findViewById(R.id.txt_loginPassword);
        TextView errorText = findViewById(R.id.txt_loginError);

        //TextChangeListeners
        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            logInViewModel.setUserName(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        passWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            logInViewModel.setPassWord(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //Button onClick
        btnGo.setOnClickListener(view -> {
            String userNameString = userName.getText().toString();
            String passWordString = passWord.getText().toString();
            try {
                UserWithWorkorders userWithWorkorders = logInViewModel.getUserWithWorkOrders(userNameString);
                if(userWithWorkorders.user.password.equals(passWordString)){
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra("userWorkorder", userWithWorkorders);
                    startActivity(intent);
                }
                else {
                    errorText.setEnabled(true);
                    errorText.setText("Warning: username or password incorrect");}
            }
            //CATCH IN CASE USER = NULL / EXCEPTION E: RECOVER FROM EVERY EXECEPTION
            catch (Exception e){
                Log.e("Error", e + " Username incorrect");
                errorText.setEnabled(true);
                errorText.setText("Warning: username or password incorrect");
        }


        });




    }
}