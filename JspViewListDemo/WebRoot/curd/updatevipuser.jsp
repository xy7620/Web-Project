<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h3>请输入VIP客户信息</h3>
    
    <form action="servlet/updateVipUser?uid=<%=request.getParameter("uid") %>" method="post">
    <table>
      <tr>
        <td > 名字：</td>
        <td > <input type="text" name="uname"></td>
      </tr>
      <tr>
        <td> 年龄：</td>
        <td> <input type="text" name="uage"></td>
      </tr>
      <tr>
        <td> 电话</td>
        <td > <input type="text" name="unumber"></td>
      </tr>

      <tr>
        <td> 消费信息</td>
        <td> <input type="text" name="ugoods"></td>
      </tr>
      <tr><td><input type="submit" value="提交"/></td></tr>
    </table>
</form>
  </body>
</html>
