package com.example.estia.medicalapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.estia.medicalapp.util.SQLConnection;
import com.example.estia.medicalapp.util.SQLHelper;

import java.util.ArrayList;


public class ThermoDAO extends SQLConnection{

    private static final String WHERE_ID_EQUALS =  "id =?";

    public ThermoDAO(Context context) {
        super(context);
    }

    public long save(Thermo thermo) {
        ContentValues values = new ContentValues();
        values.put("value", thermo.getValue());

        return database.insert(SQLHelper.THERMO_TABLE, null, values);
    }

    public ArrayList<Thermo> getThermos(){
        ArrayList<Thermo> thermos = new ArrayList<>();
        String query = "SELECT * FROM "
                + SQLHelper.THERMO_TABLE;

        Cursor cursor = database.rawQuery(query, null);
        while (cursor.moveToNext()){
            Thermo thermo = new Thermo();
            thermo.setId(cursor.getInt(0));
            thermo.setValue(cursor.getInt(1));

            thermos.add(thermo);
        }

        return thermos;
    }


}
