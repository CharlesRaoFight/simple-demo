package com.simple.demo.proxy;

/**
 * @Title:com.simple.demo.proxy.TargetServiceImpl
 * @Auther: Charles Rao
 * @Date: 2020/05/19/20:52
 * @Description:
 */
public class TargetServiceImpl implements TargetService {
    @Override
    public String getName() {
        return "Charles Rao";
    }
}
