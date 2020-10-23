package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Bridge Wang
 * @version 1.0
 * @date 2020/4/25 15:20
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----- PaymentFallbackService fallback-PaymentInfo_OK , TxT";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---- PaymentFallbackService fall back-paymentInfo_TimeOut , TxT";
    }
}
