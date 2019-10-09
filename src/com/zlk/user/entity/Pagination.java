package com.zlk.user.entity;

/**
 * @ClassName： Pagination
 * @Description：分页封装
 * @Author： yzh
 * @Date： 2019/9/18 10:42
 */

public class Pagination {
    /**当前页*/
    private Integer page;
    /**每页显示的条数*/
    private Integer limit;
    /**起始页*/
    private Integer startPage;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Pagination(Integer page, Integer limit, Integer startPage) {
        this.page = page;
        this.limit = limit;
        this.startPage = startPage;
    }

    public Pagination() {
    }
}
