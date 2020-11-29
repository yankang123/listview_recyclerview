package com.example.listview_recyclerview.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview_recyclerview.R;

import java.util.List;

import androidx.annotation.NonNull;

public class FamitlyAdaper extends ArrayAdapter {
    private int itemid;

    public FamitlyAdaper(@NonNull Context context, int resource, List<family> object) {
        super(context, resource,object);
  itemid=resource;//子项布局的ID
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){//每个子项被滚动到屏幕内的时候调用getView
        family family=(family) getItem(position);//获取当前项的Family实例,get的是Object,需要的是family

//        View view = LayoutInflater.from(getContext()).inflate(itemid,parent,false);
 ViewHolder viewHolder;
        View view ;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(itemid,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.familyImage=(ImageView)view.findViewById(R.id.image_id);
            viewHolder.name=(TextView)view.findViewById(R.id.name);
            viewHolder.guanxi=(TextView)view.findViewById(R.id.guanxi);
            view.setTag(viewHolder);//将viewHolder存储到View中。
        }else {
            view=convertView;//convertview用于缓存
            viewHolder=(ViewHolder)view.getTag();//重新获取ViewHolder
        }


       //////////////////////////////getview()每次都将布局加载一遍
 //////////////////////////////////////////convert参数用于将之前加载好的布局进行缓存
      //这里每次调用都会重新调用一次findviewByid来获取实例

       viewHolder. familyImage.setImageResource(family.getImageId());
       viewHolder. name.setText(family.getName());
       viewHolder. guanxi.setText(family.getGuanxi());
        return view;
    }
    class ViewHolder{
        ImageView familyImage;
        TextView name;
        TextView guanxi;
    }


}
