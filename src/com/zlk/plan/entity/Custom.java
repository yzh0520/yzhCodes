package com.zlk.plan.entity;

/**
 * @ClassName： Custom
 * @Description：客户实体类
 * @Author： yzh
 * @Date： 2019/9/17 10:39
 */

public class Custom {
    /*客户id*/
    private Integer cid;
    /*客户名称*/
    private String cname;
    /*客户全称*/
    private String crealname;
    /*地址*/
    private String caddress;
    /*传真*/
    private String cfax;
    /*邮箱*/
    private String cemail;
    /*经理姓名*/
    private String cadmin;
    /*电话*/
    private String cphone;
    /*客户状态*/
    private String cstate;
    /*备注*/
    private String cps;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCrealname() {
        return crealname;
    }

    public void setCrealname(String crealname) {
        this.crealname = crealname;
    }

    public String getCadmin() {
        return cadmin;
    }

    public void setCadmin(String cadmin) {
        this.cadmin = cadmin;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCfax() {
        return cfax;
    }

    public void setCfax(String cfax) {
        this.cfax = cfax;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    public String getCps() {
        return cps;
    }

    public void setCps(String cps) {
        this.cps = cps;
    }

    public Custom(Integer cid, String cname, String crealname, String caddress, String cfax, String cemail, String cadmin, String cphone, String cstate, String cps) {
        this.cid = cid;
        this.cname = cname;
        this.crealname = crealname;
        this.caddress = caddress;
        this.cfax = cfax;
        this.cemail = cemail;
        this.cadmin = cadmin;
        this.cphone = cphone;
        this.cstate = cstate;
        this.cps = cps;
    }

    public Custom() {
    }
}
