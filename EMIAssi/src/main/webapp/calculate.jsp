<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
  String btn=request.getParameter("btn");
if(btn.equals("emi")){
	 int lnamt=Integer.parseInt(request.getParameter("lnamt"));
     int years=Integer.parseInt(request.getParameter("numofyears"));
     int intrest=lnamt*10;
     int tamt=lnamt+intrest;
     int months=years*12;
     int emi=tamt/months;

%>
   EMI=<%=emi %>
   <%} %>





</body>
</html>