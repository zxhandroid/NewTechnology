package com.example.zengxianghui900.newtechnology.dagger2.module;

import android.os.Handler;

import com.example.zengxianghui900.newtechnology.dagger2.presenter.IUserImp;
import com.example.zengxianghui900.newtechnology.dagger2.presenter.IUserLoginView;
import com.example.zengxianghui900.newtechnology.dagger2.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zengxianghui900 on 17/5/9.
 */

@Module
public class LoginModule {
    private IUserLoginView mIUserLoginView;

    public LoginModule(IUserLoginView IUserLoginView) {
        mIUserLoginView = IUserLoginView;
    }

    @Provides
    IUserLoginView provideIUserLoginView() {
        return mIUserLoginView;
    }

    @Provides
    Handler provideHandler() {
        return new Handler();
    }

    //1.带参数的方法,里面的每一个参数必须有@Provides注解的provide方法提供实例化对象或相应类中构造方法被@Inject注解，否则会报错。
    //2.对于抽象类或接口，则可以通过构造方法传入，并通过provide()方法提供，如IUserLoginView。
    //3.由于LoginPresenter的构造中有接口参数，所以只能通过provide方法来提供实例化对象，不能直接在其构造方法中加@Inject注解，
    //原因很简单，因为抽象类或接口无法进行实例化，所以即便加上了@Inject注解在rebuild时也会报错。
    @Provides
    LoginPresenter provideLoginPresenter(IUserLoginView IUserLoginView, Handler handler, IUserImp iUserImp){
        return new LoginPresenter(IUserLoginView,handler,iUserImp);
    }
}
