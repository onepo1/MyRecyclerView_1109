package com.example.edu.myrecyclerview_1109;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String name = "awe.db";
    private static final SQLiteDatabase.CursorFactory factory = null;
    private static final int version = 1;

    public MyDBOpenHelper(Context context) {
        super(context, name, factory, version);
    }

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE ordered (_id INTEGER PRIMARY KEY AUTOINCREMENT, itemCount INTEGER, itemDay TEXT);";
        db.execSQL(sql);
//        db.execSQL("CREATE TABLE ordered (_id INTEGER PRIMARY KEY AUTOINCREMENT,itemImg text, itemCount INTEGER, itemDay TEXT);");
//        String itemImg_route = "android_image_";
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//        String itemDay = format.format(new Date());
//        for(int i=0; i<10; i++){
//            db.execSQL("INSERT INTO ordered VALUES( null, '" + "itemImg_route"+ i + "','" + i + "', '" + itemDay + "');");
//        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE ordered ;");
        onCreate(db);
//        Toast.makeText(this.,"onUpgrade", Toast.LENGTH_LONG).show();
    }

    public void deleteRecord(SQLiteDatabase mdb, String country) {
//        mdb.execSQL("DELETE FROM ordered WHERE country='" + country + "';");
    }

}
