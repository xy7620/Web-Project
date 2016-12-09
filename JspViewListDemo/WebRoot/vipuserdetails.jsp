<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="entity.VipUser"%>
<%@ page import="dao.VipUserDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'vipuserdetails.jsp' starting page</title>
    
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
    <h1>VIP客户详情</h1>
    <a href="index.jsp">回到首页</a> <a href="curd/addvipuser.jsp">添加VIP客户</a>
    <form action="servlet/findCostInfo" method="post"> 
       <input type="text" name="uname">
       <input type="submit" value="搜索VIP客户姓名"/>
    </form>
    <BR>
    
              <!-- 循环开始 -->
           <% 
               VipUserDAO vipUserDao = new VipUserDAO(); 
               ArrayList<VipUser> list = vipUserDao.getAllVipUser();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  VipUser vipUser = list.get(i);
           %>
           <HR>
           <BR>
           VIP客户编号：<%=vipUser.getUid() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                           姓名：<a href="costinfo.jsp?uname=<%=vipUser.getUname() %>&ugoods=<%=vipUser.getUgoods()%>"><%=vipUser.getUname() %></a>&nbsp;&nbsp;&nbsp;
                           年龄：<%=vipUser.getUage() %>&nbsp;&nbsp;&nbsp;
                           电话：<%=vipUser.getUnumber() %>&nbsp;&nbsp;&nbsp;
           <a href="servlet/deleteVipUser?uid=<%=vipUser.getUid() %>">删除</a>&nbsp;&nbsp;&nbsp;
           <a href="curd/updatevipuser.jsp?uid=<%=vipUser.getUid()%>">修改</a> 
           <BR>
           <%
               }
             }
            %> 
    <hr>
  </body>
</html>
