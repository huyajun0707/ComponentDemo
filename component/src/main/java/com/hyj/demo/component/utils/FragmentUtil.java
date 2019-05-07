package com.hyj.demo.component.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;

public class FragmentUtil {

    private FragmentManager fragmentManager;
    private HashMap<String, OperationInfo> items = new HashMap<String, OperationInfo>();
    private OperationInfo operationInfo;
    private int resource;
    private int[] animations = new int[2];

    public FragmentUtil(FragmentManager fragmentManager, int resource) {
        this.fragmentManager = fragmentManager;
        this.resource = resource;
        items.clear();
        animations[0] = android.R.anim.fade_in;
        animations[1] = android.R.anim.fade_out;
    }

    public void addItem(OperationInfo info) {
        items.put(info.getTag(), info);
    }

    public void getItem(OperationInfo info) {
        items.get(info.getTag());
    }

    public boolean isShowing(String tag) {
        return operationInfo.mTag.equals(tag);
    }

    public Fragment show(String tag, boolean hasAnimate) {
        return show(items.get(tag), hasAnimate);
    }

    public Fragment show(int id, boolean hasAnimate) {
        return show(items.get(String.valueOf(id)), hasAnimate);
    }

    public Fragment show(String tag, Bundle args, boolean hasAnimate) {
        OperationInfo info = items.get(tag);
        info.mBundle = args;
        return show(info, hasAnimate);
    }

    private Fragment show(OperationInfo info, boolean hasAnimate) {
        FragmentTransaction transaction = fragmentManager.beginTransaction().disallowAddToBackStack();
        if (hasAnimate) {
            transaction.setCustomAnimations(animations[0], animations[1]);
        }
        if (operationInfo != info) {
            if (operationInfo != null && operationInfo.mFragment != null) {
                transaction.hide(operationInfo.mFragment);
            }
            operationInfo = info;
            if (operationInfo != null) {
                if (operationInfo.mFragment == null) {
                    operationInfo.mFragment = Fragment.instantiate(operationInfo.mContext, operationInfo.mClass.getName(), operationInfo.mBundle);
                    if (info.mBundle != null) {
                        operationInfo.mFragment.setArguments(info.mBundle);
                    }
                    transaction.add(resource, operationInfo.mFragment, operationInfo.mTag);
                } else {
                    transaction.show(operationInfo.mFragment);
                }
            }
        } else {
            //已经显示
        }
        transaction.commitAllowingStateLoss();
        if (operationInfo == null) {
            return null;
        } else {
            return operationInfo.mFragment;
        }
    }

    public static class OperationInfo {
        protected Context mContext;
        protected String mTag;
        protected Class<?> mClass;
        protected Bundle mBundle;
        protected Fragment mFragment;

        public OperationInfo(Context context, String tag, Class<?> cls) {
            this(context, tag, cls, null);
        }

        public OperationInfo(Context context, int viewId, Class<?> cls) {
            this(context, viewId, cls, null);
        }

        public OperationInfo(Context context, String tag, Class<?> cls, Bundle args) {
            this.mContext = context;
            this.mTag = tag;
            this.mClass = cls;
            this.mBundle = args;
        }

        public OperationInfo(Context context, int viewId, Class<?> cls, Bundle args) {
            this.mContext = context;
            this.mTag = String.valueOf(viewId);
            this.mClass = cls;
            this.mBundle = args;
        }


        public String getTag() {
            return mTag;
        }
    }
}
