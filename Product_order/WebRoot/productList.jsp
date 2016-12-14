<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#submit{position:relative;right: 1210px;}
tr{width:300px;}
td{width:150px;}
</style>
  </head>
  
  <body>
   <h2 style="color:#CCC">商品列表</h2> <a href="index.jsp">返回首页</a>
    <font color="red"><s:property value="proid"/><s:fielderror/></font>
    <s:form action="ProductById.action" method="post">
    <s:iterator value="#session.proList" id="proList">
   <table>
   <tr>
   	<td><s:property value="#proList.name"/></td>
   	<td>
   	选购<input type="checkbox" name="proid" value="<s:property value='#proList.id'/>"/>
   	</td>
   </tr>
   <tr>
   	<td colspan="2"><img src="image/gray.png"/></td>
   </tr>
    <tr>
   	<td>厂商：</td>
   	<td><s:property value="#proList.manufacturer"/></td>
   </tr>
   <tr>
   	<td>价格：</td>
   	<td><s:property value="#proList.price"/>元</td>
   </tr>
   <tr>
   	<td colspan="2"><s:property value="#proList.specification"/></td>
   </tr>
   <tr>
   	<td colspan="2"><img src="image/back.png"></img></td>
   </tr>
   </table>
    </s:iterator>
     <s:submit value="订购"/><br/>
     
      </s:form>
  </body>
</html>