package com.example.zengxianghui900.newtechnology.dagger2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.zengxianghui900.newtechnology.R;
import com.example.zengxianghui900.newtechnology.dagger2.bean.User;
import com.example.zengxianghui900.newtechnology.dagger2.component.DaggerLoginComponent;
import com.example.zengxianghui900.newtechnology.dagger2.module.IUserImpModule;
import com.example.zengxianghui900.newtechnology.dagger2.module.LoginModule;
import com.example.zengxianghui900.newtechnology.dagger2.module.UserModule;
import com.example.zengxianghui900.newtechnology.dagger2.presenter.IUserLoginView;
import com.example.zengxianghui900.newtechnology.dagger2.presenter.LoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.zengxianghui900.newtechnology.R.id.et_name;

public class LoginActivity extends AppCompatActivity implements IUserLoginView{

    @Inject
    LoginPresenter mLoginPresenter;     //注入引用对象

    @BindView(et_name)
    EditText    mEtName;
    @BindView(R.id.et_password)
    EditText    mEtPassword;
    @BindView(R.id.btn_login)
    Button      mBtnLogin;
    @BindView(R.id.pb)
    ProgressBar mPb;
    private Unbinder mBind;

//    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ButterKnife绑定
        mBind = ButterKnife.bind(this);
        //不通过dagger2则要new 好几次对象
        //LoginPresenter presenter = new LoginPresenter(this,mHandler,new IUserImp(new User()));

        /**dagger2依赖注入初始化*/
        DaggerLoginComponent.builder()
                            .userModule(new UserModule())
                            .iUserImpModule(new IUserImpModule())
                            .loginModule(new LoginModule(this))
                            .build()
                            .injectLoginActivity(this);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        //点击登录按钮,执行登录逻辑
        mLoginPresenter.login();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除butterknife绑定
        mBind.unbind();
    }

    @Override
    public String getUserName() {           //获取用户名
        return mEtName.getText()
                      .toString();
    }

    @Override
    public String getUserPassWord() {       //获取密码
        return mEtPassword.getText()
                          .toString();
    }

    @Override
    public void showProgress() {            //显示progress
        mPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {            //隐藏progress
        mPb.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) { //跳转到登录成功页面
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("name",user.getName());
        intent.putExtra("passWord",user.getPassWord());
        startActivity(intent);
//        finish();
    }

    @Override
    public void showFailedToast() {         //弹土司
        Toast.makeText(this,"登录失败,用户名或密码错误...",Toast.LENGTH_SHORT).show();
    }
}
