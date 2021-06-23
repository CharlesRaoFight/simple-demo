package com.simple.demo.test;

import com.simple.demo.proxy.JdkProxy;
import com.simple.demo.proxy.TargetService;
import com.simple.demo.proxy.TargetServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;


public class mytest {

    public static void main(String[] args) {
//        Thread myThread = new Thread(() -> {
//            LockSupport.park();
//        }, "myThread");
//        myThread.start()
//        LockSupport.unpark(myThread);





    }

    private static int  getValue() {
        int i = 1;
        switch (i){
            case 1 :
                break;
        }
        try{
            i=4;
        }finally {
            i++;
            return i;
        }
    }
}
