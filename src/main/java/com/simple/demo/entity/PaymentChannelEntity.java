package com.simple.demo.entity;

import lombok.Data;

@Data
public class PaymentChannelEntity {

    private Integer id;

    private String channelName;

    private String channelId;

    private String strategyBeanId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getStrategyBeanId() {
        return strategyBeanId;
    }

    public void setStrategyBeanId(String strategyBeanId) {
        this.strategyBeanId = strategyBeanId;
    }
}
