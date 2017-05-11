package com.example.zengxianghui900.newtechnology.dagger2.presenter;

/**
 *
 */

public interface IUser {
    void login(String name,String password, OnLoginListener listener);
}
