package com.danyanpi.bean;

import lombok.Data;

@Data
public class Goods {
  private Long id;
  private Long categoryid;
  private String bar;
  private String name;
  private Double delprice;
  private String content;
  private Long stock;
  private Long isdelete;
  private Long tradeprice;
  private String goodunit;

}
