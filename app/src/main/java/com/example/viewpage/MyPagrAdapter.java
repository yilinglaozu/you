package com.example.viewpage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class MyPagrAdapter extends PagerAdapter {
   private List<Integer> list;
   private Context context;

    public MyPagrAdapter(List<Integer> list, Context context) {
        this.list = list;
        this.context = context;
    }

    //图片的数量
    @Override
    public int getCount() {
        return list.size();
    }
   //判断添加的图片与得到的图片是否一致
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }
    //添加图片的方法

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       //创建图片
        ImageView imageView=new ImageView(context);
        //设置图片
        imageView.setImageResource(list.get(position));
        //展示的图片放入viewgroup
        container.addView(imageView);
        return imageView;
    }
    //删除图片的方法

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((View) object);
    }
}
