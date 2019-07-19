package com.frank.makeDream.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ViewPageAdapter extends PagerAdapter {


    //数据
    private ArrayList<View> viewLists;

    //上下文
    private Context context;


    /**
     * 构造函数
     * 初始化上下文和数据
     * @param viewLists
     */
    public ViewPageAdapter(ArrayList<View> viewLists,Context context) {
        this.viewLists = viewLists;
        this.context = context;
    }

    /**
     * 返回要滑动的View的个数
     * @return
     */
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    /**
     * 确定页视图是否与特定键对象关联
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    /**
     * 1.将当前视图添加到container中
     * 2.返回当前View
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position % viewLists.size()));
        return viewLists.get(position % viewLists.size());
    }


    /**
     * 从当前container中删除指定位置（position）的View
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        object = null;
    }
}
