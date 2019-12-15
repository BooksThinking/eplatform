<%@ page import="servlet.eplatformServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.production" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 12455
  Date: 2019/12/14
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>电子商务平台</title>
    <style>
        .container div{
            display: inline-block;
        }
    </style>
    <script type="text/javascript">
        function a(){
            $.ajax({
                url:"eplatformServlet",//servlet文件的名称
                type:"POST",
                success:function(result){
                    alert("servlet调用成功！");
                }
            });

        }
    </script>
</head>
<body onload="a()">
<form action="/eplatformServlet">
    <div class="container">
        <div>
            <img src="img/xiaomi8.jpg" height="200px" width="200px">
            <b id="production1">小米8</b>
        </div>
        <div>
            <img src="img/xiaomi9.jpg" height="200px" width="200px">
            <b id="production2">小米9</b>
        </div>
        <div>
            <img src="img/redminote8.jpg" height="200px" width="200px">
            <b id="production3">红米note8</b>
        </div>
        <div>
            <img src="img/redmik20pro.jpg" height="200px" width="200px">
            <b id="production4">红米k20</b>
        </div>
        <div>
            <img src="img/iphone.jpg" height="200px" width="200px">
            <b id="production5">苹果</b>
        </div>
    </div>
</form>
</body>
</html>