<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/message.css" type="text/css" />	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Ricerca Categoria</title>
</head>
<body>
	<div class="styleMessage">
		<p><s:property value="message"/></p>			
		<br>
		<a href="<s:url action="templateTiles" />"> Torna alla pagina iniziale</a>
	</div>
</body>
</html>