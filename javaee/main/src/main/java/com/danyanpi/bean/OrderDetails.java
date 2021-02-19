package com.danyanpi.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class OrderDetails {
  @Id
  @KeySql(useGeneratedKeys = true)
  private Integer id;
  private Integer goodsid;
  private Integer orderid;
  private Integer goodspecnum;
  @Column(name = "goodspecprice")
  private Double goodspecprice;
  @Column(name = "goodprice")
  private Double goodprice;

}
