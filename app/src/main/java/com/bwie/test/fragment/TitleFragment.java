package com.bwie.test.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.bwie.test.R;
import com.bwie.test.Utils.CallbackNewsData;
import com.bwie.test.Utils.HttpContent;
import com.bwie.test.Utils.HttpUtils;
import com.bwie.test.activity.WebShowInfo;
import com.bwie.test.adapter.CurrentPageAdapter;
import com.bwie.test.bean.DataBean;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/12 18:55
 */

public class TitleFragment extends Fragment implements PullToRefreshListView.OnRefreshListener2, CallbackNewsData<DataBean> {
    private int currentPage = 0;
    private View view;
    private PullToRefreshListView plv;
    private CurrentPageAdapter adapter;
    private boolean isNeedClear;
    private String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.titlefragment, null);
        initView();
        return view;
        
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        currentPage = getArguments().getInt("id", 0);
        url = HttpContent.getUrl(currentPage);
        initData();
        HttpUtils.LoadDataFromServer(url, DataBean.class, this);
        plv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               DataBean dataBean=adapter.getItem(position);
                String url=dataBean.getUrl_3w();
                Intent intent=new Intent(getContext(), WebShowInfo.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        adapter = new CurrentPageAdapter(getActivity());
        plv.setAdapter(adapter);
    }


    private void initView() {
        plv = (PullToRefreshListView) view.findViewById(R.id.pullListView);
        //同时支持上拉加载和下拉刷新
        plv.setMode(PullToRefreshBase.Mode.BOTH);
        plv.setOnRefreshListener(this);
    }

    @Override
    public void success(ArrayList<DataBean> dataBeen) {

        adapter.addData(dataBeen, false);
        adapter.notifyDataSetChanged();
        plv.onRefreshComplete();
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        currentPage = 1;
        isNeedClear = true;
        url = HttpContent.getUrl(currentPage);
        HttpUtils.LoadDataFromServer(url, DataBean.class, this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentPage++;
        isNeedClear = false;
        String url = HttpContent.getUrl(currentPage);
        HttpUtils.LoadDataFromServer(url, DataBean.class, this);
    }
}
