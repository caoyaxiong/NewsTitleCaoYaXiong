package com.bwie.test.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.test.R;
import com.bwie.test.bean.VideoBean;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/21 20:46
 */

public class VideoAdapter extends BaseAdapter {
    private Context mContext;
    private List<VideoBean>list = new ArrayList<>();
    private DisplayImageOptions options;
    public VideoAdapter(Context context) {
        this.mContext=context;
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

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder = new ViewHolder();
            convertView=View.inflate(mContext, R.layout.jc_video_player,null);
            viewHolder.jcVideoPlayer= (JCVideoPlayer) convertView.findViewById(R.id.jcvideoplayer);
           viewHolder.imageView= (ImageView) convertView.findViewById(R.id.video_image);
            viewHolder.textView= (TextView) convertView.findViewById(R.id.video_text);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.jcVideoPlayer.setUp(list.get(position).getMp4_url(),list.get(position).getTitle());
        ImageLoader.getInstance().displayImage(list.get(position).getCover(),viewHolder.jcVideoPlayer.ivThumb,options);
        ImageLoader.getInstance().displayImage(list.get(position).getTopicImg(),viewHolder.imageView,options);
        viewHolder.textView.setText(list.get(position).getTopicName());
       
        return convertView;
    }
    public  void addData(List<VideoBean>videoBeen,boolean isNeedClear ){
        if (videoBeen!=null){
            if(isNeedClear){
                list.clear();
            }
            list.addAll(videoBeen);
        }
    }
    class ViewHolder{
        JCVideoPlayer jcVideoPlayer;
        ImageView imageView;
        TextView textView;
    }
}
