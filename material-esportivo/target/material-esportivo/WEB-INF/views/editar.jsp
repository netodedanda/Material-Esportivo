<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>

	<form:form method="POST" modelAttribute="material" action="../update/${id}">
		<p>
			Nome:
			<form:input path="nome"></form:input>
		</p>
		<p>
			Preço:
			<form:input path="preco"></form:input>
		</p>
		<p>
			Quantidade:
			<form:input path="quantidade"></form:input>
		</p>

		<p>
			<form:button>Cadastrar</form:button>
		</p>
		<p>${mensagem}</p>
	</form:form>
</body>
</html>