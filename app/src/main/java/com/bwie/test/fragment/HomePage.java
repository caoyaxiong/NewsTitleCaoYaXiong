package com.bwie.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/10 10:00
 */

public class HomePage extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    
    private String[]title={"推荐","热点","北京","社会","娱乐","军事","科技","汽车","体育","财经"};
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.homepagelayout,null);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.vp);
        
        initData();
        
        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title[position];
            }
        });
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        
        return view;
    }

    private void initData() {
        list = new ArrayList<>();
        for(int i=0;i<title.length;i++) {
            TitleFragment titleFragment = new TitleFragment();
            list.add(titleFragment);
        }
    }
   
    }

