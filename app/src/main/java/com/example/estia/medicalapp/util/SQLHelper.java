package com.example.estia.medicalapp.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    //MARK: Properties
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Medical";

    public static final String THERMO_TABLE = "thermo";


    public static final String CREATE_GYM = "CREATE TABLE " + THERMO_TABLE + " " +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "value INT)";

    //MARK: Contructores
    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static SQLHelper instance;

    public static synchronized SQLHelper getHelper(Context context) {
        if (instance == null)
            instance = new SQLHelper(context);
        return instance;
    }

    //MARK: Override SQLiteOpenHelper Methods
    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL(CREATE_GYM);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}