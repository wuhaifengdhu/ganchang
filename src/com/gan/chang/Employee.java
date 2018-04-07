package com.gan.chang;

public class Employee {
    protected String name;
    protected long id;
    protected String position;

    public Employee(String name, long id, String position){
        this.name = name;
        this.id = id;
        this.position = position;

        System.out.println(this.name + "今日已打卡！");
        System.out.println(this.name + "的工号是" + this.id + ", 他是" + this.position);
    }
}
