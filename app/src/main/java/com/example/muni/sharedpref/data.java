package com.example.muni.sharedpref;

import android.provider.BaseColumns;

/**
 * Created by muni on 30/05/17.
 */

public class data {
    public static class saveddata implements BaseColumns{
        public static final String Table_name = "entry";
        public static final String Name = "name";
        public static final String Phone = "phone";
        public static final String Email = "email";
        public static final String COLUMN_TIMESTAMP = "timestamp";

    }
}
