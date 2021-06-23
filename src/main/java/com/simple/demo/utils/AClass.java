package com.simple.demo.utils;


import jdk.Exported;

import java.util.*;

/**
 * @Title:com.simple.demo.utils.AClass
 * @Auther: Charles Rao
 * @Date: 2020/06/28/19:07
 * @Description:
 */
public class AClass  {
    public static void main(String[] args) {

        new HashSet();
        Object obj = new Object();
        int i = obj.hashCode();
        obj.equals(new Object());
        List<String> linkedList = new LinkedList<>();
        List<String> arrayList = new ArrayList<>(0);
        arrayList.add("123");
        System.out.println(arrayList.size());

//        String x = "5";
//        String a = "012345";
//        String c = a.substring(5);
//        System.out.println(x == c);
//        System.out.println(a.substring(5));
//        int i = 0 ;
//        for(fun1("A"); i <1 ; fun1("B")){
//            i++;
//            fun1("C");
//        }


//        Scanner scanner = new Scanner(System.in);
//        String str1=scanner.nextLine();
//        String str2=scanner.nextLine();
//        System.out.println(change(str1,str2));

    }

    public static void fun1(String str){
        System.out.println(str);
    }


    public static String change(String str1 ,String str2){
        char[] str1Arr = str1.toCharArray();
        StringBuffer newStr = new StringBuffer();
        for(char c : str1Arr){
            if(!str2.contains(c+"")){
                newStr.append(c+"");
            }
        }
        return newStr.toString();
    }

}

//split(6),split(3),split(2),split(1),  1-1