package com.simple.demo.utils;

import org.apache.ibatis.io.ResolverUtil;

import java.util.Collection;
import java.util.Hashtable;

/**
 * @Title:com.simple.demo.utils.A
 * @Auther: Charles Rao
 * @Date: 2020/08/02/23:27
 * @Description:
 */
public class A  extends B{

    public static int a = 1;

    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,"");
      int a = 10;
      a++;
     A.a++;
    A T = new A();
        System.out.println("a="+a+"t.a="+A.a);
    }

}
