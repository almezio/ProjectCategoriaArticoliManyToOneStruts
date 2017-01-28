<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/show.css" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Elenco Articoli</title>
</head>
<body>
	<div class="styleShow">
		<h1><s:property value="message"/></h1>		
		<table>
			<tr>
				<th><p>Id Articolo</p></th>
				<th><p>Desc Articolo</p></th>
				<th><p>Prezzo</p></th>
				<th></th>
			</tr>
			
			<s:iterator value="articoli" var="articolo">
		  	<tr>
		  		<td><p><s:property value="#articolo.idArticolo"/></p></td>
					<td><p><s:property value="#articolo.descArticolo"/></p></td>
					<td><p><s:property value="#articolo.prezzoArticolo"/></p></td>
					<td><s:form method="post" action="deleteArticolo"><input type="hidden" name="idArticoloForm" value="<s:property value="#articolo.idArticolo"/>"><input type="submit" value="elimina"/></s:form></td>
				</tr>
			</s:iterator>			
		</table>
		<br>
		<br>
			<center>
				<a href="<s:url action="templateTiles" />"> Torna alla pagina iniziale</a>
			</center>			
	</div>
</body>
</html>