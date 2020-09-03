package com.htsc.Dao;

import com.htsc.model.QueryVo;
import com.htsc.model.QueryVoIds;
import com.htsc.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/2
 */
public interface IUserDao {
    List<User> findAll();
    User findById(Integer userId);
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userId);
    List<User> findByName(String username);
    List<User> findByNameNew(String username);
    int count();


    List<User> findByVo(QueryVo queryVo);
    //动态sql标签，if
    List<User> QueryByVo1(QueryVo queryVo);
    //动态sql标签，where
    List<User> QueryByVo2(QueryVo queryVo);
   //动态sql标签，foreach
    List<User> findInIds(QueryVoIds queryVoIds);
}
