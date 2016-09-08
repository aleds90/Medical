package com.example.estia.medicalapp.util;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class SQLConnection {

    protected SQLiteDatabase database;
    private SQLHelper dbHelper;
    private Context mContext;

    public SQLConnection(Context context) {
        this.mContext = context;
        dbHelper = SQLHelper.getHelper(mContext);
        open();

    }

    public void open() throws SQLException {
        if(dbHelper == null)
            dbHelper = SQLHelper.getHelper(mContext);
        database = dbHelper.getWritableDatabase();
    }

}
