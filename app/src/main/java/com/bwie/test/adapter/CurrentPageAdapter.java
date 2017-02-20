package com.bwie.test.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.test.R;
import com.bwie.test.bean.DataBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.security.PrivateKey;
import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/17 14:52
 */

public class CurrentPageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<DataBean> list = new ArrayList<>();
    private DisplayImageOptions options;
    private int TYPE_1 = 0;
    private int TYPE_2 = 1;
    private int TYPE_3 = 2;

    public CurrentPageAdapter(Context context) {
        this.mContext = context;
        //设置图片的一些属性
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                //.displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //根据position 来确定返回View 类型
    @Override
    public int getItemViewType(int position) {
        DataBean item = getItem(position);
        if (item.getImgextra() != null ) {
            return TYPE_3;//3
        }  if (item.getImgsrc()!=null) {
            return TYPE_2;//2
        } else {
            return TYPE_1;//1
        }
    }

    //说明一共有几种类型的Item (条目)
    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public DataBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        ViewHolder3 viewHolder3 = null;
        if (convertView == null) {
            if (getItemViewType(position) == TYPE_1) {
                viewHolder1=new ViewHolder1();
                convertView = convertView.inflate(mContext, R.layout.item1, null);
                viewHolder1.textView = (TextView) convertView.findViewById(R.id.text_item1);
                convertView.setTag(viewHolder1);
            } else if (getItemViewType(position) == TYPE_2) {
                viewHolder2=new ViewHolder2();
                convertView = convertView.inflate(mContext, R.layout.item2, null);
                viewHolder2.textView = (TextView) convertView.findViewById(R.id.text_item2);
                viewHolder2.imageView = (ImageView) convertView.findViewById(R.id.image_item2);
                convertView.setTag(viewHolder2);
            } else {
                viewHolder3=new ViewHolder3();
                convertView = convertView.inflate(mContext, R.layout.item3, null);
                viewHolder3.textView = (TextView) convertView.findViewById(R.id.text_item3);
                viewHolder3.imageView = (ImageView) convertView.findViewById(R.id.image_itemA);
                viewHolder3.imageView1 = (ImageView) convertView.findViewById(R.id.image_itemB);
                viewHolder3.imageView2 = (ImageView) convertView.findViewById(R.id.image_itemC);
                convertView.setTag(viewHolder3);
            }
        } else {
            if (getItemViewType(position) == TYPE_1) {
                viewHolder1 = (ViewHolder1) convertView.getTag();
            } else if (getItemViewType(position) == TYPE_2) {
                viewHolder2 = (ViewHolder2) convertView.getTag();
            } else {
                viewHolder3 = (ViewHolder3) convertView.getTag();
            }
        }
        if (getItemViewType(position) == TYPE_1) {
            viewHolder1.textView.setText(getItem(position).getTitle());
        } else if (getItemViewType(position) == TYPE_2) {
            viewHolder2.textView.setText(getItem(position).getTitle());
            String url = getItem(position).getImgsrc();

            ImageLoader.getInstance().displayImage(url, viewHolder2.imageView, options);
        } else {
            viewHolder3.textView.setText(getItem(position).getTitle());
            String url = getItem(position).getImgsrc();
            String url1 = getItem(position).getImgextra().get(0).getImgsrc();
            String url2 = getItem(position).getImgextra().get(1).getImgsrc();
            ImageLoader.getInstance().displayImage(url, viewHolder3.imageView, options);
            ImageLoader.getInstance().displayImage(url1, viewHolder3.imageView1, options);
            ImageLoader.getInstance().displayImage(url2, viewHolder3.imageView2, options);
        }
        return convertView;
    }

    public void addData(ArrayList<DataBean> datas, boolean isNeedClear) {
        if (datas != null) {
            if (isNeedClear) {
                list.clear();
            }
            list.addAll(datas);
        }

    }

    static class ViewHolder1 {
         TextView textView;

    }

    static class ViewHolder2 {
         TextView textView;
         ImageView imageView;
    }

    static class ViewHolder3 {
         TextView textView;
         ImageView imageView, imageView1, imageView2;
    }
}
