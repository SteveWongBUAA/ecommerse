package com.vava.ecommerse.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vava.ecommerse.dao.BuyDao;

/**
 * @author Steve
 * Created on 2020-04
 */
@Service
public class BuyService {
    @Autowired
    private BuyDao buyDao;

    public String buy(String id) {
        return buyDao.buy(id);
    }

    public Map<String, Object> query(String id) {
        return buyDao.query(id);
    }
}
