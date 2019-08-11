package com.itheima.dao.impl;

//import java.util.List;
//
///**
// * 在这里实现IUserDao的方法
// */
//public class UserDaoImpl implements IUserDao {
//
//    private SqlSessionFactory factory;
//
//    public UserDaoImpl(SqlSessionFactory factory){
//        this.factory = factory;
//    }
//
//    public List<User> findAll() {
//        //根据factory获取SqlSession对象
//        SqlSession session = factory.openSession();
//        //调用session的selectList方法
//        List<User> users = session.selectList("com.itheima.dao.IUserDao.findAll");
//        session.close();
//        return users;
//    }
//
//    public void saveUser(User user) {
//
//    }
//
//    public void updateUser(User user) {
//
//    }
//
//    public void deleteUser(Integer userId) {
//
//    }
//
//    public User findById(Integer userId) {
//        return null;
//    }
//
//    public List<User> findByName(String last_name) {
//        return null;
//    }
//
//    public Integer findTotal() {
//        return null;
//    }
//
//    public List<User> findUserByVo(QueryVo vo) {
//        return null;
//    }
//}
