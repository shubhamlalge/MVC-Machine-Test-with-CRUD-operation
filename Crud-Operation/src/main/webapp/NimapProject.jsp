<%@page import="CRUD.CategoryMaster"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.util.*"%>
<%@page import="CRUD.ProductMaster"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>ProductMaster And CategoryMaster</h1>
		<form>
			<table align="center" cellpadding="10px" border="10">
				<tr>
					<th>ProductId</th>
					<th>ProductName</th>
					<th>CategoryId</th>
					<th>Categoryname</th>
				</tr>
				<%
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Nimap");
				EntityManager em = emf.createEntityManager();
				ProductMaster PM = new ProductMaster();

				String New = request.getParameter("id");
				int pageNo = Integer.parseInt(New);
				Query q = em.createQuery("Select b from ProductMaster b");
				List<ProductMaster> L = q.getResultList();
				int i = (pageNo-1) * 10;
					for (int j=0;j<L.size();j++) {
						if (j >= i && j < i + 10) {
							ProductMaster P = L.get(j);
				%>
				<tr>
					<td><%=P.getProductId()%></td>
					<td><%=P.getProductName()%></td>
					<td><%=P.getCm().getCategoryId()%></td>
					<td><%=P.getCm().getCategoryname()%></td>
				</tr>
				<%
				}
				}
				
				%>
			</table>
		</form>
</body>
</html>