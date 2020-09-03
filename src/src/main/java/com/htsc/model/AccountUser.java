package com.htsc.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/2
 */
public class AccountUser implements Serializable {
    private Integer id;
    private Account account;
    private User user;

    public AccountUser() {
        this.account = new Account();
        this.user = new User();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    // Account properties setter and getter
    public Integer getUid() {
        return account.getUid();
    }

    public void setUid(Integer uid) {
        account.setUid(uid);
    }

    public Double getMoney() {
        return account.getMoney();
    }

    public void setMoney(Double money) {
        account.setMoney(money);
    }

    // User properties getter and setter
    public String getUsername() {
        return user.getUserName();
    }

    public void setUsername(String username) {
        user.setUserName(username);
    }

    public Date getBirthday() {
        return user.getUserBirthday();
    }

    public void setBirthday(Date birthday) {
        user.setUserBirthday(birthday);
    }

    public String getSex() {
        return user.getUserSex();
    }

    public void setSex(String sex) {
        user.setUserSex(sex);
    }

    public String getAddress() {
        return user.getUserAddress();
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", account=" + account +
                ", user=" + user +
                '}';
    }

    public void setAddress(String address) {
        user.setUserAddress(address);
    }

}