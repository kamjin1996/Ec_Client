package com.qfedu.pojo;

public class CartItem {
    private Integer id;

    private Integer gid;

    private Goods goods;

    private Integer count;

    private Integer cartid;

    private String createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", gid=" + gid +
                ", goods=" + goods +
                ", count=" + count +
                ", cartid=" + cartid +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}