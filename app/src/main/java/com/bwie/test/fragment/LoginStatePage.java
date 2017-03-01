package com.bwie.test.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bwie.test.R;
import com.bwie.test.activity.MainActivity;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

/**
 * 1、MODE_NIGHT_NO： 使用亮色(light)主题，不使用夜间模式；
 * 2、MODE_NIGHT_YES：使用暗色(dark)主题，使用夜间模式；
 * 3、MODE_NIGHT_AUTO：根据当前时间自动切换 亮色(light)/暗色(dark)主题；
 * 4、MODE_NIGHT_FOLLOW_SYSTEM(默认选项)：设置为跟随系统，通常为 MODE_NIGHT_NO
 */

public class LoginStatePage extends Fragment {
    private static final String APP_ID = "1106015696";

    private EditText et1;
    private EditText et2;

    private Tencent mTencent; //qq主操作对象  
    private IUiListener loginListener; //授权登录监听器  
    private IUiListener userInfoListener; //获取用户信息监听器  
    private String scope; //获取信息的范围参数  
    private UserInfo userInfo; //qq用户信息 

    private View view;
    private MainActivity parentActivity;
   
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.login_state,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTencent = Tencent.createInstance(APP_ID, getActivity());
        parentActivity = (MainActivity) getActivity();
        LinearLayout imageView= (LinearLayout) view.findViewById(R.id.night);
        ImageView qq_image= (ImageView) view.findViewById(R.id.qq_login);
        // Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
// 其中APP_ID是分配给第三方应用的appid，类型为String。
       
       
        initData();
        qq_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                parentActivity.getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO 
                        ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                // 同样需要调用recreate方法使之生效
                getActivity().recreate();
            }
        });
        

    }
    @Override
    public void onDestroy() {
        if (mTencent != null) {
            //注销登录  
            mTencent.logout(getActivity());
        }
        super.onDestroy();
    }

   

    private void initData() {
        //初始化qq主操作对象  
        mTencent = Tencent.createInstance(APP_ID, getActivity());
        //要所有权限，不然会再次申请增量权限，这里不要设置成get_user_info,add_t  
        scope = "all";

        loginListener = new IUiListener() {

            @Override
            public void onError(UiError arg0) {
                // TODO Auto-generated method stub  

            }

            /**
             * 返回json数据样例 
             *
             * {"ret":0,"pay_token":"D3D678728DC580FBCDE15722B72E7365", 
             * "pf":"desktop_m_qq-10000144-android-2002-", 
             * "query_authority_cost":448, 
             * "authority_cost":-136792089, 
             * "openid":"015A22DED93BD15E0E6B0DDB3E59DE2D", 
             * "expires_in":7776000, 
             * "pfkey":"6068ea1c4a716d4141bca0ddb3df1bb9", 
             * "msg":"", 
             * "access_token":"A2455F491478233529D0106D2CE6EB45", 
             * "login_cost":499}
             */
            @Override
            public void onComplete(Object value) {
                // TODO Auto-generated method stub  

                System.out.println("有数据返回..");
                if (value == null) {
                    return;
                }

                try {
                    JSONObject jo = (JSONObject) value;

                    int ret = jo.getInt("ret");

                    System.out.println("json=" + String.valueOf(jo));

                    if (ret == 0) {
                        Toast.makeText(getActivity(), "登录成功",
                                Toast.LENGTH_LONG).show();

                        String openID = jo.getString("openid");
                        String accessToken = jo.getString("access_token");
                        String expires = jo.getString("expires_in");
                        mTencent.setOpenId(openID);
                        mTencent.setAccessToken(accessToken, expires);
                    }

                } catch (Exception e) {
                    // TODO: handle exception  
                }

            }

            @Override
            public void onCancel() {
                // TODO Auto-generated method stub  

            }
        };


    }

    private void login() {
        //如果session无效，就开始登录  
        if (!mTencent.isSessionValid()) {
            //开始qq授权登录  
            mTencent.login(getActivity(), scope, loginListener);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_API) {
            if (resultCode == Constants.REQUEST_LOGIN) {
                Tencent.handleResultData(data, loginListener);
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

   

}  