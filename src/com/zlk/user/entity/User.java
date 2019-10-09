package com.zlk.user.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName： User
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/24 9:19
 */

public class User {
    //用户ID
    private Integer uid;
    //用户名
    private String name;
    //密码
    private String pwd;
    //用户电话
    private String phone;
    //身份证号
    private String card;
    //省份
    private String provice;
    //城市
    private String city;
    //地区
    private String area;
    //地址
    private String address;
    //用户状态
    private String status;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    //创建人
    private String createuser;
    //修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatetime;
    //修改人
    private String updateuser;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    public User(Integer uid, String name, String pwd, String phone, String card, String provice, String city, String area, String address, String status, Date createtime, String createuser, Date updatetime, String updateuser) {
        this.uid = uid;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.card = card;
        this.provice = provice;
        this.city = city;
        this.area = area;
        this.address = address;
        this.status = status;
        this.createtime = createtime;
        this.createuser = createuser;
        this.updatetime = updatetime;
        this.updateuser = updateuser;
    }

    public User() {
    }

}
