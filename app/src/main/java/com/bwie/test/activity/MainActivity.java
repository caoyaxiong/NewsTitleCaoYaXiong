package com.bwie.test.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.test.R;
import com.bwie.test.application.MyApplication;
import com.bwie.test.fragment.HomePage;
import com.bwie.test.fragment.LoginStatePage;
import com.bwie.test.fragment.VideoPage;
import com.bwie.test.fragment.AttentionPage;
import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton home;
    private RadioButton video;
    private RadioButton attention;
    private RadioButton login;
    private FrameLayout frameLayout;
    private HomePage homePage;
    private VideoPage videoPage;
    private AttentionPage attentionPage;
    private LoginStatePage loginStatePage;
    private List<RadioButton> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PushAgent.getInstance(this).onAppStart();
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        home = (RadioButton) findViewById(R.id.home_page);
        video = (RadioButton) findViewById(R.id.video);
        attention = (RadioButton) findViewById(R.id.attention );
        login = (RadioButton) findViewById(R.id.login_state);
        frameLayout = (FrameLayout) findViewById(R.id.fl);
        home.setOnClickListener(this);
        video.setOnClickListener(this);
        attention.setOnClickListener(this);
        login.setOnClickListener(this);
        homePage = new HomePage();
        videoPage = new VideoPage();
        attentionPage = new AttentionPage();
        loginStatePage = new LoginStatePage();
        list = new ArrayList<>();
        list.add(home);
        list.add(video);
        list.add(attention);
        list.add(login);
        
        if(MyApplication.frag){
            list.get(0).setChecked(true);
            radioButtonColor();
            getSupportFragmentManager().beginTransaction().add(R.id.fl, homePage).commit();
            MyApplication.frag = false;
        }else{
            list.get(3).setChecked(true);
            radioButtonColor();
        }
    }

    private void radioButtonColor() {


        for (RadioButton rb : list) {
            if (rb.isChecked()) {
                rb.setChecked(true);
                rb.setTextColor(Color.RED);
            } else {
                rb.setChecked(false);
                rb.setTextColor(Color.BLACK);
            }
        }


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_page:
                radioButtonColor();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, homePage).commit();
                break;
            case R.id.video:
                radioButtonColor();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, videoPage).commit();
                break;
            case R.id.attention:
                radioButtonColor();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, attentionPage).commit();
                break;
            case R.id.login_state:
                radioButtonColor();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl, loginStatePage).commit();
                break;

        }
    }
}