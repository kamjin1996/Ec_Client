package com.qfedu.pojo;

import java.util.Date;
import java.util.Objects;

public class Order {
    private Integer id;

    private Integer rid;
    private RecInfo recInfo;

    public RecInfo getRecInfo() {
        return recInfo;
    }

    public void setRecInfo(RecInfo recInfo) {
        this.recInfo = recInfo;
    }

    private Integer money;

    private Date createtime;

    private Integer uid;

    private int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}