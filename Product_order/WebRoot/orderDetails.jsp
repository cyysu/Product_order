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
    <td>订单：</td>
     <td><s:property value="#session.orderDetail.id"/></td>
    </tr>
    <tr>
    <td>收货人：</td>
     <td><s:property value="#session.orderDetail.name"/></td>
    </tr>
    <tr>
    <td>收货地址：</td>
     <td><s:property value="#session.orderDetail.address"/></td>
    </tr>
    <tr>
    <td colspan="2">-------------------订单明细-----------------</td>
    </tr>
    <tr>
    <td>名称</td>
     <td>价格</td>
     <td>数量</td>
    </tr>
    <s:iterator value="#session.produdetails" id="prodeteil">
      <tr>
    <td><s:property value="#prodeteil.name"/></td>
     <td><s:property value="#prodeteil.price"/></td>
     <td><s:property value="#session.orderdetailDetail.amount"/></td>
    </tr>
    </s:iterator>
      <tr>
    <td colspan="3">总价：<s:property value="#session.total"/>元</td>
    </tr>
    </table>
    <a href="orderSelect.jsp">返回上一页</a>
  </body>
</html>
