package unit;

import entity.Video;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.VideoService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ice on 2019/3/11.
 */
@WebServlet(name = "UploadServlet",value ="/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一步：判断是否为文件上传表单
        boolean multipart = ServletFileUpload.isMultipartContent(request);
        if(multipart){//当处理的是文件上传表单时
            //第二步：设置文件上传到服务器的位置
            String uploadPath = request.getServletContext().getRealPath("video/");
            //第三步：判断次路径对应的文件夹是否存在，若不存在，创建此文件夹
            File mkdir = new File(uploadPath);
            if(!mkdir.exists()){
                boolean mkdirs = mkdir.mkdirs();
                if(mkdirs){
                    System.out.println("文件夹创建成功");
                }
            }
            //第四步：创建ServletFileUpload对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload  = new ServletFileUpload(factory);
            //第五步：解析请求，将表单控件封装成FileItem对象，返回一个集合
            try {
                List<FileItem> fileItems = upload.parseRequest(request);
                //创建一个视频对象，将表单中的值封装到此对象中
                Video video=new Video();
                //遍历FileItems集合
                for(FileItem fileItem : fileItems){
                    //做遍历的目的，是为了获取每个表单元素携带的信息
                    //需要判断当前元素是否为普通表单元素
                    if(fileItem.isFormField()){
                        //表示此元素为普通表单元素
                        String fieldName = fileItem.getFieldName();//获取此元素的name值
                        if(fieldName.equals("uId")){
                            String uId = fileItem.getString();
                            video.setId(Integer.parseInt(uId));
                        }else if(fieldName.equals("")){
                            video.setUrl(fileItem.getString("UTF-8"));
                        }
                    }else{
                        //此元素为上传的文件
                        String name = fileItem.getName();//第一：获取文件名
                        //第二：设置一个新的文件名
                        UUID uuid = UUID.randomUUID();
                        String fileName = uuid+name;
                        //第三：创建文件
                        File saveFile = new File(uploadPath,fileName);
                        //第四：执行上传
                        fileItem.write(saveFile);
                        video.setUrl(fileName);
                    }
                }
                VideoService service = new VideoService();
                if(1==1){
                    response.sendRedirect("homepage.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
