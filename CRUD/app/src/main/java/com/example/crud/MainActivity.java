package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity; import android.app.AlertDialog;
import android.database.Cursor; import android.os.Bundle; import android.view.View; import android.widget.Button; import android.widget.EditText; import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name,marks;
    Button insertbtn,displaybtn,searchbtn,deletebtn,updatebtn;
    DatabaseHelper mydb;	//object of the class
    String sname; int smarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHelper mydb= new DatabaseHelper(this);
        mydb.getWritableDatabase();//database created and table created

        name = findViewById(R.id.name); marks =findViewById(R.id.marks);
        insertbtn= findViewById(R.id.insert);
        displaybtn= findViewById(R.id.display);
        searchbtn= findViewById(R.id.search);
        deletebtn= findViewById(R.id.delete);
        updatebtn= findViewById(R.id.update);
//insert data
        insertbtn.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { sname= name.getText().toString();
            smarks= Integer.parseInt(marks.getText().toString()); boolean b = mydb.InsertData(sname,smarks);
            if(b)
                Toast.makeText(getApplicationContext(),"Data Inserted Successfully",Toast.LENGTH_SHORT).show();
        }
        });

        //display on alert dialog box
        displaybtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//contain result set of query,
Cursor ds= mydb.ShowData(); if(ds.getCount()==0)
            Toast.makeText(getApplicationContext(),"Table is Empty",Toast.LENGTH_SHORT).show();
else{
                StringBuffer buffer= new StringBuffer();
//move the cursor next row
while (ds.moveToNext()) {
                int sid = ds.getInt(ds.getColumnIndex(DatabaseHelper.Col_1)); String username = ds.getString(1);
                String marks = ds.getString(2);
                buffer.append("Id==+"+sid+ " " +"Name==" +username+ " " + "Marks=="+marks +" \n");
            }
//display dialog mesg
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);



            builder.setTitle("Student Data"); builder.setMessage(buffer.toString()); builder.show();
        }
    }
});

        //search by name
        searchbtn.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { sname= name.getText().toString();
//search according to name
            Cursor searchresult = mydb.SearchData(sname); if(searchresult.getCount()==0)
                Toast.makeText(getApplicationContext(),"No Data found!",Toast.LENGTH_SHORT).show();
            else{
                while (searchresult.moveToNext()){
                    String username = searchresult.getString(1); String marks = searchresult.getString(2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); builder.setMessage("Data="+username + " " + marks); builder.setTitle("Student Data");
                    builder.show();
                }
            }

        }
        });
//Delete Data
        deletebtn.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { sname= name.getText().toString(); boolean b = mydb.DeleteData(sname); if(b)
            Toast.makeText(getApplicationContext(),"Data Deleted", Toast.LENGTH_SHORT).show();

        }
        });
//Update data
        updatebtn.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {

            sname= name.getText().toString(); smarks=Integer.parseInt(marks.getText().toString()); boolean b = mydb.UpdateData(sname,smarks);
            if(b)
                Toast.makeText(getApplicationContext(),"Data Updated", Toast.LENGTH_SHORT).show();


        }
        });



    }
}