package com.simple.demo.controller;

import com.simple.demo.factory.PayFactory;
import com.simple.demo.mapper.StrategyMapper;
import com.simple.demo.strategy.service.PayContextStrategy;
import com.simple.demo.strategy.service.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PayController {

    @Autowired
    private PayContextStrategy payContextStrategy;

    @RequestMapping(value ="/getPayHtml",method = RequestMethod.GET)
    public String getPayHtml(String type){
        if(StringUtils.isEmpty(type)){
            return "传入type不能为空";
        }
        PayStrategy payStrategy = PayFactory.getPayStrategy(type);
        if(payStrategy == null ){
            return "未找到支付方式";
        }
        return payStrategy.toPayHtml();
    }

    @RequestMapping(value ="/getPayHtml2",method = RequestMethod.GET)
    public String getPayHtml2(String type){
        return payContextStrategy.getPayHtml(type);
    }

    public static void main(String[] args) {
        Map map = new HashMap<>(1);
        map.put("123", "2");
        map.put("12", "2");
        System.out.println(map.size());
        System.out.println(Integer.highestOneBit(10));
    }


}
