package com.sine.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

public class AvUi extends RecyclerView {

    /*
     *RecyclerView的使用方式
     * 1、RecyclerView.LayoutManager控制排列方式
     */
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    public LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public AvUi(Context context) {
        super(context);
    }
}
