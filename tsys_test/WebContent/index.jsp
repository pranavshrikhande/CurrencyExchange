<%@page
	import="com.test.controller.MainController, java.util.*, com.test.bean.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>hi!</title>
</head>
<body>
	<h1>Welcome to page!</h1>
	<ul>
		<%	MainController main = new MainController();

		main.insertRecord("washingMachine", 800);
		List<Item> list = main.readRecords();

		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i).toString();
			System.out.println(temp);
		%>
		<li><%=temp%></li><br>




		<%
			}
		%>
	</ul>


	<p>currency Exchange according to rate :</p>
	<ul>
		<%
			MainController mainsecond = new MainController();

		for (int i = 0; i < list.size(); i++) {
			double usd = list.get(i).getCost();
			double eurorate = mainsecond.currencyConvertEuro(usd);
			String temp2 = list.get(i).toString();
			double inrrate = mainsecond.currencyConvertInr(usd);
		%>
		<li>USD:<%=temp2 %> <%=usd%></br> Euro: <%=usd * eurorate%> </br> Inr: <%=usd * inrrate%>
		</li>




		<%
			}
		%>


	</ul>
</body>
</html>