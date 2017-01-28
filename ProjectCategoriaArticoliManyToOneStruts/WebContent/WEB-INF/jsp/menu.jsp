<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Homepage Articoli</title>
</head>
<body>
  <div class="styleMenu">
	  <a href="<s:url action="main_categoriaTiles" />">Crea una nuova categoria</a><br>
		<a href="<s:url action="main_categoriaUpdateTiles" />">Aggiorna una categoria</a><br>
		<a href="<s:url action="main_articoloTiles" />">Crea un nuovo articolo</a><br>
		<a href="<s:url action="getAllCategorie" />">Cerca tutte le categorie</a><br>
		<a href="<s:url action="main_ricercaArtFromCategoriaTiles" />">Cerca articoli da categoria</a><br>
	</div>
</body>
</html>