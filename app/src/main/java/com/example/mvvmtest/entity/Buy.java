package com.example.mvvmtest.entity;

/**
 * @author dengmin
 * @description:
 * @date : 2020/6/17 10:43
 */
public class Buy {

    public String fund;
    public int percent;
    public String remark;

    public String getFund() {
        return fund;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
