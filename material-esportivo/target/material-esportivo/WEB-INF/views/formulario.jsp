<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Lista de Produtos</title>
</head>
<body>

    
<form:form method="POST" modelAttribute="material" action="cadastro">
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
		<p>${mensagem}</p>    </form:form>

    <table>
        <thead>
            <tr>
                <th>NOME</th>
                <th>PREÇO</th>
                <th>QUANTIDADE</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="material" items="${materiais}">
                <tr>
                    <td>${material.nome}</td>
                    <td>${material.preco}</td>
                    <td>${material.quantidade}</td>
                    <td>
                        <a href="editar/${materiais.indexOf(material)}">Editar</a>
                        <a href="excluir/${materiais.indexOf(material)}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script type="text/javascript">
        // Seu código JavaScript para ordenar a tabela
        const table = document.querySelector("table");
        const tbody = table.querySelector("tbody");
        const rows = Array.from(tbody.querySelectorAll("tr"));

        const compare = (rowA, rowB) => {
            const priceA = parseFloat(rowA.cells[1].textContent);
            const priceB = parseFloat(rowB.cells[1].textContent);
            return priceB - priceA;
        };

        rows.sort(compare);

        rows.forEach((row) => tbody.appendChild(row));
    </script>
</body>
</html>
