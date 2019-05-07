package com.hyj.demo.moduletwo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hyj.demo.component.constant.RouterConstant;


/**
 * =========================================================
 *
 * @author :   HuYajun     <13426236872@163.com>
 * @version :
 * @date :   2019/5/6 17:23
 * @description :
 * =========================================================
 */
@Route(path = RouterConstant.MODULE_TWO_FRAGMENT_TWO)
public class FragmentTwo extends Fragment {
    private View rootView;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        return rootView;
    }

}
