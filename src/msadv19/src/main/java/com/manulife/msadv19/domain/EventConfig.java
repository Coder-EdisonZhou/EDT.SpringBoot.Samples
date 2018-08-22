package com.manulife.msadv19.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/*
 * 下面通过注解的方式配置，省去了原来事件监听器中各种if的判断，使得代码显得更为简洁，拥有了更好的可读性。
 */
@WithStateMachine
public class EventConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @OnTransition(target = "UNPAID")
    public void create(){
        logger.info("订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "WAITTING_FOR_RECEIVE")
    public void pay(){
        logger.info("用户完成支付，待收货");
    }

    @OnTransitionStart(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payStart() {
        logger.info("用户完成支付，待收货: start");
    }

    @OnTransitionEnd(source = "UNPAID", target = "WAITING_FOR_RECEIVE")
    public void payEnd() {
        logger.info("用户完成支付，待收货: end");
    }

    @OnTransition(source = "WAITTING_FOR_RECEIVE", target = "DONE")
    public void receive(){
        logger.info("用户已收货，订单完成");
    }
}
