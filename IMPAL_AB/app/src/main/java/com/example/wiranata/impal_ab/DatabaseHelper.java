package com.example.wiranata.impal_ab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="abwar.db";
    public static final String TAB1_NAME="akun";
    public static final String TAB1_COL1="id_akun";
    public static final String TAB1_COL2="username";
    public static final String TAB1_COL3="password";
    public static final String TAB1_COL4="role";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TAB1_NAME + "(" + TAB1_COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TAB1_COL2 +" TEXT, " + TAB1_COL3 + " TEXT, "+ TAB1_COL4 + " TEXT)");
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TAB1_COL2, "admin");
        contentValues.put(DatabaseHelper.TAB1_COL3, "admin");
        contentValues.put(DatabaseHelper.TAB1_COL4, "owner");
        long id = db.insert(DatabaseHelper.TAB1_NAME, null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TAB1_NAME);
        onCreate(db);
    }
}
