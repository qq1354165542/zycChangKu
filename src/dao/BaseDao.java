package dao;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * 数据库连接与关闭工具类。
 */
public class BaseDao {
    protected Connection conn;
    private static DataSource ds;

    /**
     * 静态代码块
     */
    static {
        try {
            Properties properties = new Properties();
            InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("dbcp.properties");
            properties.load(is);
            ds = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关闭数据库连接。
     *
     * @param stmt Statement对象
     * @param rs   结果集
     */
    public void closeAll(Statement stmt, ResultSet rs) {
        // 若结果集对象不为空，则关闭
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 若Statement对象不为空，则关闭
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 增、删、改操作
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 执行结果
     */
    protected int executeUpdate(String sql, Object[] params) {
        int result = 0;
        conn = this.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll( pstmt, null);
        }
        return result;
    }

    /**
     * 查询操作
     *
     * @param sql    sql语句
     * @param params 参数数组
     * @return 查询结果集
     */
    protected ResultSet executeQuery(String sql, Object[] params) {
        conn = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 增、删、改操作
     *
     * @param sql  sql语句
     * @param list 参数数组
     * @return 执行结果
     */
    protected int executeUpdate(String sql, List list) {
        int result = 0;
        conn = this.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                pstmt.setObject(i + 1, list.get(i));
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(pstmt, null);
        }
        return result;
    }

    /**
     * 查询操作
     *
     * @param sql  sql语句
     * @param list 参数数组
     * @return 查询结果集
     */
    protected ResultSet executeQuery(String sql, List list) {
        conn = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                pstmt.setObject(i + 1, list.get(i));
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
