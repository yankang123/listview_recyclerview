package com.example.listview_recyclerview;

import com.example.listview_recyclerview.recyclerview.RecyclerAdapter;

public interface Callback {
    public void callback(int position, RecyclerAdapter.ViewHolder viewHolder);
}
