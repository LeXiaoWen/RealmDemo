package com.puwang.realmdemo.bean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Leo on 2017/3/31.
 */

public class Job extends RealmObject{
    private String jobName;
    @PrimaryKey
    private String money;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }



    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
