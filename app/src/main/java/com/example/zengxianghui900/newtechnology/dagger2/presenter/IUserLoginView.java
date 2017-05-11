package com.example.zengxianghui900.newtechnology.dagger2.presenter;

import com.example.zengxianghui900.newtechnology.dagger2.bean.User;

/**
 * Created by zengxianghui900 on 17/5/9.
 */

public interface IUserLoginView {

    //获取用户名和密码
    String getUserName();
    String getUserPassWord();

    //显示和隐藏进度条
    void showProgress();
    void hideProgress();

    //成功跳转到新页面,失败弹土司
    void toMainActivity(User user);
    void showFailedToast();

}
