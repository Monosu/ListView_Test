package com.example.linxi.listview_test.PersonDao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.linxi.listview_test.PersonDB.PersonSQLiteOpenHelper;
import com.example.linxi.listview_test.entities.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linxi on 2016/8/3.
 */
public class PersonDao {
    private PersonSQLiteOpenHelper mOpenHelper;
    public PersonDao(Context context){
        mOpenHelper=new PersonSQLiteOpenHelper(context);
    }
    //添加到person
    public void insert(Person person){
        SQLiteDatabase db=mOpenHelper.getReadableDatabase();
        if(db.isOpen()){

            db.execSQL("insert into person(name,age)values(?,?);",new Object[]{person.getName(),person.getAge()});
            db.close();
        }
    }

    public void delete(int id){
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        if(db.isOpen()){

            db.execSQL("delete from person where _id=?;",new Integer[]{id});
            db.close();
        }
    }

    public void update(int id,String name){
        SQLiteDatabase db=mOpenHelper.getWritableDatabase();
        if(db.isOpen()){

            db.execSQL("update person set name= ? where _id= ?;",new Object[]{name,id});
            db.close();
        }
    }

    public List<Person> queryALL(){
        SQLiteDatabase db=mOpenHelper.getReadableDatabase();

        if(db.isOpen()){

            Cursor cursor=null;
                    cursor=db.rawQuery("select _id,name,age from person",null);

            if(cursor!=null&&cursor.getCount()>0){
                List<Person> personList=new ArrayList<Person>();
                int id;
                String name;
                int age;
                while(cursor.moveToNext()){
                    id=cursor.getInt(0);//取第0列的id
                    name=cursor.getString(1);//取第1列名字
                    age=cursor.getInt(2);//取第2列年龄

                    personList.add(new Person(id,name,age));

                }
                //cursor.close();
                db.close();
                return personList;
            }
            db.close();
        }
        return null;
    }

    public Person queryItem(int id){
        SQLiteDatabase db=mOpenHelper.getReadableDatabase();
        if(db.isOpen()){
            Cursor cursor=db.rawQuery("select * from person where _id=?;",new String[]{id+""});
            if(cursor!=null&&cursor.moveToFirst()){
                int _id=cursor.getInt(0);
                String name=cursor.getString(1);
                int age=cursor.getInt(2);
                //cursor.close();
                db.close();
                return new Person(_id,name,age);
            }
            db.close();
        }
        return null;
    }
}
