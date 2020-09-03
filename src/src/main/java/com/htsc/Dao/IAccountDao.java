package com.htsc.Dao;

import com.htsc.model.AccountUser;
import com.htsc.model.User;

import java.util.List;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/2
 */
public interface IAccountDao {
    List<AccountUser> findAll1();
    List<User> findAll2();
}
