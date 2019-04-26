<%--
  Created by IntelliJ IDEA.
  User: 李克顺
  Date: 2019/3/11
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        *{
            margin: 0px;
            padding: 0px;
        }
        #video{
            margin: 0 auto;
            text-align: center;
            color: aqua;
            padding-top: 0px;
            width: 800px;
            height:500px;
        }
        video{
            width: 800px;
            height: 500px;
        }
        #danmu{
            margin: 0 auto;
            text-align: center;
            color: aqua;
        }
        marquee{
            width: 800px;
            height: 20px;
        }
    </style>
</head>
<body>
    <div id="danmu"><marquee>你好</marquee></div>
    <div id="video">
        <video autoplay="autoplay" controls="controls" style="object-fit:fill" >
            <source src=${param.get('src')} type="video/mp4">
            <source src=${param.get('src')} type="video/ogg">
        </video>
    </div>
</body>
</html>
