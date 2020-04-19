package com.vava.ecommerse;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vava.ecommerse.dao.TestInsertDao;

@SpringBootTest
class EcommerseApplicationTests {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TestInsertDao testInsertDao;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    void testInsertAutoInc() {
        long begin = System.currentTimeMillis();
        int insertNum = 200000;
//        int insertNum = 10;
        for (int i = 0; i < insertNum; i++) {
            testInsertDao.insert_auto_inc();
        }
        System.out.println("insert auto inc cost: " + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < insertNum; i++) {
            testInsertDao.insert_uuid();
        }
        System.out.println("insert uuid cost: " + (System.currentTimeMillis() - begin));
    }

    @Test
    void testBigText() {
        System.out.println(TestInsertDao.bigText);
        System.out.println(TestInsertDao.bigText.length());
    }
}
