<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="entity.Items"%>
<%@ page import="dao.ItemsDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'costinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  	<style type="text/css">
	   hr{
	    border-color:FF7F00; 
	   }
	   div{
	      float:left;
	      margin: 10px;
	   }
	   div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   div dd.dd_name
	   {
	      color:blue;
	   }
	   div dd.dd_city
	   {
	      color:#000;
	   }
	</style>
  <body>

    <h2>VIP客户：<%=request.getParameter("uname") %>&nbsp;的消费信息</h2>
    <a href="index.jsp">回到首页</a><HR>
     <form action="servlet/addCostInfo?uname=<%=request.getParameter("uname") %>" method="post">
       <input type="text" name="id" name="uname">
       <input type="submit" value="添加商品" >
     </form>
    <center>
    <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
           <% 
               ItemsDAO itemsDao = new ItemsDAO();
               String ugoods = request.getParameter("ugoods");
               String[] strGoods = ugoods.split(";");
               for(int i=0; i<strGoods.length; i++){
               if(strGoods[i]!=""){
                   int id = Integer.parseInt(strGoods[i]);
                   Items item = itemsDao.getItemsById(id);
           %>   
          <div>
             <dl>
               <dt>
                 <a href="details.jsp?id=<%=item.getId()%>&name=<%=item.getName()%>"><img src="images/<%=item.getPicture()%>" width="120" height="90" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=item.getName() %>(ID：<%=item.getId() %>)&nbsp;&nbsp;
               <a href="servlet/deleteCostInfo?id=<%=item.getId()%>&uname=<%=request.getParameter("uname")%>">删除</a></dd> 
               <dd class="dd_city">产地:<%=item.getCity() %>&nbsp;&nbsp;价格:￥ <%=item.getPrice() %></dd> 
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%  
              } 
              }
          %>
        </td>
      </tr>
    </table>
    </center>
  </body>
</html>
