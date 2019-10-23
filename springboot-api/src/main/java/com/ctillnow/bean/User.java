package com.ctillnow.bean;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by caiping on 2019/10/14.
 */

public class User implements Serializable{
    public String name ;

    @Min(value = 18,message = "未成年禁止")
    public String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public User(){

    }
}
