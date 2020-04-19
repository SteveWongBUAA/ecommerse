package com.vava.ecommerse.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vava.ecommerse.service.BuyService;

/**
 * @author Steve
 * Created on 2020-04
 */
@RestController
@RequestMapping("/api")
public class BuyController {
    private ConcurrentHashMap<String, String> concurrentHashMap;
    static ReentrantLock reentrantLock = new ReentrantLock();
    private static Logger logger = LoggerFactory.getLogger(BuyController.class);

    @Autowired
    private BuyService buyService;

    @GetMapping("/buy")
    public String buy(String id) throws InterruptedException {
        reentrantLock.lock();
        logger.info("buy request id = {}", id);
        Thread.sleep(10000);
        reentrantLock.unlock();
        return buyService.buy(id);
    }

    @ResponseBody
    @GetMapping("query")
    public Map<String, Object> query(String id) {
        return buyService.query(id);
    }
}
