package com.example.read_write_external_file_handling;

import static java.lang.System.in;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1; TextView t1;
    private String filename = "SampleFile.txt"; private String filepath = "MyFileStorage";

    File myExternalFile; String myData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editText);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        t1 = findViewById(R.id.textView2);
//on click of Read button

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
// Read the data that is saved in byte format in the file
                    FileInputStream fis = new
                            FileInputStream(myExternalFile);
                    DataInputStream in = new DataInputStream(fis);
                    BufferedReader br = new BufferedReader(new
                            InputStreamReader(in));
                    String strLine;
                    while ((strLine = br.readLine()) != null) {
                        myData = myData + strLine;
                    }
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                e1.setText(myData);
                t1.setText("SampleFile.txt data retrieved from Storage...");
            }
        });

    }
    private static boolean isExternalStorageReadOnly() {
        String extrernalstorage = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extrernalstorage)){ return true;
        }
        return false;
    }
    private static boolean isExternalStorageAvailable(){
        String extStorageState = Environment.getExternalStorageState(); if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;


    }
}