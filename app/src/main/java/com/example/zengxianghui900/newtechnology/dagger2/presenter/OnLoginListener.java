package com.example.zengxianghui900.newtechnology.dagger2.presenter;

import com.example.zengxianghui900.newtechnology.dagger2.bean.User;

/**
 * 登录回调监听接口
 */
public interface OnLoginListener {
    //登录成功
    void loginSuccess(User user);
    //登录失败
    void loginFailed();

}
