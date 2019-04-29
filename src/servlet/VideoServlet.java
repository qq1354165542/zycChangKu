package servlet;

import entity.Video;
import service.VideoService;
import unit.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 李克顺 on 2019/3/11.
 */
@WebServlet(name = "VideoServlet",value = "/VideoServlet")
public class VideoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取用户需要请求的参数，根据参数执行操作
        String info=request.getParameter("info");
        if(info.equals("findVideoByPage")){
            findVideoByPage(request,response);
        }
        if(info.equals("addVideo")){
            addVideo(request,response);
        }
    }
    //创建StudentService
    VideoService service=new VideoService();

    /**
     * 分页查询，查询前20条数据
     * @param request
     * @param response
     */
    private void findVideoByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询排行
            //1.获取排行数据
            List<Video> paiHangVideoInfo = service.findPaiHangVideoInfo();



        //查询总记录数
        int count = service.findTotalCount();
        //创建分页工具类
        PageUtil<Video> pageUtil = new PageUtil<>();
        pageUtil.setTotalCount(count);
        //获取前台页码
        String pageNum = request.getParameter("pageNum");
        if(pageNum==null){
            pageNum = "1";
        }
        int pageNumber = Integer.parseInt(pageNum);
        pageUtil.setPageNum(pageNumber);
        List<Video> list=service.findVideoByPage(pageUtil);
        if(list==null){
            request.setAttribute("find","加载失败");
        }else {
            request.setAttribute("list",list);
            request.setAttribute("paiHangVideoInfo",paiHangVideoInfo);
            request.getRequestDispatcher("homepage.jsp").forward(request,response);
        }
    }

    /**
     * 添加视频
     * @param request
     * @param response
     */
    private void addVideo(HttpServletRequest request, HttpServletResponse response) {

    }
}
