package com.hyj.demo.moduleone;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hyj.demo.component.routeservice.IService;

/**
 * =========================================================
 *
 * @author :   HuYajun     <13426236872@163.com>
 * @version :
 * @date :   2019/5/6 15:37
 * @description : 组件间通信接收数据类
 * =========================================================
 */
@Route(path = "/moudleone/serviceone")
public class ServiceImpl implements IService {
    private static final String TAG = "ServiceImpl";

    @Override
    public void init(Context context) {

    }

    @Override
    public String setParam(String name) {
        Log.d(TAG, "setParam: " + name);
        return "hello! " + name;
    }
}
