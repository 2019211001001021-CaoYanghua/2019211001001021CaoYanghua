<%--
  Created by IntelliJ IDEA.
  User: 彭于晏
  Date: 2021/3/16
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!--method is get-->
<form method="post"><!-- what is method when we use form?--><!--is get why?default is get -->
    <!-- is better to use post in form,data in not added in URL,you can see-->
    Name:<input type="text" name="name"><br/>
    ID:<input type="text" name="id"><br/>
    <input type="submit" value="send data to server"/>
</form>
</body>
</html>
