<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="application.servlet.BoutonAjouterPanierServlet"%>
<%@page import="application.servlet.BoutonDiminuerPanierServlet"%>
<%@page import="application.servlet.BoutonSupprimerDuPanierServlet"%>
<%@page import="application.servlet.ConnexionServlet"%>
<%@page import="application.servlet.CreerProduitServlet"%>
<%@page import="application.servlet.DeconnexionServlet"%>
<%@page import="application.servlet.DetailProduitServlet"%>
<%@page import="application.servlet.ListeProduitsServlet"%>
<%@page import="application.servlet.ModifierProduitServlet"%>
<%@page import="application.servlet.SupprimerProduitServlet"%>
<%@page import="application.servlet.ValiderPanierServlet"%>
<%@page import="application.servlet.ViderPanierServlet"%>
<%@page import="application.servlet.VoirAchatsServlet"%>
<%@page import="application.servlet.VoirCompteUserServlet"%>
<%@page import="application.servlet.VoirCreerProduitServlet"%>
<%@page import="application.servlet.VoirModifierProduitServlet"%>
<%@page import="application.servlet.VoirPanierServlet"%>

<%@page import="application.bean.AchatDto"%>
<%@page import="application.bean.AchatInfo"%>
<%@page import="application.bean.Panier"%>
<%@page import="application.bean.Produit"%>
<%@page import="application.bean.User"%>

<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="messages/application" />

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Liste des Produits</title>
</head>

<body
	style="background: url('img/fondEcran.png') no-repeat center fixed; background-size: cover;">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="box1">
		<div class="produit">
			<h1>NOS PRODUITS</h1>
			<br>
		
			<jsp:useBean id="ListeProduits" type="java.util.List<application.bean.Produit>" scope="session"></jsp:useBean>

			<c:if test="${ ListeProduits == null}">
				${"PAS DE RESULTAT ! "}
			</c:if>
		
			<c:if test="${ ListeProduits != null}">
				<c:forEach items="${ListeProduits}" var="produit">
					<div class="item">
						<a href="AjouterPanierServlet?id=${produit.getIdProduit()}"><img src="img/addPan.png" width="30px" alt="img" /></a><br /> 
						<img src="${produit.getLienImage()}" width="200px" />
						<h4>${produit.getDesignation()}</h4>
						<a href="DetailProduitServlet?id=${produit.getIdProduit()}"><img src="img/detail.png" width="30px" alt="img" /></a> 
						<a href="VoirModifierProduitServlet?id=${produit.getIdProduit()}"><img src="img/modifier.png" width="30px" alt="img" /></a> 
						<a href="SupprimerProduitServlet?id=${produit.getIdProduit()}"><img src="img/effacer.png" width="30px" alt="img" /></a>
					</div>
				</c:forEach>
			</c:if>
		
		</div>
	</div>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>

</html>