<%--
  Created by IntelliJ IDEA.
  User: 12455
  Date: 2019/12/21
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付完成</title>
    <script>
        function x() {
            window.location.href = "/loginSuccess.jsp"
        }
    </script>
</head>
<body style="background: blanchedalmond">
    <center>
        <b>支付成功！感谢惠顾，请点击按钮返回商店页面</b>
    </center>
    <center>
        <button style="margin-top: 100px;height: 100px;width: 500px;background-color: aquamarine" onclick="x()">
            点击返回商店
        </button>
    </center>
</body>
</html>
