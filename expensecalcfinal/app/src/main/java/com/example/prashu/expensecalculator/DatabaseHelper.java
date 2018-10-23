package com.example.prashu.expensecalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.net.PortUnreachableException;

/**
 * Created by Prashu on 29-07-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "database.db";

    public static final String TABLE_NAME= "tbl_expenses";
    public static final String col1 = "ID";
    public static final String col2 = "amount";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+col1+" integer PRIMARY KEY AUTOINCREMENT ," +
            col2 + "INTEGER);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME+";";
    public static Context context;

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME, null,DATABASE_VERSION  );
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

   try {
       sqLiteDatabase.execSQL(CREATE_TABLE);

   }catch (SQLException e){
       Log.i("prashu","error");
   }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (SQLException e){
        }


    }
}
