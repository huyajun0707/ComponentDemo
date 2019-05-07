package com.hyj.demo.moduletwo;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hyj.demo.component.routeservice.ModuleOneService;
import com.hyj.demo.component.routeservice.ModuleTwoService;

/**
 * =========================================================
 *
 * @author :   HuYajun     <13426236872@163.com>
 * @version :
 * @date :   2019/5/7 11:16
 * @description :   组件间通信接收数据类
 * =========================================================
 */
@Route(path = "/moudletwo/servicetwo")
public class ModuleTwoServiceImpl implements ModuleTwoService {
    private static final String TAG = "ModuleTwoServiceImpl";

    @Override
    public void init(Context context) {

    }

    @Override
    public String setParamToMoudleTwo(String msg) {
        msg = "hello! MoudleTwo 我想告诉你：" + msg;
        Log.d(TAG, "setParamToMoudleTwo--->" + msg);
        return msg;
    }
}
