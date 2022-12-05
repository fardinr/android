package com.example.sharedpreferences_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcome extends AppCompatActivity {

    SharedPreferences prf;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        TextView result = findViewById(R.id.resultView);
        Button btnLogOut = findViewById(R.id.btnLogOut);
        prf = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(welcome.this,MainActivity.class); result.setText("Hello, "+prf.getString("username",null));

        btnLogOut.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { SharedPreferences.Editor editor = prf.edit(); editor.clear();
            editor.apply(); startActivity(intent);
        }
        });

    }
}