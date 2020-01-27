package com.luizleiteoliveira.restControllerTest.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Stock {
    private Date date;
    private String code;
    private BigDecimal value;

    public Stock(Date date, String code, BigDecimal value) {
        this.date = date;
        this.code = code;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
