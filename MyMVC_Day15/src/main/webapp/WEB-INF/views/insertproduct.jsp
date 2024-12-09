<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="insertproduct" method="post">
Product id <input type="text" name="pid" id="pid"><br>
Product Name <input type="text" name="pname" id="pname"><br>
Product qty <input type="text" name="qty" id="qty"><br>
Product price <input type="text" name="price" id="price"><br>
Product Expiry Date <input type="text" name="ldt" id="ldt"><br>
Product cid <input type="text" name="cid" id="cid"><br>
<button type="submit" name="btn" id="insert">Add Product</button>
</form>
</body>
</html>