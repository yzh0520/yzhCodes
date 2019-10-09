package com.zlk.user.entity;

import java.util.Date;

/**
 * @ClassName： UserFunction
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/24 9:20
 */

public class UserFunction {
    //权限id
    private Integer funid;
    //权限名
    private String funname;
    //url
    private String url;
    //权限状态
    private String status;
    //创建人
    private String cteateuser;
    //创建时间
    private Date cteatetime;
    //父权限
    private Integer pid;

    public UserFunction(Integer funid, String funname, String url, String status, String cteateuser, Date cteatetime, Integer pid) {
        this.funid = funid;
        this.funname = funname;
        this.url = url;
        this.status = status;
        this.cteateuser = cteateuser;
        this.cteatetime = cteatetime;
        this.pid = pid;
    }

    public UserFunction() {
    }

    public Integer getFunid() {
        return funid;
    }

    public void setFunid(Integer funid) {
        this.funid = funid;
    }

    public String getFunname() {
        return funname;
    }

    public void setFunname(String funname) {
        this.funname = funname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCteateuser() {
        return cteateuser;
    }

    public void setCteateuser(String cteateuser) {
        this.cteateuser = cteateuser;
    }

    public Date getCteatetime() {
        return cteatetime;
    }

    public void setCteatetime(Date cteatetime) {
        this.cteatetime = cteatetime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
