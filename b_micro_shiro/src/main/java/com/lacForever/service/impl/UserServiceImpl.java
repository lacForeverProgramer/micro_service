package com.lacForever.service.impl;

import com.lacForever.dao.UserDao;
import com.lacForever.entity.User;
import com.lacForever.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Author: Liujiahao
 * @Date: 19-3-26 下午6:12
 */
@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.createNativeQuery("INSERT INTO user_t (id,password,salt,username) VALUES (?,?,?,?)")
                .setParameter(1,user.getId())
                .setParameter(2,user.getPassword())
                .setParameter(3,user.getSalt())
                .setParameter(4,user.getUsername())
                .executeUpdate();
    }
}
