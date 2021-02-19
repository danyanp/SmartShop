package com.smartshop.danyanpi.smartshop.bean;



public class Goods {

    private int goodsid;
    private String goodsname;
    private int categoryid;
    private int bar;
    private int stock;
    private double purprice;
    private double delprice;
    private String remarks;

    public Goods(){}
    public Goods(int goodsid, String goodsname, int categoryid, int bar, int stock, double purprice, double delprice, String remarks) {
        this.goodsid = goodsid;
        this.goodsname = goodsname;
        this.categoryid = categoryid;
        this.bar = bar;
        this.stock = stock;
        this.purprice = purprice;
        this.delprice = delprice;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsid=" + goodsid +
                ", goodsname='" + goodsname + '\'' +
                ", categoryid=" + categoryid +
                ", bar=" + bar +
                ", stock=" + stock +
                ", purprice=" + purprice +
                ", delprice=" + delprice +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPurprice() {
        return purprice;
    }

    public void setPurprice(double purprice) {
        this.purprice = purprice;
    }

    public double getDelprice() {
        return delprice;
    }

    public void setDelprice(double delprice) {
        this.delprice = delprice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
