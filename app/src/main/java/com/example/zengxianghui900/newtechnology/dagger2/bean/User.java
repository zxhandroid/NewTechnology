package com.example.zengxianghui900.newtechnology.dagger2.bean;

import java.io.Serializable;

/**
 * Created by zengxianghui900 on 17/5/9.
 */

public class User implements Serializable{
    private String name;
    private String passWord;

//    @Inject       UserModule中不提供provide方法的话，在构造方法上加上这个注解即可
    public User() {
    }

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
