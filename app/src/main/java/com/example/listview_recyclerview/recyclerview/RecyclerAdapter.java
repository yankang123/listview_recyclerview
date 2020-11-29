package com.example.listview_recyclerview.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview_recyclerview.R;
import com.example.listview_recyclerview.listview.family;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<family> familyList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView Familyimage;
        TextView familyname;
        TextView familyguanxi;
        public ViewHolder(View view){//此view通常为Recyclerview子项的最外层布局
            super(view);
            Familyimage=(ImageView)view.findViewById(R.id.image_id);//viewholder就是为了缓存这些实例的，不用每次都获得findviewbyid一次
            familyname=(TextView)view.findViewById(R.id.name);
            familyguanxi=(TextView)view.findViewById(R.id.guanxi);
        }
    }
    public RecyclerAdapter (List<family> familyList){
        this.familyList=familyList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//OncreateViewHolder就是创建ViewHolder实例的
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.family_item,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {//用于对Recyclerview子项布局赋值的，在每个子项滚动到屏幕内的时候执行
    family family=familyList.get(position);
    holder.Familyimage.setImageResource(family.getImageId());
    holder.familyname.setText(family.getName());
    holder.familyguanxi.setText(family.getGuanxi());
    }

    @Override
    public int getItemCount() {
        return familyList.size();
    }
}
