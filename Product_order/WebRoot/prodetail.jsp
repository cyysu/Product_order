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
    
    <title>订单信息</title>
    
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
    <table>
    <tr>
    </tr>
    <tr>
    <td>收货人：</td>
     <td><s:property value="#session.orderinfo.name"/></td>
    </tr>
    <tr>
    <td>收货地址：</td>
     <td><s:property value="#session.orderinfo.address"/></td>
    </tr>
    <tr>
    <td colspan="2">-------------------订单明细-----------------</td>
    </tr>
    <tr>
    <td>名称</td>
     <td>价格</td>
     <td>数量</td>
    </tr>
    <s:iterator value="#session.product" id="prodeteil">
      <tr>
    <td><s:property value="#prodeteil.name"/></td>
     <td><s:property value="#prodeteil.price"/></td>
     <td><s:property value="#session.ordetailinfo.amount"/></td>
    </tr>
    </s:iterator>
    </table>
    <a href="productList.jsp">返回商品列表</a>
  </body>
</html>
