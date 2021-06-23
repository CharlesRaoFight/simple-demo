package com.simple.demo.spring.bean;

import com.simple.demo.spring.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Title: com.simple.demo.spring.bean.UserService
 * @Auther: Charles Rao
 * @Date: 2021/06/19/16:51
 * @Description:
 */
@Component
public class UserService implements BeanNameAware, BeanFactoryAware {
    @Autowired
    private User user;

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
