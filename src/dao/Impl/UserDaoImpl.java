package dao.Impl;

import dao.BaseDao;
import entity.User;

import java.sql.ResultSet;

/**
 * Created by 李克顺 on 2019/3/11.
 */
public class UserDaoImpl extends BaseDao implements dao.UserDao {

    /**
     * 登录方法
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) throws Exception{
        User user1=new User();
        String sql="SELECT * FROM `user` WHERE id=? AND `password`=?";
        Object [] params={user.getId(),user.getPassWord()};
        ResultSet rs = executeQuery(sql, params);
        if(rs.next()){
            user1.setId(rs.getString("id"));
        }
        closeAll(null,rs);
        return user1;
    }
}
