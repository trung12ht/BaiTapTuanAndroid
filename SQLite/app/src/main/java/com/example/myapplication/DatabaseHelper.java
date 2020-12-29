package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student1.db";
    public static final String COL_0 = "hocsinh";
    public static final String COL_1 = "mssv";
    public static final String COL_2 = "hoten";
    public static final String COL_3 = "ngaysinh";
    public static final String COL_4 = "diachi";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + COL_0 + " (mssv TEXT PRIMARY KEY, hoten TEXT, ngaysinh TEXT, diachi TEXT)");
        insertData("20170001", "Nguyễn Văn A", "20/11/1999", "Hà Nội");
        insertData("20170002", "Trần Thị B", "20/3/1999", "Hà Nội");
        insertData("20170003", "Bùi Thị C", "21/3/1999", "Thành Phố Hồ Chí Minh");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + COL_0);
        onCreate(db);
    }

    public boolean insertData(String mssv, String hoten, String ngaysinh, String diachi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, mssv);
        contentValues.put(COL_2, hoten);
        contentValues.put(COL_3, ngaysinh);
        contentValues.put(COL_4, diachi);
        long result = db.insert(COL_0, null, contentValues);
        if (result == -1)
                return  false;
        else return true;
    }

    public boolean updateData(String mssv, String hoten, String ngaysinh, String diachi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, mssv);
        contentValues.put(COL_2, hoten);
        contentValues.put(COL_3, ngaysinh);
        contentValues.put(COL_4, diachi);
        long result = db.update(COL_0, contentValues, "mssv=?", new String[]{mssv});
        if (result == -1)
            return  false;
        else return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + COL_0, null);
        return res;
    }

    public Integer deleteData(String mssv) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(COL_0, "mssv = ?", new String[] {mssv});
    }
}