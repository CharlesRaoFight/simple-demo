package com.simple.demo.strategy.service;

import com.simple.demo.entity.PaymentChannelEntity;
import com.simple.demo.mapper.StrategyMapper;
import com.simple.demo.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PayContextStrategy {

    @Autowired
    private SpringUtil springUtil;

    @Autowired
    private StrategyMapper strategyMapper;

    public String getPayHtml(String payCode){
        if(StringUtils.isEmpty(payCode)){
            return "支付编码不能为空!";
        }
        PaymentChannelEntity paymentChannelEntity = strategyMapper.getPaymentChannel(payCode);
        if(paymentChannelEntity == null){
            return "没有查询到支付渠道";
        }
        String strategyBeanId = paymentChannelEntity.getStrategyBeanId();
        if(StringUtils.isEmpty(strategyBeanId)){
            return "数据库没有配置相应的策略id";
        }
        PayStrategy payStrategy = springUtil.getBean(strategyBeanId, PayStrategy.class);
        return payStrategy.toPayHtml();
    }

}
