package com.cloth.spring.impl;

import com.cloth.spring.api.Cloth;
import com.cloth.spring.api.Collocation;
import com.cloth.spring.api.Rule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DressHelper {
    private List<Cloth> clothList;
    private List<Rule> ruleList;
    private Weather weather;

    public DressHelper(List<Cloth> clothList, List<Rule> ruleList, Weather weather){
        this.clothList = clothList;
        this.ruleList = ruleList;
        this.weather = weather;
    }

    public boolean dressOk(Collocation collocation){
        for(Rule rule: this.ruleList){
            if(! rule.pass(collocation)){

                return false;
            }
        }
        return true;
    }

    public void printAvailable(){
        List<CollocationImpl> collocationList = TraversalHelper.getTraversalList(this.clothList, weather);
        System.out.println("今日可搭配的套装有：");
        for(Collocation collocation: collocationList){
//            System.out.println("尝试搭配：" + collocation.toString());
            if(dressOk(collocation)){
                System.out.print(collocation.toString() + "；");
            }
        }
    }
}
