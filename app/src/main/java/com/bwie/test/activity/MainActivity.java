package com.bwie.test.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bwie.test.R;
import com.bwie.test.fragment.HomePage;
import com.bwie.test.fragment.LoginStatePage;
import com.bwie.test.fragment.VideoPage;
import com.bwie.test.fragment.WeatherPage;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton home;
    private RadioButton video;
    private RadioButton weather;
    private RadioButton login;
    private FrameLayout frameLayout;
    private HomePage homePage;
    private VideoPage videoPage;
    private WeatherPage weatherPage;
    private LoginStatePage loginStatePage;
    private List<RadioButton> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        home = (RadioButton) findViewById(R.id.home_page);
        video = (RadioButton) findViewById(R.id.video);
        weather = (RadioButton) findViewById(R.id.weather);
        login = (RadioButton) findViewById(R.id.login_state);
        frameLayout = (FrameLayout) findViewById(R.id.fl);
        home.setOnClickListener(this);
        video.setOnClickListener(this);
        weather.setOnClickListener(this);
        login.setOnClickListener(this);
        homePage = new HomePage();
        videoPage = new VideoPage();
        weatherPage = new WeatherPage();
        loginStatePage = new LoginStatePage();
        list = new ArrayList<>();
       list.add(home);
        list.add(video);
        list.add(weather);
        list.add(login);
        list.get(0).setChecked(true);
        radioButtonColor();
        
getSupportFragmentManager().beginTransaction().add(R.id.fl,homePage).commit();
    }

    private void radioButtonColor() {
        
        
        for(RadioButton rb:list){
            if(rb.isChecked()){
                rb.setChecked(true);
                rb.setTextColor(Color.RED);
            }else{
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
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,homePage).commit();
                break;
            case R.id.video:
                radioButtonColor();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,videoPage).commit();
                break;
            case R.id.weather:
                radioButtonColor();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,weatherPage).commit();
                break;
            case R.id.login_state:
                radioButtonColor();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl,loginStatePage).commit();
                break;

        }
    }
}