package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Bridge Wang
 * @version 1.0
 * @date 2020/4/28 16:00
 */
@Component
public interface IMessageProvider {
    public String send();
}
