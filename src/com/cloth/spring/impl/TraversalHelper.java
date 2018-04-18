package com.cloth.spring.impl;

import com.cloth.spring.api.Cloth;
import com.cloth.spring.api.Collocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraversalHelper {
    public static List<CollocationImpl> getTraversalList(List<Cloth> clothList, Weather weather){
        List<CollocationImpl> collocationList = new ArrayList<>();
        List<CollocationImpl> coTempList = new ArrayList<>();

        // 有生于无
        collocationList.add(new CollocationImpl(new ArrayList<>(), weather));
        for(int i = 0; i < clothList.size(); i++){
            // 每加一件衣服，里面的数目翻倍
            coTempList = new ArrayList<>(collocationList);
            for(CollocationImpl collocation: coTempList){
                List<Cloth> clothListTemp = new ArrayList<>(collocation.getClothList());
                clothListTemp.add(clothList.get(i));
                collocationList.add(new CollocationImpl(clothListTemp, weather));
            }
        }
//        for(CollocationImpl collocation: collocationList){
//            System.out.println(collocation.toString());
//        }
        return collocationList;
    }

    public static void main(String[] args){
        List<Cloth> clothList = new ArrayList<>();
        clothList.add(new Coat(18, 30, "薄外套"));
        clothList.add(new Coat(10, 19, "厚外套"));
        clothList.add(new Underwear(26, 35, "T恤"));
        clothList.add(new Underwear(10, 26, "长袖"));
        clothList.add(new Sweater(20, 25, "卫衣"));
        Weather weather = new Weather(20, 25);
        TraversalHelper.getTraversalList(clothList, weather);
    }


}
