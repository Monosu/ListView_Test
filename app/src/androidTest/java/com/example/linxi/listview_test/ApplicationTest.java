package com.example.linxi.listview_test;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.linxi.listview_test.PersonDao.PersonDao;
import com.example.linxi.listview_test.entities.Person;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application>  {

    private static final String TAG="ApplicationTest";
    public ApplicationTest() {
        super(Application.class);

    }
//    public void test(){
//        PersonSQLiteOpenHelper openHelper=new PersonSQLiteOpenHelper(getContext());
//        openHelper.getReadableDatabase();
//
//    }
    public void testInsert(){
        PersonDao dao=new PersonDao(getContext());
        for(int i=0;i<20;i++) {
            dao.insert(new Person(i, "haha", 10+i));
        }
    }
//    public void testDelete(){
//        PersonDao dao=new PersonDao(getContext());
//        dao.delete(7);
//
//    }
//    public void testUpdate(){
//        PersonDao dao=new PersonDao(getContext());
//        //dao.update(2,"小明");
//    }
//    public void testQueryAll(){
////        PersonDao dao=new PersonDao(getContext());
////        List<Person> personList= dao.queryALL();
////        for(Person person:personList){
////            Log.i(TAG,person.toString());
////        }
//
//    }
//    public void testQueryItem(){
//        PersonDao dao=new PersonDao(getContext());
//        Person person=dao.queryItem(3);
//        Log.i(TAG,person.toString());
//
//
//    }
}