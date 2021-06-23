package com.simple.demo.entity;

/**
 * @Title:com.simple.demo.entity.Teacher
 * @Auther: Charles Rao
 * @Date: 2020/05/25/23:01
 * @Description:
 */
public class Teacher {

    private String  name;

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String attend(){
        return name+"老师已到达教室";
    }

}
