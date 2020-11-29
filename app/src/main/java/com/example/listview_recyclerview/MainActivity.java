package com.example.listview_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview_recyclerview.listview.FamitlyAdaper;
import com.example.listview_recyclerview.listview.family;
import com.example.listview_recyclerview.recyclerview.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] data ={
            "Apple","Banana","a","b","c"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<family> familyList=new ArrayList<>();
        for(int i=0;i<10;i++) {
            familyList.add(new family("萱萱", "姐姐", R.drawable.a));
            familyList.add(new family("妈妈", "suxia", R.drawable.a));
            familyList.add(new family("爸爸", "junfu", R.drawable.a));
        }
//       ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);//id为内置子项布局的id,,只有一个textview,默认的适配器
        FamitlyAdaper famitlyAdaper=new FamitlyAdaper(MainActivity.this,R.layout.family_item,familyList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(famitlyAdaper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                family family=familyList.get(position);
                Toast.makeText(MainActivity.this,family.getName()+family.getGuanxi(),Toast.LENGTH_LONG).show();
            }
        });


        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(familyList);
        recyclerView.setAdapter(recyclerAdapter);
    }
}