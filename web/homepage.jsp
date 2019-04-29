<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 李克顺
  Date: 2019/3/11
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="css/homepage.css" />
</head>
<script src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">

</script>
<style>

</style>
<body>
<c:if test="${empty list}">
    <jsp:forward page="/VideoServlet?info=findVideoByPage"/>
</c:if>
<!--设置网页头部-->
<div class="header">
    <div class="header-first">
        <!--首页项目logo图片-->
        <div class="header-first-logo">
            <ul>
                <li></li>
            </ul>
        </div>
        <!--首页头部的收索框-->
        <div class="header-first-query">
            <input type="text" name="query" />
            <a href="">搜索</a>
        </div>
        <div class="header-first-login">
            <ul>
                <li><a href=""><img src="img/login.png"></a></li>
                <li><a href=""><img src="img/upload.jpg"></a></li>
            </ul>
        </div>
    </div>
    <div class="header-last">
        <div class="header-last-slideshow">
            <a href=""><img src="img/00001.jpg"></a>
        </div>
        <div class="header-last-ranking">
            <ul class="paihang">
                <li>本周热门</li>
                <c:forEach var="i" items="${requestScope.paiHangVideoInfo}">
                    <li><a href="">${i.name}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>

    <!--上传文件以及登录-->
</div>
<!--网页主体-->
<div class="content">
    <div class="content-biaoqian">

    </div>
    <div class="content-video">
        <ul>
            <c:forEach items="${requestScope.list}" var="video" varStatus="status">
                <li>
                    <a href="showVideo.jsp?src=${pageContext.request.contextPath}/video/${video.url}">
                        <video style="object-fit:fill">
                            <source src="${pageContext.request.contextPath}/video/${video.url}" type="video/mp4">
                            <source src="${pageContext.request.contextPath}/video/${video.url}" type="video/mp4">
                        </video>
                    </a><br/>
                    <span>${video.name}</span>
                </li>
                <c:if test="${status.count%4==0}"></br></c:if>
            </c:forEach>
        </ul>
    </div>
    <a href="${pageContext.request.contextPath}/VideoServlet?info=findVideoByPage&pageNum=1">首页</a>
    <a href="${pageContext.request.contextPath}/VideoServlet?info=findVideoByPage&pageNum=${pageUtil.pageNum-1}">上一页</a>
    <a href="${pageContext.request.contextPath}/VideoServlet?info=findVideoByPage&pageNum=${pageUtil.pageNum+1}">下一页</a>
    <a href="${pageContext.request.contextPath}/VideoServlet?info=findVideoByPage&pageNum=${pageUtil.totalPageCount}">尾页</a>
</div>
<div id="bottom">

</div>
</body>
</html>
