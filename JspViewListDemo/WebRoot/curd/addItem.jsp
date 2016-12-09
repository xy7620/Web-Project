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
    <h3>请输入商品信息</h3>
    
    <form action="servlet/add" method="post">
    <table>
      <tr>
        <td > 名字：</td>
        <td > <input type="text" name="name"></td>
      </tr>
      <tr>
        <td> 产地：</td>
        <td> <input type="text" name="city"></td>
      </tr>
      <tr>
        <td> 价格</td>
        <td > <input type="text" name="price"></td>
      </tr>

      <tr>
        <td> 图片编号：</td>
        <td> <input type="text" name="picture"></td>
      </tr>
      <tr><td><input type="submit" value="提交"/></td></tr>
    </table>
</form>
  </body>
</html>
