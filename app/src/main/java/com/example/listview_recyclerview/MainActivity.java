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
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] data ={
            "Apple","Banana","a","b","c"
    };
  List<family> familyList=new LinkedList<>();
    RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<10;i++) {
            familyList.add(new family("萱萱", "姐姐", R.drawable.a,false));
            familyList.add(new family("妈妈", "suxia", R.drawable.a,false));
            familyList.add(new family("爸爸", "junfu", R.drawable.a,false));
        }
//       ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);//id为内置子项布局的id,,只有一个textview,默认的适配器
        final FamitlyAdaper famitlyAdaper=new FamitlyAdaper(MainActivity.this,R.layout.family_item,familyList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(famitlyAdaper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                family family=familyList.get(position);
                Toast.makeText(MainActivity.this,family.getName()+family.getGuanxi(),Toast.LENGTH_LONG).show();
family.setName("kagakng");
family.setGuanxi("老大");
familyList.get(position).setGuanxi("我都服了");
recyclerAdapter.notifyItemChanged(position);//只更新某一个位置
             //   recyclerAdapter.notifyItemChanged(position,family);//第一个位置，应该是要更新的的位置，确定更新某个位置，还可以传参数确定更新item里的某个控件
                ///局部更新
            }
        });


        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
//     recyclerAdapter =new RecyclerAdapter(familyList, new Callback() {
//            @Override
//            public void callback(int position, RecyclerAdapter.ViewHolder holder) {
//                familyList.get(position).setIschecked(true);
//                Toast.makeText(MainActivity.this,""+familyList.get(position).getisIschecked(),Toast.LENGTH_LONG).show();
//                //接口回调，然后可以在maiactivity,设置点击事件
//
//                    //holder.itemView. /////////////////////////////////////////////////???????????????????????????????????holder还是获得不了item里的控件，可能Activity里就不能用Holder获取控件
//
//
//            }
//        });
       recyclerAdapter=new RecyclerAdapter(familyList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager manager=recyclerView.getLayoutManager();
        View view = manager.getChildAt(2);

        }

    }
