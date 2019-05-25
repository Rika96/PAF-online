<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% page import = "com.testx.models.Item" %>
<% page import ="javax.sql. *" %>
<%Payment payment = new Payment();
	String itemsGrid = "";
	String rudFeedBack = "";
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("save"))
	{
		rudFeedback = payment.savePayment(request.getParameter("txtpaymentID"), request.getParameter("txtPaymentMethod"),request.getParameter("txtfulAmount"),request.getParameter("txtDate"));
	}
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("update"))
	{
		rudFeedback = payment.updatePayment(request.getParameter("hidID"), request.getParameter("txtpaymentID"), request.getParameter("txtPaymentMethod"),request.getParameter("txtfulAmount"),request.getParameter("txtDate"));

	}
	
	
	if(request.getParameter(hidMode) != null && request.getParameter("hidMode"). equalsIgnoreCase("remove"))
	{
		rudFeedback = payment.deletePayment(request.getParameter("hidID"));

	}
	
	paymentGrid = payment.getPayment();
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="formItems" action="items.jsp" method="post">
		<input id="hidMode" name="hidMode" type="hidden" value="save">
		<input id="hidID" name="hidID" type="hidden" value="0">
		Item Name <input id="txtItemName" type="text" name="txtItemName"> <br>
		Item Description <input id="txtItemDesc" type="text" name="txtItemDesc" > <br>
		<input id="btnSave" type="button" name="btnSave"  value="Save"> <br> <br>
		<div id="divStsMsgItem"> </div>
		 
	</form>
</body>
</html>