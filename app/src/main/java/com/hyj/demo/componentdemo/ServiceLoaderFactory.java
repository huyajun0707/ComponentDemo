package com.hyj.demo.componentdemo;


import com.hyj.demo.component.routeservice.IServiceLoader;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * =========================================================
 *
 * @author :   HuYajun     <13426236872@163.com>
 * @version :
 * @date :   2019/5/7 15:27
 * @description :
 * =========================================================
 */
class ServiceLoaderFactory {

    private Iterator<IServiceLoader> mIterator;

    private static ServiceLoaderFactory serviceLoaderFactory;

    public static ServiceLoaderFactory getInstance() {
        if (serviceLoaderFactory == null)
            synchronized (ServiceLoaderFactory.class) {
                if (serviceLoaderFactory == null) {
                    serviceLoaderFactory = new ServiceLoaderFactory();
                }
            }
        return serviceLoaderFactory;
    }

    public static void releaseInstantce() {
        if (serviceLoaderFactory != null) {
            serviceLoaderFactory = null;
        }
    }


    private ServiceLoaderFactory() {

    }

    public void loadService(Class inClass) {
        ServiceLoader<IServiceLoader> loader = ServiceLoader.load(IServiceLoader.class);
        mIterator = loader.iterator();
    }


    public IServiceLoader getService() {
        return mIterator.next();
    }

    boolean hasNextService() {
        return mIterator.hasNext();
    }

}
