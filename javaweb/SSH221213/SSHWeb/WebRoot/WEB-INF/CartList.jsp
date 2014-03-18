<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import = "com.demo.hibernate.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
 
    <title>My JSP 'MyCart.jsp' starting page</title>
    
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
  <% com.demo.hibernate.Cart myCart= (com.demo.hibernate.Cart)request.getSession().getAttribute("cart");%>
  <body bgcolor="#FDF5E6" >
 


   <center>
        我的购物车<br/><br/>
    <table border="1">
  <tr>
    <th>编号</th>
    <th>名称 </th>
    <th>价格</th>
    <th>描述</th>
    <th>数量</th>
    <th>小计</th>
    <th>操作1</th>
    <th>操作2</th>
  </tr>
 
  <% for (int i=0; i<myCart.number; i++){ %>
    <tr>
      <%String id = Integer.toString(i);  %>
      <% int inum = myCart.getCartItem(i).getquantity();
          String num = Integer.toString(inum);%>
    <td><%=myCart.getCartItem(i).getitem().getId() %></td>
    <td><%=myCart.getCartItem(i).getitem().getName() %></td>
    <td><%=myCart.getCartItem(i).getitem().getPrice() %></td>
    <td><%=myCart.getCartItem(i).getitem().getDescription() %></td>
    <td><%=myCart.getCartItem(i).getquantity() %></td>
    <td><%=myCart.getCartItem(i).getprice() %></td>
    <td><a href="javascript:changequantity(document.getElementById('input').value,<%=id%>,<%=num%>)">修改</a></td>
    <td><a href="javascript:deleteItem(<%=id%>)" >删除</a></td>
  </tr>
  <%} %>
</table>
<br/><br/>
   <form action="servletDemo" method="post" >
   <table>
   <tr>
   <th>现在想购买的数量：</th>
   <th><input id="input" ></th>
  </tr>
   <tr>
   <th>价格总计：</th>
   <th><input readonly="readonly" value="<%=myCart.getPrice()%>"></th><br/>
   
   </tr>
   <tr>
   <th>
   <input type="submit" value="继续购买"  />
   </th>
   <th><input type="button" value="清空购物车"  onclick="javascript:clearcart()" /></th>
  </tr>
  </table>
</form>
  </center>
    
  </body>
</html>
