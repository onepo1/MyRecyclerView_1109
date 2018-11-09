package com.example.edu.myrecyclerview_1109;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;
    FloatingActionButton floatingActionButton;

    MyDBOpenHelper myDBOpenHelper;
    SQLiteDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBOpenHelper = new MyDBOpenHelper(this, "awe.db", null , 1);
        mdb = myDBOpenHelper.getWritableDatabase();
        adapter = new RecyclerAdapter(mdb);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.faBtn);
        floatingActionButton.setOnClickListener(this);


        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        arrayList = new ArrayList<HashMap<String, Object>>();
        HashMap<String,Object> hashMap = null;
        hashMap = new HashMap<String, Object>();
        hashMap.put("title" , "Chaper Two");
        hashMap.put("detail" , "Item two derails");
        hashMap.put("image" , R.drawable.android_image_2);
        arrayList.add(hashMap); //Add DATA

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);



    }

    @Override
    public void onClick(View v) {
        ;
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("title" , "Chaper One");
        hashMap.put("detail" , "Item two derails");
        hashMap.put("image" , R.drawable.android_image_1);
        adapter.addItem(1,hashMap);
    }
}
