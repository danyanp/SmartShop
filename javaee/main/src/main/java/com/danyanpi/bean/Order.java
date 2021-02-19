package com.danyanpi.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

@Data
public class Order {
  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;
  private String time;
  private Double totalprice;
  private Integer Shopid;

}
