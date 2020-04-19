package com.vava.ecommerse.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Steve
 * Created on 2020-04
 */
@Repository
public class BuyDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String buy(String id) {
        return id;
    }

    public Map<String, Object> query(String id) {
        List<Map<String, Object>> maps =
                jdbcTemplate.queryForList("select * from products where id = ?", new Object[] {id});
        return maps.get(0);
    }
}
