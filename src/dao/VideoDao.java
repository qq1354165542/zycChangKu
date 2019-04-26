package dao;

import entity.Video;
import unit.PageUtil;

import java.util.List;

/**
 * Created by 李克顺 on 2019/3/11.
 * 视频接口
 */
public interface VideoDao {

    /**
     * 查询总条数
     * @return
     * @throws Exception
     */
    int findTotalCount() throws Exception;

    /**
     * 分页查询，每页查询20条数据
     * @return
     * @throws Exception
     */
    List<Video> findVideoByPage(PageUtil<Video> pageUtil) throws Exception;


    /**
     * 上传视频
     * @param video
     * @return
     * @throws Exception
     */
    int addvideo(Video video) throws Exception;

    /**
     * 查询排行信息
     * @return
     * @throws Exception
     */
    public List<Video> findPaiHangVideoInfo()throws Exception;

}
