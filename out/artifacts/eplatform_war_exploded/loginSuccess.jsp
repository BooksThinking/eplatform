<%@ page import="dao.eplatformDao" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.production" %>
<%@ page import="java.util.Iterator" %><%--
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
<body style="background-color: azure">
<form action="/eplatformServlet" method="post">
    <div class="container">
        <div>
            <img src="img/xiaomi8.jpg" height="250px" width="250px">
            <li>商品名称:<b id="production1">商品1</b></li>
            <li>商品价格:<b id="price1">价格1</b></li>
            <li>商品数量:<b id="number1">数量1</b></li>
            <input type="text" value="0" name="count1">
            <input type="button" value="+" onclick="javascript:this.form.count1.value++;">
            <input type="button" value="-" onclick="javascript:this.form.count1.value--;">
        </div>
        <div>
            <img src="img/xiaomi9.jpg" height="250px" width="250px">
            <li>商品名称:<b id="production2">商品2</b></li>
            <li>商品价格:<b id="price2">价格2</b></li>
            <li>商品数量:<b id="number2">数量2</b></li>
            <input type="text" value="0" name="count2">
            <input type="button" value="+" onclick="javascript:this.form.count2.value++;">
            <input type="button" value="-" onclick="javascript:this.form.count2.value--;">
        </div>
        <div>
            <img src="img/redminote8.jpg" height="250px" width="250px">
            <li>商品名称:<b id="production3">商品3</b></li>
            <li>商品价格:<b id="price3">价格3</b></li>
            <li>商品数量:<b id="number3">数量3</b></li>
            <input type="text" value="0" name="count3">
            <input type="button" value="+" onclick="javascript:this.form.count3.value++;">
            <input type="button" value="-" onclick="javascript:this.form.count3.value--;">
        </div>
        <div>
            <img src="img/redmik20pro.jpg" height="250px" width="250px">
            <li>商品名称:<b id="production4">商品4</b></li>
            <li>商品价格:<b id="price4">价格4</b></li>
            <li>商品数量:<b id="number4">数量4</b></li>
            <input type="text" value="0" name="count4">
            <input type="button" value="+" onclick="javascript:this.form.count4.value++;">
            <input type="button" value="-" onclick="javascript:this.form.count4.value--;">
        </div>
        <div>
            <img src="img/iphone.jpg" height="250px" width="250px">
            <li>商品名称:<b id="production5">价格5</b></li>
            <li>商品价格:<b id="price5">价格5</b></li>
            <li>商品数量:<b id="number5">数量5</b></li>
            <input type="text" value="0" name="count5">
            <input type="button" value="+" onclick="javascript:this.form.count5.value++;">
            <input type="button" value="-" onclick="javascript:this.form.count5.value--;">
        </div>
    </div>

    <center>
        <input type="submit" value="购买所有选中商品" style="margin-top:300px;height: 100px;width: 700px">
    </center>

</form>
<script type="text/javascript">
    <%
    eplatformDao dao = new eplatformDao();
    List<production> result = dao.getAllProduction();
    String name1 = result.get(0).getProductionName();int price1 = result.get(0).getProductionPrice();int number1 = result.get(0).getProductionNumber();
    String name2 = result.get(1).getProductionName();int price2 = result.get(1).getProductionPrice();int number2 = result.get(1).getProductionNumber();
    String name3 = result.get(2).getProductionName();int price3 = result.get(2).getProductionPrice();int number3 = result.get(2).getProductionNumber();
    String name4 = result.get(3).getProductionName();int price4 = result.get(3).getProductionPrice();int number4 = result.get(3).getProductionNumber();
    String name5 = result.get(4).getProductionName();int price5 = result.get(4).getProductionPrice();int number5 = result.get(4).getProductionNumber();
    %>
    document.getElementById("production1").innerHTML = "<%=name1%>";
    document.getElementById("production2").innerHTML = "<%=name2%>";
    document.getElementById("production3").innerHTML = "<%=name3%>";
    document.getElementById("production4").innerHTML = "<%=name4%>";
    document.getElementById("production5").innerHTML = "<%=name5%>";

    document.getElementById("price1").innerHTML = "<%=price1%>";
    document.getElementById("price2").innerHTML = "<%=price2%>";
    document.getElementById("price3").innerHTML = "<%=price3%>";
    document.getElementById("price4").innerHTML = "<%=price4%>";
    document.getElementById("price5").innerHTML = "<%=price5%>";

    document.getElementById("number1").innerHTML = "<%=number1%>";
    document.getElementById("number2").innerHTML = "<%=number2%>";
    document.getElementById("number3").innerHTML = "<%=number3%>";
    document.getElementById("number4").innerHTML = "<%=number4%>";
    document.getElementById("number5").innerHTML = "<%=number5%>";

</script>
</body>
</html>