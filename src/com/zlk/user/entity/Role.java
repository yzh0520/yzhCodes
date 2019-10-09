package com.zlk.user.entity;

import java.util.Date;

/**
 * @ClassName： Role
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/24 9:19
 */

public class Role {
    //角色ID
    private Integer rid;
    //角色名
    private String rolename;
    //创建人
    private String cteateuser;
    //创建时间
    private Date createtime;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getCteateuser() {
        return cteateuser;
    }

    public void setCteateuser(String cteateuser) {
        this.cteateuser = cteateuser;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Role(Integer rid, String rolename, String cteateuser, Date createtime) {
        this.rid = rid;
        this.rolename = rolename;
        this.cteateuser = cteateuser;
        this.createtime = createtime;
    }

    public Role() {
    }
}
