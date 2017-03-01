package com.bwie.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.test.R;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/10 10:00
 */

public class VideoPage extends Fragment {

    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String[] title={"热点视频","娱乐视频","搞笑视频","精品视频"};
    private List<Fragment> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.video,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    }

    private void initData() {
        tabLayout = (TabLayout) view.findViewById(R.id.video_Tab);
        viewPager = (ViewPager) view.findViewById(R.id.video_vp);
        
        list = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            Bundle bundle=new Bundle();
            bundle.putInt("id",i);
            VideoFragment videoFragment=new VideoFragment();
            videoFragment.setArguments(bundle);
            list.add(videoFragment);
        }
    }
}
