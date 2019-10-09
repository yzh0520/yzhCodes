package com.zlk.user.entity;

/**
 * @ClassName： RoleFunction
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/25 11:37
 */

public class RoleFunction {
        private Integer roleFunId;
        //角色ID
        private Integer roleId;
        //权限ID
        private Integer functionId;
        //权限状态
        private String status;

    public Integer getRoleFunId() {
        return roleFunId;
    }

    public void setRoleFunId(Integer roleFunId) {
        this.roleFunId = roleFunId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
