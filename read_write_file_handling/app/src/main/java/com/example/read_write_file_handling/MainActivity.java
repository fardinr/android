package com.example.read_write_file_handling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3;
    EditText e1,e2; TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText) findViewById(R.id.editText);
        e2=(EditText) findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button) ;
        b2=(Button) findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        t1=(TextView) findViewById(R.id.textView3) ;

        b1.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            String filename = e1.getText().toString()+".txt";
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
                String line;
                StringBuffer text = new StringBuffer();
                while ((line = bufferedReader.readLine()) != null) { t1.setText((text.append(line + "\n")));
                }
            } catch(IOException e){ e.printStackTrace();
            }
        }
        });
        b2.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            String filename = e1.getText().toString()+".txt";
            String str = e2.getText().toString();
            try {
                FileOutputStream fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                fileOutputStream.write(str.getBytes()); e2.setText("");
                fileOutputStream.close();
//                Toast.makeText(getApplicationContext(),"Successful", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),fileOutputStream.getFD().toString(), Toast.LENGTH_SHORT).show();
            } catch (Exception e){ e.printStackTrace();
            }
        }
        });
        b3.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {
            String filename = e1.getText().toString()+".txt"; try {
                File dir = getFilesDir();
                File file = new File(dir, filename); boolean deleted = file.delete();
                t1.setText("");
            }
            catch (Exception e){ e.printStackTrace();
            }
        }
        });

    }
}