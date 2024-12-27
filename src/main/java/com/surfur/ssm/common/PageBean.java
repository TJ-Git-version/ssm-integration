package com.surfur.ssm.common;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {

    private Integer currentPage;
    private Integer pageSize;

    private Long total;

    private List<T> dataList;

    public static <T> PageBean<T> build(Integer currentPage, Integer pageSize, Long total, List<T> dataList) {
        return new PageBean<>(currentPage, pageSize, total, dataList);
    }

    public PageBean() {
    }

    public PageBean(Integer currentPage, Integer pageSize, Long total, List<T> dataList) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.dataList = dataList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
