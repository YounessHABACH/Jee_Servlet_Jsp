<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
</head>
<body>
	<h1>Produits</h1>
	
	<form action="chercher.produit" method="get">
		Mot Cle
		<input type="text" name="mc" value="${model.mc}">
		<input type="submit" value="Search">
	</form>
	<br>
	<table border=1>
		<thead>
			<tr>
				<td>ID</td>
				<td>Designation</td>
				<td>Prix</td>
				<td>Quantity</td>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${model.produits}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.designation}</td>
					<td>${p.prix}</td>
					<td>${p.quantity}</td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
</body>
</html>