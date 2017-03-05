package com.baway.zhuzhenjiang.yuekao1;

import android.app.Application;

/**
 * 作者：朱振江 on 2017/3/4 0004 11:26
 * 邮箱：zzjdys@Gmail.com
 * 类用途:
 */


public class Myapp extends Application {
    
    public static int list_id;
    
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderutils.initConfiguration(this);
    }
}
