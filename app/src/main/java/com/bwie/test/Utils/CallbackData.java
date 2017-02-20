package com.bwie.test.Utils;

import com.bwie.test.bean.DataBean;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/17 15:53
 */

public interface CallbackData<T> {
    void success(T t);
    void  success(ArrayList<DataBean> dataBeen);
}
