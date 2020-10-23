package com.atguigu.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 * @author Bridge Wang
 * @version 1.0
 * @date 2020/5/1 10:26
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(4444, "Global customized by user---handlerException No.1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444, "Global customized by user---handlerException No.2");
    }
}
