package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.io.InputStream;

public class MybatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Test
    public void testFindAll() throws Exception{
        List<Account> accounts = accountDao.findAll();
        for(Account account:accounts) {
            System.out.print(account);
        }
        destroy();
    }

    @Before
    public void init() throws Exception{
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //使用SqlSession创建Dao接口的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);//通过字节码生成代理对象
    }

    @After
    public void destroy() throws Exception{
        //释放方法
        sqlSession.close();
        in.close();
    }
}
