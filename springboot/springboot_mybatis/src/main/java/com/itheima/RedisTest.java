package com.itheima;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class RedisTest {

    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void Test(){
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();

        if(null == userListJson){
            //没有 手动调用

            //然后存入redis中

            //转换格式(JSON格式)存入redis中
            redisTemplate.boundValueOps("user.findAll").set(userListJson);
        }
    }
}
