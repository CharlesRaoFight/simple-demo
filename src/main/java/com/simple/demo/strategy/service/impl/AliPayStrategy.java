package com.simple.demo.strategy.service.impl;

import com.simple.demo.strategy.service.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class AliPayStrategy  implements PayStrategy {

    @Override
    public String toPayHtml() {
        return "welcome to aliPay";
    }
}

