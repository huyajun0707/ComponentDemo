package com.hyj.demo.moduleone;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.auto.service.AutoService;
import com.hyj.demo.component.routeservice.IServiceLoader;
import com.hyj.demo.component.routeservice.ModuleOneService;
import com.hyj.demo.component.routeservice.ModuleTwoService;

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
public class ModuleOneServiceImpl implements ModuleOneService {
    private static final String TAG = "ModuleOneServiceImpl";

    @Override
    public void init(Context context) {

    }

    @Override
    public String setParamToMoudleOne(String msg) {
        msg = "hello! MoudleOne 我想告诉你：" + msg;
        Log.d(TAG, "setParamToMoudleOne--->" + msg);
        String replyMsg = "我收到你的消息了";
        ARouter.getInstance().navigation(ModuleTwoService.class).setParamToMoudleTwo(replyMsg);
        return msg;
    }
}
