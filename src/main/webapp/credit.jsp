<%@page import="model.CreditModel"%>
<%
	CreditModel creditModel = (CreditModel) request.getAttribute("creditModel");
%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Credit</title>
	</head>
	<body>
		<div>
			<form action="calculateCredit.credit" method="post">
				<table>
					<tr>
						<td>Capital</td>
						<td><input type="text" name="capital" value="<%=creditModel.getCapital() %>">DH</td>
					</tr>
					<tr>
						<td>Taux</td>
						<td><input type="text" name="taux"  value="<%=creditModel.getTaux() %>">%</td>
					</tr>
					<tr>
						<td>Duree</td>
						<td><input type="text" name="duree"  value="<%=creditModel.getDuree() %>">jours</td>
					</tr>
					<tr>
						<td><input type="submit" value="Calculate"></td>
						<td><input type="reset" name="Reset"></td>
					</tr>
				</table>
			</form>
		</div>
		<div>
			<p style="color: red">
				Your part for each month is : <%=creditModel.getMonthlyPart() %>
			</p>
		</div>
		
	</body>
</html>