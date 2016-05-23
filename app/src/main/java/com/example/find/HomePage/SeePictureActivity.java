package com.example.find.HomePage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.find.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.HomePageActivityAdapter;
import Tool.HandleOther;

public class SeePictureActivity extends AppCompatActivity {


    ViewPager vp_picture;
    int[] screenWidthAndHeight;
    List<View> viewLists = new ArrayList<>();
    TextView tv_page;
    TextView tv_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_picture);
        HandleOther.setTranslucent(this);
        Init();
    }

    public void Init(){
        vp_picture = (ViewPager)findViewById(R.id.vp_picture);
        tv_page = (TextView)findViewById(R.id.tv_page);
        tv_ok = (TextView) findViewById(R.id.tv_ok);
        tv_ok.setOnClickListener(new ClickListener());
        screenWidthAndHeight = getScreenHeightAndWidth();
        for(int i=0;i<5;i++){
            ImageView imageView  = new ImageView(SeePictureActivity.this);
            ViewPager.LayoutParams lp = new ViewPager.LayoutParams();
            lp.height = ViewPager.LayoutParams.WRAP_CONTENT;
            lp.width = ViewPager.LayoutParams.MATCH_PARENT;
            imageView.setLayoutParams(lp);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(R.mipmap.example1+i);
            viewLists.add(imageView);
        }
        vp_picture.setAdapter(new HomePageActivityAdapter(viewLists));
        vp_picture.setOnPageChangeListener(new PageChangeListener(viewLists,tv_page));
        vp_picture.setCurrentItem(0);
    }

    public int[] getScreenHeightAndWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }

    //页面改变监听器
    public class PageChangeListener implements ViewPager.OnPageChangeListener {

        List<View> viewLists;
        TextView index;
        public PageChangeListener(List<View> viewLists, TextView index){
            this.viewLists = viewLists;
            this.index = index;
        }

        @Override
        public void onPageSelected(int arg0) {
            Log.d("显示", "onPageSelected:" + arg0);
            index.setText((arg0+1)+"/"+viewLists.size());

        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
    private class ClickListener implements View.OnClickListener {

        Context context;

        public ClickListener(Context context){
            this.context = context;
        }

        public void onClick(View v) {
            if (v.getId() == R.id.tv_ok) {
                LayoutInflater inflaterDl = LayoutInflater.from(context);
                RelativeLayout layout = (RelativeLayout)inflaterDl.inflate(R.layout.layout_dialog, null );
            }
        }
    }


}
