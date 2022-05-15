package com.amei.knowledge;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalDemo {

//    @Autowired
//    JdbcTemplate jdbcTemplate;

    @Transactional
    public void parentMethods() {
        childOneMethods();
        childTwoMethods();
    }

    /**
     * 添加操作
     */
    @Transactional
    public void childOneMethods() {
//        jdbcTemplate.update("insert into  money values (222,'法外狂徒张三',100)");
//        jdbcTemplate.update("update  money set money = 102 where id = 222");
    }

    /**
     * 更改操作
     */
    @Transactional
    public void childTwoMethods()
    {
//        jdbcTemplate.update("update  money set money = 101 where id = 222");
    }


    @Transactional
    public  boolean create() {
        int i = 0;
        try {
            addPerson();
        } catch (Exception e) {
            System.out.println("不断程序，用来输出日志~");
        }
        return i == 1;
    }

    @Transactional
    public boolean addPerson() {
        System.out.println(1 / 0);
        return false;
    }

}
