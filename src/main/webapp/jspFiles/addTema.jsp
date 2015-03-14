<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Añadir Tema</title>
</head>
<body>
	<h2>
		Vista de <b>Tema</b>
	</h2>
	<c:set var="tView" scope="request" value="${tema}" />
	<div>${pView.update()}</div>
	<form action="addTema" method="post">
		<p>
			Titulo: <input name="titulo" type="text" value="${tView.tema.titulo}" />
		</p>
		<p>
			Descripción: <input name="nombre" type="text"
				value="${tView.tema.nombre}" />${tView.errorMsg}</p>
		<p>
			Voto: <select name="votos">
				<c:forEach var="votos" items="${tView.votos}">
					<option value="${votos}">${votos}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/home">Volver</a>
	</p>
</body>
</html>
