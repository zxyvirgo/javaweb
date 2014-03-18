 
function adminDelete(id)
    {
    var b = window.confirm("确定要删除吗?");
    if (b){
    window.location.href="adminDelete?id="+id;
    }
    }
    
    
    function adminAddItem()
    {
     var b = window.confirm("确定要添加吗?");
     var i = document.getElementById("id").value;
     var n = document.getElementById("name").value;
         n = encodeURI(encodeURI(n));
     var p = document.getElementById("price").value;
   
     var d = document.getElementById("description").value;
         d = encodeURI(encodeURI(d));
    if (i==null || n==null || p==null || d==null||i=="" || n=="" || p=="" || d==""){
    alert("您要提交的信息不能为空！");
    return;
    }
    
    if (b){
   
    window.location.href="adminAdd?id="+i+"&name="+n+"&price="+p+"&description="+d;
    }
    
    
    }
    
    
    
    function adminUpdateItem()
    {
     var b = window.confirm("确定要修改吗?");
     var i = document.getElementById("id").value;
     var n = document.getElementById("name").value;
         n = encodeURI(encodeURI(n));
     var p = document.getElementById("price").value;
   
     var d = document.getElementById("description").value;
         d = encodeURI(encodeURI(d));
    if (i==null || n==null || p==null || d==null||i=="" || n=="" || p=="" || d==""){
    alert("您要提交的信息不能为空！");
    return;
    }
    
    if (b){
   
    window.location.href="adminUpdate?id="+i+"&name="+n+"&price="+p+"&description="+d;
    }
    
    
    }
    

    
    
 function buy(quantity, id){
        
        if (quantity<0 || quantity!=parseInt(quantity)){
        alert("请输入你要购买的数量！");
        return;
        }
        var b = window.confirm("确定将要购买的数量为："+quantity);
        
        if (b){
        window.location.href="buyServlet?id="+id+"&quantity="+quantity.toString(10);
        }
        }
   
 
 
 function deleteItem(id){
	    var b = window.confirm("确定要删除吗?");
	    if (b){
	    window.location.href="deleteServlet?id="+id;
	    }
	    } 
	    
	    function clearcart(){
	    var b = window.confirm("确定要清空您当前所选的商品吗？");
	    
	    if (b){
	    window.location.href="clearServlet";
	    }
	    }
	    
	    function changequantity(input, id, oldvalue){
	    var quantity = input;
	    
	    if (quantity<0 || quantity!=parseInt(quantity)){
	    alert("请在下面的框子输入正整数！");
	    return;
	    }
	    var b = window.confirm("确定要将数量修改为："+quantity);
	    
	    if (b){
	    window.location.href="changeServlet?id="+id+"&quantity="+quantity.toString(10);
	    }
	    }
    