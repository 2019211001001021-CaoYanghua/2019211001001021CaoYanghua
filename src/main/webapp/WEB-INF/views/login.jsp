<%--
  Created by IntelliJ IDEA.
  User: 彭于晏
  Date: 2021/4/6
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> Login</h1>
<%
if(!(request.getAttribute("message")==null)){
    out.println(request.getAttribute("message"));
}
%>
<form method="post" action="${pageContext.request.contextPath}/login"><!--within doPost() in servlet-->
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp"%>
