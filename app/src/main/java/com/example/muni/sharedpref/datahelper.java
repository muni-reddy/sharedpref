package com.example.muni.sharedpref;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by muni on 30/05/17.
 */

public class datahelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data.db";
    private static final int DATABASE_VERSION = 2;

    public datahelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_Datatable = "CREATE TABLE " + data.saveddata.Table_name +"(" +
                data.saveddata._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                data.saveddata.Name +" INTEGER NOT NULL, " +
                data.saveddata.Phone +" INTEGER NOT NULL, " +
                data.saveddata.Email +" INTEGER NOT NULL, " +
                data.saveddata.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP "+
                " );";
        db.execSQL(CREATE_Datatable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
