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
		<b> Añadir Tema</b>
	</h2>
	<form action="addTema" method="post">
		<p>
			Titulo: <input name="titulo" type="text" value="" />
		</p>
		<p>
			Descripción: <input name="nombre" type="text" value="" /></p>
		<p>
			Voto: <input name="votos" type="text" value="" />
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
