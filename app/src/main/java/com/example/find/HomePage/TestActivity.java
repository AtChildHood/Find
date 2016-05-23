package com.example.find.HomePage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.example.find.R;

public class TestActivity extends AppCompatActivity {


    FrameLayout fl_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        fl_content = (FrameLayout)findViewById(R.id.fl_content);
        HomePageFragment homePageFragment = new HomePageFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.fl_content,homePageFragment,"homePageFragment").show(homePageFragment)
                .commit();
    }

}
