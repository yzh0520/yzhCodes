package com.zlk.plan.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName： Orders
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/19 16:08
 */

public class Orders {
    //订单编号
    private Integer oid;
    //订购客户
    private String ocname;
    //订购产品
    private String opname;
    //订购数量
    private Integer onum;
    //税前单价
    private Double oprice;
    //产品单位
    private String ounit;
    //订单状态
    private String ostate;
    //订购日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ocreatetime;
    //要求日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ofinishtime;
    //订单要求
    private String ops;
    //相关照片
    private String oimg;
    //照片虚拟路径
    private String orealimg;
    //订单附件
    private String oacr;

    private String orealacr;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOcname() {
        return ocname;
    }

    public void setOcname(String ocname) {
        this.ocname = ocname;
    }

    public String getOpname() {
        return opname;
    }

    public void setOpname(String opname) {
        this.opname = opname;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public String getOunit() {
        return ounit;
    }

    public void setOunit(String ounit) {
        this.ounit = ounit;
    }

    public String getOstate() {
        return ostate;
    }

    public void setOstate(String ostate) {
        this.ostate = ostate;
    }

    public Date getOcreatetime() {
        return ocreatetime;
    }

    public void setOcreatetime(Date ocreatetime) {
        this.ocreatetime = ocreatetime;
    }

    public Date getOfinishtime() {
        return ofinishtime;
    }

    public void setOfinishtime(Date ofinishtime) {
        this.ofinishtime = ofinishtime;
    }

    public String getOps() {
        return ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public String getOimg() {
        return oimg;
    }

    public void setOimg(String oimg) {
        this.oimg = oimg;
    }

    public String getOacr() {
        return oacr;
    }

    public void setOacr(String oacr) {
        this.oacr = oacr;
    }

    public String getOrealimg() {
        return orealimg;
    }

    public void setOrealimg(String orealimg) {
        this.orealimg = orealimg;
    }

    public String getOrealacr() {
        return orealacr;
    }

    public Orders(Integer oid, String ocname, String opname, Integer onum, Double oprice, String ounit, String ostate, Date ocreatetime, Date ofinishtime, String ops, String oimg, String orealimg, String oacr, String orealacr) {
        this.oid = oid;
        this.ocname = ocname;
        this.opname = opname;
        this.onum = onum;
        this.oprice = oprice;
        this.ounit = ounit;
        this.ostate = ostate;
        this.ocreatetime = ocreatetime;
        this.ofinishtime = ofinishtime;
        this.ops = ops;
        this.oimg = oimg;
        this.orealimg = orealimg;
        this.oacr = oacr;
        this.orealacr = orealacr;
    }

    public void setOrealacr(String orealacr) {
        this.orealacr = orealacr;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", ocname='" + ocname + '\'' +
                ", opname='" + opname + '\'' +
                ", onum=" + onum +
                ", oprice=" + oprice +
                ", ounit='" + ounit + '\'' +
                ", ostate='" + ostate + '\'' +
                ", ocreatetime=" + ocreatetime +
                ", ofinishtime=" + ofinishtime +
                ", ops='" + ops + '\'' +
                ", oimg='" + oimg + '\'' +
                ", orealimg='" + orealimg + '\'' +
                ", oacr='" + oacr + '\'' +
                ", orealacr='" + orealacr + '\'' +
                '}';
    }
}
