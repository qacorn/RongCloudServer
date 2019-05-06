package com.qacorn.rongcloud.result;

import java.util.List;

public class ResultList<T> {

    private Integer size;
    private Integer currentPage;
    private Integer pageSize;
    private List<T> resultList;

    public ResultList() {
    }

    public ResultList(List<T> resultList, Integer currentPage, Integer pageSize) {
        this.size = resultList.size();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.resultList = resultList;
    }

    public ResultList(Integer size, Integer currentPage, Integer pageSize, List<T> resultList) {
        this.size = size;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.resultList = resultList;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
