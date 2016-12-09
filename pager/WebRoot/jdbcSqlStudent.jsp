<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">

	</style>
	  <%
  		String context = request.getContextPath();
   %>
<script type="text/javascript">
	function init(){
		document.getElementById("name").value=${name};
		document.getElementById("gender").value=${gender};
	}
	
</script>
  </head>

   
  <body >
  <h2>学生信息</h2>
    <div>
    	<form action="<%=context%>/servlet/jdbcSqlServlet" id= "stuForm" method="post">
    		姓名
    		<input type='text' name="name" id="name" >&nbsp;
    		性别
    		<select name="gender" id="gender">
    			<option value="-1">全部</option>
    			<option value="1">男</option>
    			<option value="2">女</option>
    		</select>&nbsp;&nbsp;
    		<input type="submit" value="查询">
    	</form>
    </div>
    <div>
    	学生信息列表:<br><br>
    	<!-- 后台返回结果为空 -->
    	<c:if test="${fn:length(result.dataList) eq 0 }">
    		<span>查询结果不存在</span>
    	</c:if>
    	
    	<!-- 后台返回结果不为空 -->
    	<c:if test="${fn:length(result.dataList) gt 0}">
   	    <table  border= 1px;>
    			<tr height="30" >
    				<th width="130">姓名</th>
    				<th width="130">性别</th>
    				<th width="130">年龄</th>
    				<th width="230">家庭住址</th>
    			</tr>
    			<c:forEach items="${result.dataList }" var="student">
    				<tr>
    					<td><c:out value="${student.name }"></c:out></td>
    					<td>
							<c:if test="${student.gender eq 1 }">男</c:if>
							<c:if test="${student.gender eq 2 }">女</c:if>
						</td>
    					<td><c:out value="${student.age }"></c:out></td>
    					<td><c:out value="${student.address }"></c:out></td>
    				</tr>
    			</c:forEach>
    		</table><br>
    		共${result.totalRecord }条记录，共${result.totalPage }页，当前第${result.currentPage}页 &nbsp;&nbsp;
    		<a href="servlet/jdbcSqlServlet?pageNum=1&name=${name}&gender=${gender}" >首页</a>
    		<!-- 这类标签必须带有查询信息 -->
    		<a href="servlet/jdbcSqlServlet?pageNum=${result.currentPage+1 }&name=${name}&gender=${gender}" onmouseover="init()">下一页</a>
    		<a href="servlet/jdbcSqlServlet?pageNum=${result.currentPage-1 }&name=${name}&gender=${gender}" >上一页</a>
    		<a href="servlet/jdbcSqlServlet?pageNum=${result.totalPage }&name=${name}&gender=${gender}" >尾页</a>
    	</c:if>
    </div>
  </body>
</html>
