package com.qfedu.pojo;

public class RecInfo {
    private Integer id;

    private Integer uid;

    private String name;

    private Integer tel;

    private Integer proid;
    private String proname;

    private Integer cityid;


    private String cityname;

    private Integer counyid;
    private String counyname;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    private String detail;

    private Integer flag;

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCounyname() {
        return counyname;
    }

    public void setCounyname(String counyname) {
        this.counyname = counyname;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public Integer getProid() {
        return proid;
    }

    public void setProid(Integer proid) {
        this.proid = proid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getCounyid() {
        return counyid;
    }

    public void setCounyid(Integer counyid) {
        this.counyid = counyid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    @Override
    public String toString() {
        return "姓名: " + name +
                "电话: " + tel +" "+ proname +
                "省" + cityname +
                "市" + counyname +
                "县/区 " + detail;
    }
}