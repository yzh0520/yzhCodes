package com.zlk.user.entity;

/**
 * @ClassName： UserRole
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/25 11:35
 */

public class UserRole {
    private Integer userRoleId;
    private Integer userId;
    private Integer roleId;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public UserRole(Integer userRoleId, Integer userId, Integer roleId) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRole() {
    }
}
