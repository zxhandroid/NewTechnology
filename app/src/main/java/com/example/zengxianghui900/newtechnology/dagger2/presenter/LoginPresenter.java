package com.example.zengxianghui900.newtechnology.dagger2.presenter;

import android.os.Handler;
import android.util.Log;

import com.example.zengxianghui900.newtechnology.dagger2.bean.User;

/**
 * Created by zengxianghui900 on 17/5/9.
 */

public class LoginPresenter {

    private IUserLoginView mIUserLoginView;     //页面逻辑操作接口
    private Handler mHandler;
    private IUserImp mIUserImp;                 //model业务操作实现类
    //通过构造传入相应的引用
    public LoginPresenter(IUserLoginView IUserLoginView,Handler handler,IUserImp iUserImp) {
        mIUserLoginView = IUserLoginView;
        mHandler = handler;
        mIUserImp = iUserImp;
    }

    //定义一个登录的方法
    public void login(){
        //显示progress
        mIUserLoginView.showProgress();
        Log.e("zxh","mIUserImp=="+ mIUserImp);
        //开始登录
        mIUserImp.login(mIUserLoginView.getUserName(), mIUserLoginView.getUserPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //主线程中去更新UI
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIUserLoginView.toMainActivity(user);   //进入新页面
                        mIUserLoginView.hideProgress();         //隐藏progress
                    }
                });
            }

            @Override
            public void loginFailed() {
                //主线程中去更新UI
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIUserLoginView.showFailedToast();  //弹土司
                        mIUserLoginView.hideProgress();     //隐藏progress
                    }
                });

            }
        });
    }
}
