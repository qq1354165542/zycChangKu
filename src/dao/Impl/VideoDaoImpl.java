package dao.Impl;

import dao.BaseDao;
import dao.VideoDao;
import entity.Video;
import unit.PageUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李克顺 on 2019/3/11.
 */
public class VideoDaoImpl extends BaseDao implements VideoDao {


    /**
     * 查询总条数
     *
     * @return
     * @throws Exception
     */
    @Override
    public int findTotalCount() throws Exception {
        int count = 0;
        //编写SQL语句
        String sql = "select count(0) as count from video";
        //构造参数
        Object[] params = {};
        //执行sql语句
        ResultSet rs = executeQuery(sql, params);
        if(rs.next()){
            count = rs.getInt("count");
        }
        return count;
    }

    /**
     * 分页查询，每页查询20条数据
     *
     * @param pageUtil
     * @return
     * @throws Exception
     */
    @Override
    public List<Video> findVideoByPage(PageUtil<Video> pageUtil) throws Exception {
        List<Video> list = new ArrayList<>();
        //编写sql语句
        String sql = "select * from video limit ?,?";
        //设置参数
        Object[] params = {pageUtil.getPageIndex(), pageUtil.getPageSize()};
        //执行sql语句
        ResultSet rs = executeQuery(sql, params);
        while (rs.next()) {
            //创建学生对象，并将数据封装到学生对象中
            Video video = new Video();
            video.setId(rs.getInt("id"));
            video.setName(rs.getString("name"));
            video.setUrl(rs.getString("url"));
            video.setTypeId(rs.getInt("typeId"));
            video.setBrowseNumber(rs.getInt("browseNumber"));
            video.setUploadTime(rs.getDate("uploadTime"));
            //将学生对象添加到集合中
            list.add(video);
        }
        return list;
    }

    /**
     * 上传视频
     *
     * @param video
     * @return
     * @throws Exception
     */
    @Override
    public int addvideo(Video video) throws Exception {
        return 0;
    }

    /**
     * 查询排行信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Video> findPaiHangVideoInfo() throws Exception {
        //定义排行视频信息集合
        List<Video> videos = new ArrayList<>();
        //定义SQL语句
        String sql = "SELECT * FROM video AS v WHERE v.`id` IN (SELECT v2.id FROM (SELECT id FROM video ORDER BY browseNumber DESC LIMIT 0,10) AS v2) AND DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= DATE(uploadTime) ORDER BY v.`browseNumber` DESC;";
        //构造参数
        Object[] params = {};
        //执行SQL语句
        ResultSet rs = executeQuery(sql, params);
        //遍历
        while (rs.next()){
            Video video = new Video();
            video.setId(rs.getInt(1));
            video.setName(rs.getString(2));
            video.setUrl(rs.getString(3));
            video.setTypeId(rs.getInt(4));
            video.setBrowseNumber(rs.getInt(5));
            video.setUploadTime(rs.getDate(6));
            videos.add(video);
        }
        closeAll(null,rs);
        return videos;
    }
}
