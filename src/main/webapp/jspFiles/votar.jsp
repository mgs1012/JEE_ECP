
<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Votar</title>

</head>
<body>
	<h2>
		<b> Votar Tema</b>
	</h2>
	<c:set var="tView" scope="request" value="${seleccionarTema}" />
	<div>${tView.update()}</div>

	<form name="formulario" action="/Votaciones/jsp/votar" method="post">
		<p>
			Tema seleccionado:<input name="nombreDelTema" type="text" value="${tView.tema.titulo}" hidden/>${tView.tema.titulo}<br/>
			Pregunta: <input name="pregunta" type="text" value="${tView.tema.pregunta}" hidden />${tView.tema.pregunta}

		</p>
		<p>
			 Nivel Estudios: <select name="nivelEstudios">
				<c:forEach var="nivelEstudios" items="${tView.listaNivelEstudios}">
					<option value="${nivelEstudios}">${nivelEstudios}</option>
				</c:forEach>
			</select> 
		</p>
<!-- 		<p> -->
<%-- 			<input name="valoracion" type="text" required />${tView.errorMsg} --%>
<!-- 		</p> -->
		<p>
			Valor votación: <select name="valoracion">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
		</p>
		<p>
		<input type="submit" value="Enviar votación" />
		</p>
	</form>
	<p>
		<a href="home">Volver</a>
	</p>

</body>
</html>