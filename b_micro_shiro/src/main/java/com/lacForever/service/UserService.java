package com.lacForever.service;

import com.lacForever.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author: Liujiahao
 * @Date: 19-3-26 下午6:08
 */

public interface UserService {

    User findUserByName(String username);

    void saveUser(User user);

}
