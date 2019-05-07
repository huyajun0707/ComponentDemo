package com.hyj.demo.moduletwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hyj.demo.component.constant.RouterConstant;
import com.hyj.demo.component.routeservice.ModuleOneService;

@Route(path = RouterConstant.MODULE_TWO)
public class TwoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTitle;
    private Button btGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        tvTitle = findViewById(R.id.tvTitle);
        btGet = findViewById(R.id.btGet);
        btGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btGet) {
            ModuleOneService impl = ARouter.getInstance().navigation(ModuleOneService.class);
            tvTitle.setText(impl.setParamToMoudleOne("哈哈哈哈!我是MoudleTwo,你能收到我的消息吗"));
        }
    }
}
