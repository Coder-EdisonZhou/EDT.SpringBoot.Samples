package com.manulife.msadv5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateDataSourcesTest {
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcPrimaryTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcSecondaryTemplate;

    @Before
    public void setUp(){
        jdbcPrimaryTemplate.update("DELETE FROM USER ");
        jdbcSecondaryTemplate.update("DELETE FROM USER ");
    }

    @Test
    public void testDataSources() throws Exception{
        // 01.向第一个数据源插入两条数据
        jdbcPrimaryTemplate.update("INSERT INTO User(name,age) VALUES(?,?)", "Edison", 29);
        jdbcPrimaryTemplate.update("INSERT INTO User(name,age) VALUES(?,?)", "Andy", 30);

        // 02.向第二个数据源插入一条数据，若插入的是第一个数据源，则会主键冲突
        jdbcSecondaryTemplate.update("INSERT INTO User(name,age) VALUES(?,?)", "Edison", 29);

        // 03.查询第一个数据源中是否有两条数据，验证插入是否成功
        Assert.assertEquals("2", jdbcPrimaryTemplate.queryForObject("SELECT COUNT(1) FROM User", String.class));

        // 04.查询第二个数据源中是否有两条数据，验证插入是否成功
        Assert.assertEquals("1", jdbcSecondaryTemplate.queryForObject("SELECT COUNT(1) FROM User", String.class));
    }
}
