package com.ssmdemon.rk.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by renkai on 2017/3/10.
 */
public class BookRecoud implements Serializable{
    private Long id;
    private Long userId;
    private Long bookId;
    private Date borrowTime;
    private Date backTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getBackTime() {
        return backTime;
    }

    public void setBackTime(Date backTime) {
        this.backTime = backTime;
    }
}
