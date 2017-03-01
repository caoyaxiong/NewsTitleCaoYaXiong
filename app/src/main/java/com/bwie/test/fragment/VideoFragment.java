package com.bwie.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bwie.test.R;
import com.bwie.test.Utils.CallbackData;
import com.bwie.test.Utils.CallbackNewsData;
import com.bwie.test.Utils.HttpContent;
import com.bwie.test.Utils.HttpUtils;
import com.bwie.test.adapter.VideoAdapter;
import com.bwie.test.bean.VideoBean;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/21 20:35
 */

public class VideoFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2,CallbackNewsData<VideoBean>{

    private View view;
    private int currentPage = 0;
    private PullToRefreshListView pullToRefreshListView;
    private VideoAdapter adapter;
    private boolean isNeedClear;
    private String url;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.videopagelayout,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.video_pull);
       pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(this);
        currentPage=getArguments().getInt("id");
        initData();
        url= HttpContent.getVideoUrl(currentPage);
        
        HttpUtils.LoadDataFromServer(url,VideoBean.class,this);
        
    }

    private void initData() {
        adapter = new VideoAdapter(getActivity());
        pullToRefreshListView.setAdapter(adapter);
    }

    @Override
    public void success(ArrayList<VideoBean> newsContents) {
        adapter.addData(newsContents,false);
        adapter.notifyDataSetChanged();
        pullToRefreshListView.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        currentPage=1;
        isNeedClear=true;
        url= HttpContent.getVideoUrl(currentPage);
        HttpUtils.LoadDataFromServer(url,VideoBean.class,this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentPage++;
        isNeedClear=false;
        url=HttpContent.getVideoUrl(currentPage);
        HttpUtils.LoadDataFromServer(url,VideoBean.class,this);
    }
}
