package com.simple.demo.mapper;


import com.simple.demo.entity.PaymentChannelEntity;
import org.apache.ibatis.annotations.Select;

public interface StrategyMapper {

     @Select("select id as id, channel_name as channelName,channel_id as channelId,strategy_bean_id as strategyBeanId from pay_channel where channel_id=#{payCode}")
    public PaymentChannelEntity getPaymentChannel(String payCode);


//    public static void main(String[] args) {
////       三次握手： client--->"sync","seq=x"--->server  --->"ack=x+1","seq=y"---->client --->"ack=y+1"--->Server
////        四次挥手 client--->release connection --->server-->wait-->--->ok-->client  ---->ack release
//
//
//
//
//    }
}
