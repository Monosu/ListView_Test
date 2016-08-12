package com.example.linxi.listview_test.PersonDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by linxi on 2016/8/3.
 */
public class PersonSQLiteOpenHelper extends SQLiteOpenHelper {
    public PersonSQLiteOpenHelper(Context context) {
        super(context, "test.db", null, 1);
    }

    /**
     * 数据库初始化时回调此方法
     * @param db
	 */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //操作数据库
        String sql="create table person(_id integer primary key,name varchar(20),age integer );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {





    }
}
