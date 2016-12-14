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
    
    <title>订购商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
#submit{position: relative;left:-260px;}
</style>
  </head>
  
  <body>
  <s:form action="AddOrder.action" method="post"> 
   <table>
    <tr>
    <td>收货人：</td>
     <td><input type="text" name="shouhuoname"/></td>
    </tr>
    <tr>
    <td>收货地址：</td>
     <td><input type="text" name="address"/></td>
    </tr>
    <tr>
    <td colspan="2">-------------------订单明细-----------------</td>
    </tr>
    <tr>
    <td>名称</td>
     <td>价格</td>
     <td>数量</td>
     <td></td>
    </tr>
    <s:iterator value="#session.product" id="produ">
      <tr>
    <td><s:property value="#produ.name"/></td>
     <td><s:property value="#produ.price"/></td>
     <td><input type="text" name="number"/></td>
     <td style="display:none;"><input type="text" name="productid" value="<s:property value='#produ.id'/>"/></td>
    </tr>
    </s:iterator>
      <tr>
    <td colspan="3"><s:submit value="订购"/></td>
    </tr>
    </table>
    </s:form>
    <a href="productList.jsp">返回上一页</a>
  
  </body>
</html>
