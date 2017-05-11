package com.example.zengxianghui900.newtechnology.dagger2.module;

import com.example.zengxianghui900.newtechnology.dagger2.bean.User;
import com.example.zengxianghui900.newtechnology.dagger2.presenter.IUserImp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zengxianghui900 on 17/5/9.
 */
@Module
public class IUserImpModule {
    //这里通过@Provides,提供了User实例化对象的方法,如果这边不提供provideIUserImp(User user)方法
    //则用@Inject 对IUserImp类的构造方法注解，否则会报错，
    //具体报错及原因可查看以下链接：
    //http://blog.csdn.net/zxhandroid/article/details/70677260
    @Provides
    IUserImp provideIUserImp(User user){
        return new IUserImp(user);
    }
}
