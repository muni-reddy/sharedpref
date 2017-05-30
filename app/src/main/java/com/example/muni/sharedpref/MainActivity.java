package com.example.muni.sharedpref;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;
    String name,email,pass,highScore;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    private SQLiteDatabase mDb;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText) findViewById(R.id.edit);
        ed2 = (EditText) findViewById(R.id.edit2);
        ed3 = (EditText) findViewById(R.id.edit3);
        b1 = (Button) findViewById(R.id.button);

        datahelper dbHelper = new datahelper(this);
        mDb = dbHelper.getWritableDatabase();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ed1.getText().toString();
                pass = ed2.getText().toString();
                email = ed3.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, name);
                editor.putString(Phone, pass);
                editor.putString(Email, email);
                editor.commit();
                SQLiteDatabase mDb;
                final datahelper dbHelper = new datahelper(MainActivity.this);
                mDb = dbHelper.getWritableDatabase();
                saverecords(name, pass, email);

            }
        });
    }
    public long saverecords(String pname, String pphone,String pemail){
        ContentValues regdata = new ContentValues();
        regdata.put(data.saveddata.Name,pname);
        regdata.put(data.saveddata.Phone,pphone);
        regdata.put(data.saveddata.Email,pemail);
        long l =  mDb.insert(data.saveddata.Table_name, null, regdata);
        getrecords();
        return l;

    }
    public void getrecords(){
        String selectquery ="SELECT * FROM "+data.saveddata.Table_name+";";
        Cursor cursor =mDb.rawQuery(selectquery,null) ;
        int count = cursor.getCount();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(data.saveddata.Name));
            Toast.makeText(getApplicationContext(), "my name is" + name + "count is" +count,
                    Toast.LENGTH_SHORT).show();
        }
        cursor.close();

    }
}
