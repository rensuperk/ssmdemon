package com.ssmdemon.rk.model;

import java.io.Serializable;

/**
 * Created by renkai on 2017/3/8.
 */
public class Book implements Serializable{
    private Long id;
    private String name;
    private Double price;
    private Boolean borrowFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getBorrowFlag() {
        return borrowFlag;
    }

    public void setBorrowFlag(Boolean borrowFlag) {
        this.borrowFlag = borrowFlag;
    }
}
