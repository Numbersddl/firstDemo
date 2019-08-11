package com.itheima.domain;

import java.io.Serializable;

public class Account implements Serializable {

    private Integer id;
    private String uid;
    private String money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
