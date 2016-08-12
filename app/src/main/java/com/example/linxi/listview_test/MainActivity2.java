package com.example.linxi.listview_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.linxi.listview_test.PersonDao.PersonDao;
import com.example.linxi.listview_test.entities.Person;

import java.util.List;

public class MainActivity2 extends Activity {

    private List<Person>personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ListView mlistview= (ListView) findViewById(R.id.listview);

        PersonDao dao=new PersonDao(this);


        personList=dao.queryALL();

        mlistview.setAdapter(new MyAdapter());
    }
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return personList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View view1=null;

            if(view==null){
                //布局填充器对象，用于将xml布局文件转成view对象
                LayoutInflater layoutInflater=MainActivity2.this.getLayoutInflater();
                view1=layoutInflater.inflate(R.layout.listview_item,null);
            }else{
                view1=view;
            }
            //给view中姓名和年龄赋值
            TextView tv_name= (TextView) view.findViewById(R.id.tv_listview_item_name);
            TextView tv_age=(TextView)view.findViewById(R.id.tv_listview_item_age);

            Person person=personList.get(i);
            tv_name.setText("姓名"+person.getName());
            tv_age.setText("年龄"+person.getAge());
            return view1;
        }
    }
}
