package com.simple.demo.factory;

import com.simple.demo.PayEnumStrategy;
import com.simple.demo.strategy.service.PayStrategy;

public class PayFactory {

    public static PayStrategy getPayStrategy(String strategyType){
        try{
            PayEnumStrategy payEnumStrategy = PayEnumStrategy.valueOf(strategyType);
            String className = payEnumStrategy.getClassName();
            return (PayStrategy)Class.forName(className).newInstance();
        }catch (Exception e){
            return null;
        }
    }

}
