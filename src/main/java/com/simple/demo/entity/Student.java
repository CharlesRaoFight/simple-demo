package com.simple.demo.entity;

/**
 * @Title:com.simple.demo.entity.Student
 * @Auther: Charles Rao
 * @Date: 2020/05/25/23:02
 * @Description:
 */
public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String attend(){
        return name+"同学已到达教室";
    }
}
