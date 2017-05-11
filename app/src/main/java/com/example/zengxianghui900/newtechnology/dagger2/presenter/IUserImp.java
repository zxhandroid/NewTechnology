package com.example.zengxianghui900.newtechnology.dagger2.presenter;

import android.os.SystemClock;
import android.util.Log;

import com.example.zengxianghui900.newtechnology.dagger2.bean.User;

/**
 * Created by zengxianghui900 on 17/5/9.
 */

public class IUserImp implements IUser{
    private User mUser;
    //构造传入User对象
//     @Inject
//    IUserImpModule中不提供provide方法的话，在构造方法上加上这个注解即可
    public IUserImp(User user) {
        mUser = user;
    }
    @Override
    public void login(final String name, final String password, final OnLoginListener listener) {
        Log.e("zxh", "login:mUser== " + mUser);
        //模拟登录,子线程休眠一下
        new Thread(new Runnable() {
            @Override
            public void run() {
                //延时一下
                SystemClock.sleep(2000);
                if ("zxh".equals(name) && "123".equals(password)) {
                    mUser.setName(name);
                    mUser.setPassWord(password);
                    listener.loginSuccess(mUser);       //成功回调
                }else {
                    listener.loginFailed();             //失败回调
                }
            }
        }).start();
    }
}
