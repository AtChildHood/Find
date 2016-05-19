package com.example.find.HomePage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.find.R;

public class UserActivity extends AppCompatActivity {


    android.support.percent.PercentRelativeLayout rl_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTranslucent(this);
        Toast.makeText(this,getStatusHeight(this)+"",Toast.LENGTH_SHORT).show();
        rl_title = (android.support.percent.PercentRelativeLayout)findViewById(R.id.rl_title);
//        rl_title.getLayoutParams().
    }

    public static void setTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //ÉèÖÃ×´Ì¬À¸Í¸Ã÷¶È
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }


        public int getStatusHeight(Context context) {

            int statusHeight = -1;
            try {
                Class<?> clazz = Class.forName("com.android.internal.R$dimen");
                Object object = clazz.newInstance();
                int height = Integer.parseInt(clazz.getField("status_bar_height")
                        .get(object).toString());
                statusHeight = context.getResources().getDimensionPixelSize(height);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return statusHeight;
        }

}
