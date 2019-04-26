package servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 李克顺 on 2019/3/11.
 * 用户控制Servlet
 */
@WebServlet(name = "UserServlet",value = "/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info=request.getParameter("info");
        if(info.equals("login")){
            login(request,response);
            return;
        }
    }


    /**
     * 登录功能
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //需要获取用户提交的学号和密码
        String id = request.getParameter("id");
        //通过请求获取的学号是字符串类型，需要转换成int类型
        String password = request.getParameter("password");
        //将学号和密码封装到一个学生对象中
        User user=new User();
        user.setId(id);
        user.setPassWord(password);
        //创建StudentService对象
        UserService service=new UserService();
        //调用登陆功能，返回登陆的对象
        User user1 = service.login(user);
        if(user1==null){
            //将登陆失败信息添加到作用域，并转发到登陆页面
            request.setAttribute("message","登陆失败");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            //登陆成功，将用户信息添加到session作用域，重定向到列表页
            request.setAttribute("user",user1);
            request.getRequestDispatcher("homepage.jsp").forward(request,response);
        }
    }
}
