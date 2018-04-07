package com.gan.chang;

public class Developer extends Employee{

    public Developer(String name, long id){
        super(name, id, "开发工程狮");
        System.out.println("他会写代码");
    }
}
