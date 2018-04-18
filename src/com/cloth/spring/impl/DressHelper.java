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
        List<Collocation> collocationList = TraversalHelper.getTraversalList(this.clothList);
        System.out.println("今日可搭配的套装有：");
        for(Collocation collocation: collocationList){
            if(dressOk(collocation)){
                System.out.print(collocation.toString());
            }
        }
    }


    public final static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        System.out.println("输入最低温度:");
        float lowTemp = Float.valueOf(br.readLine());
        System.out.println("输入最高温度：");
        float highTemp = Float.valueOf(br.readLine());

        if(lowTemp < 10 || highTemp > 30){
            System.out.println("只提供10-30摄氏度的穿衣搭配");
            return;
        }

        if(lowTemp * 10 != lowTemp || highTemp * 10 != highTemp){
            System.out.println("请输入整数或者小数后一位");
            return;
        }

        Weather weather = new Weather(lowTemp, highTemp);

        List<Cloth> clothList = new ArrayList<>();
        clothList.add(new Coat(18, 30, "薄外套"));
        clothList.add(new Coat(10, 19, "厚外套"));
        clothList.add(new Underwear(26, 35, "T恤"));
        clothList.add(new Underwear(10, 26, "长袖"));
        clothList.add(new Sweater(20, 25, "卫衣"));
        List<Rule> ruleList = new ArrayList<>();
        ruleList.add(new Rule() { // 基本规则：衣服支持的温度范围必须包含天气的范围
            @Override
            public boolean pass(Collocation collocation) {
                return collocation.getClothSupportMaxTemp() > collocation.getWeatherMaxTemp() &&
                        collocation.getClothSupportMinTemp() < collocation.getWeatherMinTemp();
            }
        });
        ruleList.add(new Rule() { // 规则1：如果穿外套，必须穿打底衫
            @Override
            public boolean pass(Collocation collocation) {
                if(collocation.getCoatNum() > 0 && collocation.getInnerwearNum() < 1){ //如果穿外套
                    return false; //如果穿外套, 没有穿打底衫或者卫衣
                }
                return true;
            }
        });
        ruleList.add(new Rule() { // 规则2：一个套装内，只能存在单件底衫或外套
            @Override
            public boolean pass(Collocation collocation) {
                if(collocation.getCoatNum() <=1 && collocation.getUnderwearNum() <=1){
                    return true;
                }
                return false;
            }
        });
        ruleList.add(new Rule() { // 规则3：温差超过10度必须搭配两件衣服
            @Override
            public boolean pass(Collocation collocation) {
                if(collocation.getWeatherTempDifference() >= 10 && collocation.getClothNum() < 2){
                    return false; // 如果温差大于10，衣服数目少于2件，返回false
                }
                return true;
            }
        });


        DressHelper dressHelper = new DressHelper(clothList, ruleList, weather);
    }


}
