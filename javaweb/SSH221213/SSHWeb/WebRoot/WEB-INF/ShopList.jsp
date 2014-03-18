<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.demo.hibernate.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShopList.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="ajax.js" charset="UTF-8">
     </script>
    
  </head>
  <% 
  int currentpage = (Integer)request.getSession().getAttribute("currentpage");
  int totalpage = (Integer)request.getAttribute("totalpage");
  java.util.List<com.demo.hibernate.Item> itemlist= (java.util.List<com.demo.hibernate.Item>)request.getAttribute("itemlist");%>
  <body bgcolor="#FDF5E6" >
   <center>
    可供选择的货物列表 <br/><br/>
   
    <table border="1">
  <tr>
    <th>编号</th>
    <th>名称 </th>
    <th>价格</th>
    <th>描述</th>
    <th>是否有货</th>
    <th>操作</th>
  </tr>
  
    <% for (int i=0; i<itemlist.size(); i++){ %>
  <tr>
      <%String sid = Integer.toString(i+1);  %>
     <td><%=itemlist.get(i).getId() %></td>
     <td><%=itemlist.get(i).getName() %></td>
     <td><%=itemlist.get(i).getPrice() %></td>
     <td><%=itemlist.get(i).getDescription()%></td>
     <th>是</th>
    <td><a href="javascript:buy(document.getElementById('input').value,<%=sid%>)">加入购物车</a></td>
  </tr>
    <%} %>
  
</table>
<br/><br/>
<form action="buyServlet?id=0&quantity=0" method="post" >
<table>
   <tr>
   <th>输入你想购买的数量：</th>
   <th><input id="input" ></th>
   </tr>
   <tr> 
   <th><input type="submit" value="查看购物车"/></th>
   </tr>
</table>
</form>
    <form action="adminList">
    <input type="submit" value="对货物架进行操作">
    </form>
   
  <% if (currentpage == 1){
    %>
      <a href="servletList?page=<%=currentpage%>">第一页</a> 
   <%}
    if (currentpage > 1 ){
   %>
      <a href="servletList?page=<%=currentpage-1%>">上一页</a> 
   <% }
   if (currentpage < totalpage){
 %> 
      <a href="servletList?page=<%=currentpage+1%>">下一页</a>
   <%}
   if (currentpage == totalpage){%>
      <a href="servletList?page=<%=totalpage%>">末一页</a>
  <%}%>
   </center>
  </body>
</html>
