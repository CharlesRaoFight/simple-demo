package com.simple.demo;

import org.apache.ibatis.javassist.bytecode.stackmap.TypeData;

/*
    策略枚举类 通过反射机制来构造bean
 */
public enum PayEnumStrategy {

    ALI_PAY("com.simple.demo.strategy.service.impl.AliPayStrategy"),

    WECAHT_PAY("com.simple.demo.strategy.service.impl.WeChatPayStrategy"),

    MI_PAY("com.simple.demo.strategy.service.impl.MiPayStrategy");

    PayEnumStrategy(String className) {
        this.setClassName(className);
    }

    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
