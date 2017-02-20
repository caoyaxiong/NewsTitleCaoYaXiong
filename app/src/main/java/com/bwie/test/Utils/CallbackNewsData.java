package com.bwie.test.Utils;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/2/17 15:55
 */

public interface CallbackNewsData<T> {
    void  success(ArrayList<T> newsContents);
}
