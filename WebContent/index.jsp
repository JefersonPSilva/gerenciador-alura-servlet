<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	Bem vindo ao gerenciador de empresas!
	<br><br>
	<c:if test="${not empty usuarioLogado}">
		Logado como ${usuarioLogado.email}
	</c:if>
	<br><br>
	<!-- form criar nova empresa -->
	<form action="novaEmpresa" method="POST">
		Nome: <input type="text" name="nome">
		<input type="submit" value="Enviar">
	</form>
	<br><br>
	<!-- form login usuário -->
	<form action="login" method="POST">
		Email: <input type="email" name="email">
		Senha: <input type="password" name="senha"> 
		<input type="submit" value="Enviar">
	</form>
	<br><br>
	<!-- form para logout -->
	<form action="logout" method="POST">
		<input type="submit" value="Logout">
	</form>
</body>
</html>