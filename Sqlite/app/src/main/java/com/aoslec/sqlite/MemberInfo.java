package com.aoslec.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemberInfo extends SQLiteOpenHelper {

    //생성자 이름은 클라스 이름과 같아야 한다
    public MemberInfo(Context context){
        super(context,"MemberInfo.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query = "CREATE TABLE member(id INTEGER PRIMARY KEY AUTOINCREMENT," + " username TEXT, userid TEXT, passwd INTEGER);";
        String query = "CREATE TABLE member(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, userid TEXT, passwd INTEGER);";
        db.execSQL(query);

        //앱을 맨처음 가동할때만 실행
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String query = "DROP TABLE IF EXISTS member";
        String query = "DROP TABLE IF EXISTS member";
        db.execSQL(query);
        onCreate(db);
        //앱을 지우거나 버젼을 바꾸면 드롭한다
    }
}
