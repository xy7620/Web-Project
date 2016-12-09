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

  </head>
<link href="../css/pagination.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/jquery.pagination.js"></script>
<script type="text/javascript">

// 点击分页按钮以后触发的动作
function handlePaginationClick(new_page_index, pagination_container) {
    $("#stuForm").attr("action", "<%=context %>/jdbcSql/JdbcSqlServlet?pageNum=" + (new_page_index+1));
    $("#stuForm").submit();
    return false;
}

$(function(){
	$("#News-Pagination").pagination(${result.totalRecord}, {
        items_per_page:${result.pageSize}, // 每页显示多少条记录
        current_page:${result.currentPage} - 1, // 当前显示第几页数据
        num_display_entries:8, // 分页显示的条目数
        next_text:"下一页",
        prev_text:"上一页",
        num_edge_entries:2, // 连接分页主体，显示的条目数
        callback:handlePaginationClick
	});
	
	// 设置学生默认性别
	$("#gender").val("${gender}");
});

</script>
  <body>
  <h2>学生信息</h2>
    <div>
    	<form action="<%=context%>/servlet/jdbcSqlJqueryServlet" id= "stuForm" method="post">
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
    		<div id="News-Pagination"></div>
    		<!--  
    		共${result.totalRecord }条记录，共${result.totalPage }页，当前第${result.currentPage}页 &nbsp;&nbsp;
    		<a href="servlet/jdbcSqlServlet?pageNum=1&name=${name}&gender=${gender}" >首页</a>
    		
    		<a href="servlet/jdbcSqlServlet?pageNum=${result.currentPage+1 }&name=${name}&gender=${gender}" >下一页</a>
    		<a href="servlet/jdbcSqlServlet?pageNum=${result.currentPage-1 }&name=${name}&gender=${gender}" >上一页</a>
    		<a href="servlet/jdbcSqlServlet?pageNum=${result.totalPage }&name=${name}&gender=${gender}" >尾页</a>
    	-->
    	</c:if>
    </div>
  </body>
</html>
