package service;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import entity.User;

/**
 * Created by 李克顺 on 2019/3/11.
 * 用户业务类
 */
public class UserService {
    UserDao dao=new UserDaoImpl();

    /**
     * 登录功能
     * @param user 返回学生对象
     * @return
     */
    public User login(User user){
        User user1=null;
        try {
            user1=dao.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user1;
    }
}
