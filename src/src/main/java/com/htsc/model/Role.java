package com.htsc.model;

import java.io.Serializable;
import java.util.List;

/**
 * 说明:
 *
 * @author zhanglin/016873
 * @version: V1.0.0
 * @update 2020/9/3
 */
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}
