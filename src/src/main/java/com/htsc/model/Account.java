package com.htsc.model;

import java.io.Serializable;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/2
 */
public class Account implements Serializable {

    private Integer id;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    private Integer uid;
    private Double money;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
