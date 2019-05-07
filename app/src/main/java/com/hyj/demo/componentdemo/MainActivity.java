package com.hyj.demo.componentdemo;

import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hyj.demo.component.constant.RouterConstant;
import com.hyj.demo.component.utils.FragmentUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TabLayout
        .OnTabSelectedListener {
    private Button btOne, btTwo;
    private TabLayout tlMenu;
    private FragmentUtil fragmentUtil;
    private static final String TAG = "MainActivity";
    private Fragment fragmentOne;
    private Fragment fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        initTabLayout();
    }

    private void initTabLayout() {
        tlMenu.setTabMode(TabLayout.MODE_FIXED);
        tlMenu.setBackgroundColor(Color.WHITE);
        tlMenu.setSelectedTabIndicatorHeight(0);
        tlMenu.addTab(tlMenu.newTab().setText("模块1"));
        tlMenu.addTab(tlMenu.newTab().setText("模块2"));
        fragmentUtil = new FragmentUtil(getSupportFragmentManager(), R.id.tlContent);
        fragmentOne = (Fragment) ARouter.getInstance().build(RouterConstant
                .MODULE_ONE_FRAGMENT_ONE).navigation();
        fragmentTwo = (Fragment) ARouter.getInstance().build(RouterConstant
                .MODULE_TWO_FRAGMENT_TWO).navigation();
        Log.d(TAG, "initTabLayout: " + fragmentOne.getClass());
        fragmentUtil.addItem(new FragmentUtil.OperationInfo(this, getString(R.string.module_one),
                fragmentOne.getClass()));
        fragmentUtil.addItem(new FragmentUtil.OperationInfo(this, getString(R.string.module_two),
                fragmentTwo.getClass()));
        fragmentUtil.show(getString(R.string.module_one), true);
    }

    private void findViewById() {
        btOne = findViewById(R.id.btStartOne);
        btTwo = findViewById(R.id.btStartTwo);
        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        tlMenu = findViewById(R.id.tlMenu);
        tlMenu.addOnTabSelectedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btStartOne:
                ARouter.getInstance().build(RouterConstant.MODULE_ONE).navigation();
                break;
            case R.id.btStartTwo:
                ARouter.getInstance().build(RouterConstant.MODULE_TWO).navigation();
                break;
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                if (fragmentOne != null)
                    fragmentUtil.show(getString(R.string.module_one), true);
                break;
            case 1:
                if (fragmentTwo != null)
                    fragmentUtil.show(getString(R.string.module_two), true);
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
