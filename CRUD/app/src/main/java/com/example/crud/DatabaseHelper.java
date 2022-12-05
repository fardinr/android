package com.example.crud;
import android.content.ContentValues;
import android.content.Context; import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase; import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Stud.db"; public static final String TABLE_NAME = "student"; public static final String Col_1 = "ID";
    public static final String Col_2 = "NAME"; public static final String Col_3 = "MARKS"; String query;

    public DatabaseHelper(@Nullable Context context) { super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //used for db and table creation
         query="CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MARKS INTEGER)";
        db.execSQL(query);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) { db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
    }
    public boolean InsertData(String n, int m){//Creating any method to insert the data
         SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NAME",n);	//Field name of the
         cv.put("MARKS",m);		//Field name of the
         long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1) return false;
        else
            return true;
    }
    public boolean DeleteData(String n){ SQLiteDatabase db = this.getWritableDatabase();
        long res = db.delete(TABLE_NAME,"NAME=?", new String[]{n}); if (res==-1)
            return false; else
            return true;
    }
    public boolean UpdateData(String n, int m){ SQLiteDatabase db = this.getWritableDatabase(); ContentValues cv = new ContentValues(); cv.put(Col_2,n);
        cv.put(Col_3,m);
        long res = db.update(TABLE_NAME,cv,"NAME=?",new String[]{n}); if (res==-1)
            return false; else
            return true;
    }
    public Cursor ShowData(){
        query = "Select * from student";
        SQLiteDatabase db = this.getWritableDatabase(); Cursor res = db.rawQuery(query,null);
        return res;
    }
    public Cursor SearchData(String n){
        query = "Select * from student where NAME = '"+n+"'"; SQLiteDatabase db = this.getWritableDatabase(); Cursor res = db.rawQuery(query,null);
        return res;

    }
}

