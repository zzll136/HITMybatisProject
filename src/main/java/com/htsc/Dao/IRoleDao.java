package com.htsc.Dao;
import com.htsc.model.Role;
import java.util.List;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/3
 */
public interface IRoleDao {
    List<Role> findAll();
}
