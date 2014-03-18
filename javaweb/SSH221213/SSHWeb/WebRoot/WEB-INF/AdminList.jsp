<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.demo.hibernate.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%response.setContentType("text/html;charset=utf-8");
request.setCharacterEncoding("utf-8");
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
 <b> 货物架</b> <br/><br/>
   
    <table border="1">
  <tr>
    <th>编号</th>
    <th>名称 </th>
    <th>价格</th>
    <th>描述</th>
    <th>操作</th>
  </tr>
  
    <% for (int i=0; i<itemlist.size(); i++){ %>
  <tr>
  <%int idnum = itemlist.get(i).getId(); %>
      <%String sid = Integer.toString(idnum);  %>
     <td><%=itemlist.get(i).getId() %></td>
     <td><%=itemlist.get(i).getName() %></td>
     <td><%=itemlist.get(i).getPrice() %></td>
     <td><%=itemlist.get(i).getDescription()%></td>
    <td><a href="javascript:adminDelete(<%=sid%>)" >删除</a></td>
  </tr>
    <%} %>
  
</table>
<br/><br/>
   <form action="javascript:adminAddItem()"  method="post">
   <table>
   <tr>
   <td> 编号  ：</td><td><input id="id" type="text" /></td>
   </tr>
   <tr>
   <td>  名称：</td><td><input id="name" type="text" /></td>
   </tr>
   <tr>
   <td>价格：</td><td><input id="price" type="text" /></td>
   </tr>
   <tr>
   <td>描述: </td><td><input id="description" type="text" /></td>
   </tr>
   </table> 
    <input type="submit" value="加入货物架">
   </form>
   
     <form action="javascript:adminUpdateItem()"  method="post">
    <input type="submit" value="修改货物架">
   </form>
   
   
    <form action="servletDemo">
     <input type="submit" value="开始购物">
    </form>
      <% if (currentpage == 1){
    %>
      <a href="adminPage?page=<%=currentpage%>">第一页</a> 
   <%}
    if (currentpage > 1 ){
   %>
      <a href="adminPage?page=<%=currentpage-1%>">上一页</a> 
   <% }
   if (currentpage < totalpage){
 %> 
      <a href="adminPage?page=<%=currentpage+1%>">下一页</a>
   <%}
   if (currentpage == totalpage){%>
      <a href="adminPage?page=<%=totalpage%>">末一页</a>
  <%}%>
    </center>
       
  </body>
</html>
