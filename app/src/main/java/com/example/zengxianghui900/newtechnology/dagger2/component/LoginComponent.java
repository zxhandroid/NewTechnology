package com.example.zengxianghui900.newtechnology.dagger2.component;

import com.example.zengxianghui900.newtechnology.dagger2.module.IUserImpModule;
import com.example.zengxianghui900.newtechnology.dagger2.module.LoginModule;
import com.example.zengxianghui900.newtechnology.dagger2.module.UserModule;
import com.example.zengxianghui900.newtechnology.dagger2.ui.LoginActivity;

import dagger.Component;

/**
 * Created by zengxianghui900 on 17/5/9.
 * 由于LoginPresenter对象实例化需要同时实例化User和IUserImp对象,因此modules要依赖这三个
 */
@Component(modules = {UserModule.class,IUserImpModule.class,LoginModule.class})
public interface LoginComponent {

    //提供方法注入到LoginActivity目标类中
    void injectLoginActivity(LoginActivity loginActivity);

}
