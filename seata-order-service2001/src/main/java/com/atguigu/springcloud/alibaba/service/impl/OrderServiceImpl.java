package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Bridge Wang
 * @version 1.0
 * @date 2020/5/1 21:39
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "learn-create-order", rollbackFor = Exception.class)
    public void Create(Order order) {
        log.info("----->starting creating order<--------");
        orderDao.create(order);
        log.info("----->order service beginning to call StorageService, minus count<-------");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->order service called StorageService, minus ended.<------");
        log.info("----->order service beginning to call AccountService, minus money.<------");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->order service called AccountService, minus ended.<------");

        log.info("----->starting modifying order<--------");
        orderDao.update(order.getUserId(), 0);
        log.info("----->modifying order ended<--------");

        log.info("----->ALL HAVE BEEN DONE!<------");


    }
}
