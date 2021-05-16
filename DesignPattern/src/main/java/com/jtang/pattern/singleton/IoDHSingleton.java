/*
 *  Copyright 2017 Quest Software Inc.
 *
 * ALL RIGHTS RESERVED.
 */

package com.jtang.pattern.singleton;

import java.net.URLDecoder;

/**
 * Created by jtang on 6/7/2017.
 */
public class IoDHSingleton {
    private IoDHSingleton(){}

    private static class HolderClass{
        private final static IoDHSingleton instance = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance(){
        return HolderClass.instance;
    }

    public static void main(String args[]){
        IoDHSingleton s1, s2;
        s1 = IoDHSingleton.getInstance();
        s2 = IoDHSingleton.getInstance();
        System.out.println(s1 == s2);



        String fragment = "http://fglusage.quest.com/list-payload?id=0c080c12-b836-4b6d-897c-9b2e7903f396&c=75&d=item%2848%29,item%2839%29,sub-item-58-0%3Asub-item-58-1%3Asub-item-58-2%3Asub-item-58-3%3Asub-item-58-4,item%2811%29,item%286%29,item%2819%29,item%282%29,item%2844%29,item%2830%29,item%2815%29,sub-item-68-0%3Asub-item-68-1%3Asub-item-68-2%3Asub-item-68-3%3Asub-item-68-4,sub-item-55-0%3Asub-item-55-1%3Asub-item-55-2%3Asub-item-55-3%3Asub-item-55-4,item%2841%29,item%2825%29,item%2829%29,item%2835%29,item%2821%29,sub-item-72-0%3Asub-item-72-1%3Asub-item-72-2%3Asub-item-72-3%3Asub-item-72-4,sub-item-59-0%3Asub-item-59-1%3Asub-item-59-2%3Asub-item-59-3%3Asub-item-59-4,sub-item-51-0%3Asub-item-51-1%3Asub-item-51-2%3Asub-item-51-3%3Asub-item-51-4,item%2810%29,sub-item-64-0%3Asub-item-64-1%3Asub-item-64-2%3Asub-item-64-3%3Asub-item-64-4,item%2838%29,sub-item-56-0%3Asub-item-56-1%3Asub-item-56-2%3Asub-item-56-3%3Asub-item-56-4,item%285%29,item%281%29,item%2845%29,item%2818%29,sub-item-73-0%3Asub-item-73-1%3Asub-item-73-2%3Asub-item-73-3%3Asub-item-73-4,sub-item-52-0%3Asub-item-52-1%3Asub-item-52-2%3Asub-item-52-3%3Asub-item-52-4,item%2814%29,sub-item-74-0%3Asub-item-74-1%3Asub-item-74-2%3Asub-item-74-3%3Asub-item-74-4,item%2831%29,sub-item-70-0%3Asub-item-70-1%3Asub-item-70-2%3Asub-item-70-3%3Asub-item-70-4,item%2824%29,item%289%29,item%2828%29,sub-item-60-0%3Asub-item-60-1%3Asub-item-60-2%3Asub-item-60-3%3Asub-item-60-4,sub-item-57-0%3Asub-item-57-1%3Asub-item-57-2%3Asub-item-57-3%3Asub-item-57-4,item%2834%29,sub-item-62-0%3Asub-item-62-1%3Asub-item-62-2%3Asub-item-62-3%3Asub-item-62-4,item%2849%29,item%2820%29,item%2840%29,item%284%29,item%2813%29,item%2827%29,sub-item-71-0%3Asub-item-71-1%3Asub-item-71-2%3Asub-item-71-3%3Asub-item-71-4,item%280%29,item%2817%29,item%2846%29,sub-item-54-0%3Asub-item-54-1%3Asub-item-54-2%3Asub-item-54-3%3Asub-item-54-4,sub-item-53-0%3Asub-item-53-1%3Asub-item-53-2%3Asub-item-53-3%3Asub-item-53-4,item%2843%29,item%288%29,item%2833%29,item%2837%29,item%2823%29";

        System.out.println(URLDecoder.decode(fragment));
    }
}
