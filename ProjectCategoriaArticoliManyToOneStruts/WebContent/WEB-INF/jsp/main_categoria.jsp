<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" />			      
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Categoria</title>
</head>
<body>
 	<div class="styleMain">
		<s:form action="createCategoria">
			<table>				
				<tr>					
					<td width="90%"><s:textfield label="descCategoria" key="descCategoria" size="70"/></td>
				</tr>
				<tr>					
					<td width="90%"><div align="right"><s:submit/></div></td>
				</tr>
			</table>
		</s:form> 
	</div>
</body>
</html>