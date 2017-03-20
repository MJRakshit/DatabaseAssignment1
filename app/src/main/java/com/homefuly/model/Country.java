package com.homefuly.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by MONOJIT on 3/20/2017.
 */

public class Country extends SQLiteOpenHelper{
    public static final String DATABASENAME="Country.db";
    public static final String TABLENAME="country";
    public static final String COL1="COUNTRY_NAME";
    SQLiteDatabase db;
    public Country(Context context) {
        super(context, DATABASENAME,null,1);
       SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL("create table country(COUNTRY_NAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
   public void InsertData(String country_name) {
       SQLiteDatabase db = getWritableDatabase();
       ContentValues contentval = new ContentValues();
       contentval.put(COL1, country_name);
       long result = db.insert(TABLENAME, null, contentval);
   }
    public String[] GetAllData(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor res = db.rawQuery("select * from country",null);
        if (res.getCount() >0){
            String[] str = new String[res.getCount()];
            int i = 0;

            while (res.moveToNext())
            {
                str[i] = res.getString(res.getColumnIndex(COL1));
                i++;
            }
            return str;
        }
        else
        {
            return new String[] {};
        }
    }
}
