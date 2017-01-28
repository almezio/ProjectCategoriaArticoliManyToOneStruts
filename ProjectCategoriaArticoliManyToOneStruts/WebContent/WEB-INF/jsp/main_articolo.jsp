<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main_articolo.css" type="text/css" />			      
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Articolo</title>
</head>
<body>
 	<div class="styleMainArticolo">
		<s:form action="createArticolo">
			<table>
				<tr>
					<td width="90%"><s:textfield label="descArticolo" key="descArticolo" size="70"/></td>
				</tr>
				<tr>
					<td width="90%"><s:textfield label="prezzoArticolo" key="prezzoArticolo" size="70"/></td>
				</tr>
			</table>
			<br><br>
			<table >
				<tr>
					<th></th>
					<th><p>Id Categoria</p></th>
					<th><p>Descrizione</p></th>		
				</tr>			
				
				<s:iterator value="categorie" var="categoria">
	  			<tr>
						<td>
							<input type="radio" name="idCategoriaForm" value="<s:property value="#categoria.idCategoria"/>"/>
							
						</td>
	  				<td><p><s:property value="#categoria.idCategoria"/></p></td>
						<td><p><s:property value="#categoria.descCategoria"/></p></td>
					</tr>
				</s:iterator>
				<tr>
					<td></td>
	  			<td></td>
					<td><input type="submit" value="conferma"/></td>
				</tr>
			</table>
		</s:form> 
	</div>
</body>
</html>