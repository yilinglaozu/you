package com.example.viewpage;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private List<Integer> list;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取资源id
          viewPager= (ViewPager) findViewById(R.id.viewpage);
          radioGroup=(RadioGroup)findViewById(R.id.group);

          //添加数据
        list=new ArrayList<Integer>();
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        list.add(R.mipmap.ic_launcher);
        //创建适配器
        MyPagrAdapter pagrAdapter=new MyPagrAdapter(list,MainActivity.this);
        viewPager.setAdapter(pagrAdapter);

        //点击按钮切换viewpage
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.but1:
                    //设置viewpage默认选中的页
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.but2:
                    //设置viewpage默认选中的页
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.but3:
                    //设置viewpage默认选中的页
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.but4:
                    //设置viewpage默认选中的页
                    viewPager.setCurrentItem(3);
                    break;


            }
        }
    });

    //滑动和状态viewpage选中相应的按按钮
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        //页面的偏移
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }
        //页面的选中
        @Override
        public void onPageSelected(int i) {
            //页面为选中状态时 选择对应的Button
            switch ( i){
                case 0:
                    radioGroup.check(R.id.but1);
                    break;
                case 1:
                    radioGroup.check(R.id.but2);
                    break;
                case 2:
                    radioGroup.check(R.id.but3);
                    break;
                case 3:
                    radioGroup.check(R.id.but4);
                    break;


            }
        }
        //页滚动状态
        @Override
        public void onPageScrollStateChanged(int i) {

        }
    });
}
}
