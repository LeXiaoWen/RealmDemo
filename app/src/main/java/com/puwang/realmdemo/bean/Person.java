package com.puwang.realmdemo.bean;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmModule;

/**
 * Created by Leo on 2017/3/31.
 */

public class Person extends RealmObject {
    private String name;
    @PrimaryKey
    private String id;
    private int age;
    private RealmList<Job> job;

    public RealmList<Job> getJob() {
        return job;
    }

    public void setJob(RealmList<Job> job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", mJobs=" +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
