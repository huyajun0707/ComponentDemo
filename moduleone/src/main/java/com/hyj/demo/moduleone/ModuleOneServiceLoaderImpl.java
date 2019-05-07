package com.hyj.demo.moduleone;

import com.google.auto.service.AutoService;
import com.hyj.demo.component.routeservice.IServiceLoader;

/**
 * =========================================================
 *
 * @author :   HuYajun     <13426236872@163.com>
 * @version :
 * @date :   2019/5/7 15:10
 * @description :
 * =========================================================
 */

@AutoService(IServiceLoader.class)
public class ModuleOneServiceLoaderImpl implements IServiceLoader {
    @Override
    public String setParamToMoudle(String msg) {
        return "This is display in module one";
    }
}
