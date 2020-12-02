package com.example.listview_recyclerview.recyclerview;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview_recyclerview.Callback;
import com.example.listview_recyclerview.R;
import com.example.listview_recyclerview.listview.family;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<family> familyList;
    private Callback listener;
  public   static class ViewHolder extends RecyclerView.ViewHolder{
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
//    public RecyclerAdapter (List<family> familyList,Callback listener){
//      this.listener=listener;
//        this.familyList=familyList;
//    }

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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final family family=familyList.get(position);
        if (family.getisIschecked() == false) {
            holder.Familyimage.setImageResource(family.getImageId());
            holder.familyname.setText(family.getName());
            holder.familyguanxi.setText(family.getGuanxi());
        } else  {
          holder.Familyimage.setImageResource(R.color.colorAccent);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<familyList.size();i++){
                    familyList.get(i).setIschecked(false);
                }

                family.setIschecked(true);
                notifyDataSetChanged();
                holder.Familyimage.setImageResource(R.color.colorAccent);
            }
        });
    }

//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position, List payloads) {//用于对Recyclerview子项布局赋值的，在每个子项滚动到屏幕内的时候执行
//
////    family family=familyList.get(position);
////    holder.Familyimage.setImageResource(family.getImageId());
////    holder.familyname.setText(family.getName());
////    holder.familyguanxi.setText(family.getGuanxi());
////        final family family=familyList.get(position);
////        if (family.getisIschecked() == false) {
////            holder.Familyimage.setImageResource(family.getImageId());
////            holder.familyname.setText(family.getName());
////            holder.familyguanxi.setText(family.getGuanxi());
////        } else  {
////          holder.Familyimage.setImageResource(R.color.colorAccent);
////        }
////holder.itemView.setOnClickListener(new View.OnClickListener() {
//
////
////    @Override
////    public void onClick(View v) {
//////        listener.callback(position,holder);//回调放后面会使先判断，再回调mainActivity里改变数据，所以这里放前面，先回调改变mainActivity列表数据，再判断
////       // familyList.get(position).setIschecked(true);//我认为这里改变的是形式参数，所以重新划回来的时候，重新用了实际参数构建item
////
////            family.setIschecked(true);
////            holder.Familyimage.setImageResource(R.color.colorAccent);
////            ;//当点击后，变图片后，滑动之后再刷新回来，会
////
////    }
////});
//        //这里进行局部刷新
//        if(payloads.isEmpty()){
//            family family2=familyList.get(position);
//              holder.Familyimage.setImageResource(family2.getImageId());
//               holder.familyname.setText(family2.getName());
//              holder.familyguanxi.setText(family2.getGuanxi());
//        }else {
//          family family2=(family)payloads.get(0);
//          holder.familyguanxi.setText(family2.getGuanxi());
//          holder.familyname.setText(family2.getName());
//        }
//    }

    @Override
    public int getItemCount() {
        return familyList.size();
    }
}
