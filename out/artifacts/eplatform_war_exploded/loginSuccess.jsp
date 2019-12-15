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
</head>
<body>
<form action="/eplatformServlet">
    <div class="container">
        <div>
            <img src="img/xiaomi8.jpg" height="200px" width="200px">
            <b id="production1">商品1</b>
        </div>
        <div>
            <img src="img/xiaomi9.jpg" height="200px" width="200px">
            <b id="production2">商品2</b>
        </div>
        <div>
            <img src="img/redminote8.jpg" height="200px" width="200px">
            <b id="production3">商品3</b>
        </div>
        <div>
            <img src="img/redmik20pro.jpg" height="200px" width="200px">
            <b id="production4">商品4</b>
        </div>
        <div>
            <img src="img/iphone.jpg" height="200px" width="200px">
            <b id="production5">商品5</b>
        </div>
    </div>
    <script>
        <%
        eplatformServlet servlet = new eplatformServlet();
        List<production> productionList = servlet.getProduction();
        List<String> productionName = new ArrayList<>();
        List<String> productionPrice = new ArrayList<>();
        List<String> productionNumber = new ArrayList<>();
        for (int i = 0;i < 5;i++){
            productionName.add(productionList.get(i).getProductionName());
            productionPrice.add(productionList.get(i).getProductionPrice());
            productionNumber.add(productionList.get(i).getProductionNumber());
        }
        %>
        var name = <%=productionName.get(0)%>;
        document.getElementsByName("b")[0].innerHTML(name);
     </script>
</form>
</body>
</html>