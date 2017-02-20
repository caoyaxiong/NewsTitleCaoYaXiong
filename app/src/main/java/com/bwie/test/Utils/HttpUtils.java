package com.bwie.test.Utils;

import android.util.Log;

import com.bwie.test.bean.DataBean;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/17 14:17
 */

public class HttpUtils {
    public static <T> void LoadDataFromServer(String url,final  Class<T> clazz,final CallbackNewsData callBackData){
        
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ArrayList<T> newsContents=new ArrayList<>();
                try {
                    JSONObject jsonObject=new JSONObject(result);
                    Iterator<String> keys=jsonObject.keys();
                    while (keys.hasNext()){
                        String next=keys.next();
                        JSONArray jsonArray=jsonObject.optJSONArray(next);
                        for (int i = 0; i <jsonArray.length() ; i++) {
                            JSONObject json=jsonArray.optJSONObject(i);
                            T newsContent=gson.fromJson(json.toString(),clazz);
                            newsContents.add(newsContent);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callBackData.success(newsContents );
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
   
}
