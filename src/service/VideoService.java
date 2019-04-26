package service;

import dao.Impl.VideoDaoImpl;
import dao.VideoDao;
import entity.Video;
import unit.PageUtil;

import java.util.List;

/**
 * Created by 李克顺 on 2019/3/11.
 * 视频业务类
 */
public class VideoService {
    private VideoDao dao=new VideoDaoImpl();

    /**
     * 查询总条数
     * @return
     * @throws Exception
     */
    public int findTotalCount() {
        int i=0;
        try {
            i=dao.findTotalCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * 分页查询，每页查询20条数据
     * @return
     * @throws Exception
     */
    public List<Video> findVideoByPage(PageUtil<Video> pageUtil) {
        List<Video> list=null;
        try {
            list=dao.findVideoByPage(pageUtil);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 上传视频
     * @param video
     * @return
     * @throws Exception
     */
    public int addvideo(Video video) {
        return 1;
    }

    /**
     * 查询排行信息
     */
    public List<Video> findPaiHangVideoInfo(){
        List<Video> videos=null;
        try {
            videos=dao.findPaiHangVideoInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos;
    }
}
