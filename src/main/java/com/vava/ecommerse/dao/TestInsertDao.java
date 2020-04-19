package com.vava.ecommerse.dao;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Steve
 * Created on 2020-04
 */
@Repository
public class TestInsertDao {
    public static String bigText;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    static {
        bigText = "测试";
        for (int i = 0; i < 12; i++) {
            bigText += bigText;
        }
    }

    public int insert_auto_inc() {
        return jdbcTemplate.update(
                "INSERT INTO auto_inc_pk (name) VALUES (?)",
                bigText
        );
    }

    public int insert_uuid() {
        return jdbcTemplate.update(
                "INSERT INTO uuid_pk (id, name) VALUES (?, ?)",
                UUID.randomUUID().toString(), bigText
        );
    }


}
