package com.example.find.HomePage;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.find.R;

public class HomePageActivity extends AppCompatActivity {

    private final String TAG = "HomePageActivity";
    RadioButton rb_introduce;
    RadioButton rb_club;
    RadioGroup  rg_group;
    HomePageIntroduceFragment introduce;
    HomePageClubFragment club;
    TextView chat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        rb_introduce = (RadioButton)findViewById(R.id.rb_introduce);
        rb_club = (RadioButton)findViewById(R.id.rb_club);
        rg_group = (RadioGroup)findViewById(R.id.rg_group);
        chat = (TextView)findViewById(R.id.chat);

        introduce = new HomePageIntroduceFragment();
        club = new HomePageClubFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.fl_content,introduce,"introduce")
                .add(R.id.fl_content, club,"club")
                .commit();
        GroupClickListener clickListener = new GroupClickListener();
        rg_group.setOnCheckedChangeListener(clickListener);

        ClickListener tv_clickListener =new ClickListener();
        chat.setOnClickListener(tv_clickListener);
    }

    private class ClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (v.getId() == R.id.chat) {
                Intent intent = new Intent(HomePageActivity.this, ChatGroupActivity.class);
                startActivity(intent);
            }
        }
    }

    private class GroupClickListener implements RadioGroup.OnCheckedChangeListener{

        public void onCheckedChanged(RadioGroup group, int checkedId) {

            Fragment introduce= getFragmentManager().findFragmentByTag("introduce");;
            Fragment club= getFragmentManager().findFragmentByTag("club");
            // TODO Auto-generated method stub
            if(checkedId==rb_introduce.getId()){
                getFragmentManager().beginTransaction().hide(club).show(introduce).commit();
                }else if(checkedId==rb_club.getId()){
                getFragmentManager().beginTransaction().hide(introduce).show(club).commit();


            }
        }
    }
}
