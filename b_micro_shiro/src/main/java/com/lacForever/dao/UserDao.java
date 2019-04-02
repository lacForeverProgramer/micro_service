package com.lacForever.dao;

import com.lacForever.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author: Liujiahao
 * @Date: 19-3-26 下午6:08
 */
@Repository
public interface UserDao extends JpaRepository<User,Long>{
    User findByUsername(String userName);

}
