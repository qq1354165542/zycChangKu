package dao;

import entity.User;

/**
 * Created by 李克顺 on 2019/3/11.
 */
public interface UserDao {
    /**
     * 登录方法
     * @return
     */
    User login(User user) throws Exception;
}
