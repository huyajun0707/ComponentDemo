package com.hyj.demo.componentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hyj.demo.component.constant.RouterConstant;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btOne, btTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btOne = findViewById(R.id.btStartOne);
        btTwo = findViewById(R.id.btStartTwo);
        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
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
}
