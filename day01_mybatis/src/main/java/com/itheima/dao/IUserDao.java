package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;
import java.util.List;

public interface IUserDao {
    List<User> findAll ();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findById(Integer userId);

    List<User> findByName(String last_name);

    Integer findTotal();

    List<User> findUserByVo(QueryVo vo);

    List<User> findByCondition(User user);
}
