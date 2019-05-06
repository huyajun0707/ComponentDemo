package com.hyj.demo.component.routeservice;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * =========================================================
 *
 * @author :   HuYajun     <13426236872@163.com>
 * @version :
 * @date :   2019/5/6 15:26
 * @description : 组件间通信接口
 * =========================================================
 */
public interface IService extends IProvider {
    String setParam(String name);
}
