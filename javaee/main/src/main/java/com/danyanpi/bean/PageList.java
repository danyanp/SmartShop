package com.danyanpi.bean;

import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import java.util.List;

@Data
public class PageList<T> {

    @Ignore
    private Long totalCount = 0L;
    private Integer pageSize = 30;
    private Integer pageNo = 1;
    private Integer totalPage = 0;
    private List<T> data;

    public PageList(List<T> list) {
        PageInfo pageInfo = new PageInfo<>(list);
        this.totalCount = pageInfo.getTotal();
        this.pageSize = pageInfo.getPageSize();
        this.pageNo = pageInfo.getPageNum();
        this.totalPage = pageInfo.getPages();
        this.data = list;
    }
}