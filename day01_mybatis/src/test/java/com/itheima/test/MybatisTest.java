package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
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
    private IUserDao userDao;

//    public static void main(String[] args) throws Exception {
//        //使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for(User user:users) {
//            System.out.print(user);
//        }
//    }
    @Test
    public void testFindAll() throws Exception{
        List<User> users = userDao.findAll();
        for(User user:users) {
            System.out.print(user);
        }
        destroy();
    }

    @Test
    public void testSave() throws Exception{
        User user = new User();
        user.setLast_name("lastName");
        user.setGender("gender");
        user.setEmail("email");
        //使用代理对象执行方法
        userDao.saveUser(user);
        System.out.print(user);
        sqlSession.commit();
        destroy();
    }

    @Test
    public void testUpdate() throws Exception{
        User user = new User();
        user.setId(3);
        user.setLast_name("lastName_update");
        user.setGender("gender_update");
        user.setEmail("email_update");
        //使用代理对象执行方法
        userDao.updateUser(user);
        destroy();
    }

    @Test
    public void testdelete() throws Exception{
        //使用代理对象执行方法
        userDao.deleteUser(3);
        sqlSession.commit();
        destroy();
    }

    @Test
    public void testFindOne() throws Exception{
        //使用代理对象执行方法
        User user = userDao.findById(2);
        System.out.print(user);
        sqlSession.commit();
        destroy();
    }

    @Test
    public void testFindName() throws Exception{
        //使用代理对象执行方法
        List<User> users = userDao.findByName("%2%");
        System.out.print(users);
        for(User user : users){
            System.out.print(user);
        }
        destroy();
    }

    @Test
    public void testFindTotal() throws Exception{
        //使用代理对象执行方法
        int count = userDao.findTotal();
        System.out.print(count);
        destroy();
    }

    @Test
    public void testFindByVo() throws Exception{
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setLast_name("%2%");
        vo.setUser(user);
        //使用代理对象执行方法
        List<User> users = userDao.findUserByVo(vo);
        for(User u : users){
            System.out.print(u);
        }
        destroy();
    }

    @Test
    public void testFindByCondition() throws Exception{
        User user = new User();
        user.setLast_name("%2%");

        List<User> users = userDao.findByCondition(user);
        for(User u : users){
            System.out.print(u);
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
        userDao = sqlSession.getMapper(IUserDao.class);//通过字节码生成代理对象
    }

    @After
    public void destroy() throws Exception{
        //释放方法
        sqlSession.close();
        in.close();
    }
}
