package com.hyj.demo.moduleone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hyj.demo.component.constant.RouterConstant;


@Route(path = RouterConstant.MODULE_ONE)
public class OneActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "OneActivity";
    private Button btStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        btStart = findViewById(R.id.btStart);
        btStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btStart) {
            //跳转至模块二的页面
            ARouter.getInstance().build(RouterConstant.MODULE_TWO).navigation();
        }
    }

}
