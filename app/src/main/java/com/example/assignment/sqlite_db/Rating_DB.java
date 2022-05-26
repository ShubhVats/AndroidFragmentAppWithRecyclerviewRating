package com.example.assignment.sqlite_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Rating_DB extends SQLiteOpenHelper {
    public Rating_DB(Context context) {
        super(context, "rating_DB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table rating_DB(Rating_Name TEXT primary key, Rating_Rating TEXT, Rating_Address TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists rating_DB");
    }

    public Boolean saveData(String Rating_Name, String Rating_Rating, String Rating_Address) {
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Rating_Name", Rating_Name);
        contentValues.put("Rating_Rating", Rating_Rating);
        contentValues.put("Rating_Address", Rating_Address);

        ContentValues contentValuesNew = new ContentValues();
        contentValuesNew.put("Rating_Name", Rating_Name);
        contentValuesNew.put("Rating_Rating", Rating_Rating);
        contentValuesNew.put("Rating_Address", Rating_Address);

        Cursor cursor = DB.rawQuery("Select * from rating_DB where Rating_Name = ?", new String[]{Rating_Name});
        if (cursor.getCount() > 0) {
            long result = DB.update("rating_DB", contentValues, "Rating_Name=?", new String[]{Rating_Name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            long result = DB.insert("rating_DB", null, contentValuesNew);
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
    }

    public Boolean insertuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        long result = DB.insert("Userdetails", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String name, String contact, String dob) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);
        contentValues.put("dob", dob);
        Cursor cursor = DB.rawQuery("Select * from Userdetails where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            long result = DB.update("Userdetails", contentValues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata(String Rating_Name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from rating_DB where Rating_Name = ?", new String[]{Rating_Name});
        if (cursor.getCount() > 0) {
            long result = DB.delete("rating_DB", "Rating_Name=?", new String[]{Rating_Name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata(String Rating_Name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from rating_DB where Rating_Name = ?", new String[]{Rating_Name});
        return cursor;
    }

    public void getprevdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("DELETE FROM rating_DB");
        return;
    }

    @Override
    public synchronized void close() {
        SQLiteDatabase DB = this.getWritableDatabase();
        if (DB != null) {
            DB.close();
            super.close();
        }
    }
}
