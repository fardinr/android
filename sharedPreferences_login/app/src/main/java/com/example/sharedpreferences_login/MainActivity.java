package com.example.sharedpreferences_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname, pwd;
    Button loginBtn,clrBtn;
    CheckBox rememberMe;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = findViewById(R.id.usernameEditText);
        pwd = findViewById(R.id.passwordEditText);
        loginBtn = findViewById(R.id.loginButton);
        clrBtn = findViewById(R.id.clearButton);
        rememberMe = findViewById(R.id.remembermeCheckBox);
        pref = getSharedPreferences("user_details", MODE_PRIVATE);

        Intent intent = new Intent(MainActivity.this, welcome.class);
        if (isAlreadyLogedIn()) {
            String email_pref = pref.getString("username", "");
            String pswd_pref = pref.getString("pswd", "");
            uname.setText(email_pref);
            pwd.setText(pswd_pref);

        }
        loginBtn.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            String username = uname.getText().toString();

            String password = pwd.getText().toString();
            if(username.equals("admin") && password.equals("admin")){
//To Store Data
        if(rememberMe.isChecked()) {

                pref.edit().putString("username", username).apply(); pref.edit().putString("pswd", password).apply();
            }

            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        else
            {
                Toast.makeText(getApplicationContext(),"Credentials	are	not valid",Toast.LENGTH_SHORT).show();
            }
        }
    });

        clrBtn.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { pref.edit().clear().apply(); uname.setText("");
            pwd.setText("");
        }
        });
    }

    private boolean isAlreadyLogedIn() {
        return pref.contains("username") && pref.contains("password");

    }
}