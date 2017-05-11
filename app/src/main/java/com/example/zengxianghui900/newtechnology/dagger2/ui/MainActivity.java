package com.example.zengxianghui900.newtechnology.dagger2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zengxianghui900.newtechnology.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zengxianghui900 on 17/5/9.
 */
public class MainActivity
        extends AppCompatActivity
{

    @BindView(R.id.tv_text)
    TextView mTvText;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        String name   = intent.getStringExtra("name");
        if (!TextUtils.isEmpty(name)) {
            mTvText.setText(name +"已登录！！");
        }else {
            Toast.makeText(this,"用户姓名为空...",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
