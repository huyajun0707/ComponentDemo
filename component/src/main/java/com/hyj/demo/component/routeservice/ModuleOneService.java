package com.hyj.demo.component.routeservice;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * =========================================================
 *
 * @author :   HuYajun     <13426236872@163.com>
 * @version :
 * @date :   2019/5/6 15:26
 * @description : 组件间通信接口   模块1 对外提供的通信接口
 * =========================================================
 */
public interface ModuleOneService extends IProvider {
    String setParamToMoudleOne(String msg);
}
