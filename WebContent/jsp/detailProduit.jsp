<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="application.servlet.BoutonAjouterPanierServlet"%>
<%@page import="application.servlet.ConnexionServlet"%>
<%@page import="application.servlet.CreerProduitServlet"%>
<%@page import="application.servlet.DeconnexionServlet"%>
<%@page import="application.servlet.DetailProduitServlet"%>
<%@page import="application.servlet.ListeProduitsServlet"%>
<%@page import="application.servlet.ModifierProduitServlet"%>
<%@page import="application.servlet.SupprimerProduitServlet"%>
<%@page import="application.servlet.VoirAchatsServlet"%>
<%@page import="application.servlet.VoirCompteUserServlet"%>
<%@page import="application.servlet.VoirCreerProduitServlet"%>
<%@page import="application.servlet.VoirModifierProduitServlet"%>
<%@page import="application.servlet.VoirPanierServlet"%>
<%@page import="application.bean.Produit"%>
<%@page import="application.bean.User"%>
<%@page import="application.bean.Panier"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Detail Produit</title>
</head>

<body
	style="background: url('img/fondEcran.png') no-repeat center fixed; background-size: cover;">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="box1">

		<jsp:useBean id="Produit" scope="session" type="application.bean.Produit"></jsp:useBean>

		<h1>
			DETAIL PRODUIT <br />${Produit.getDesignation()}</h1>
		<br />
		<c:if test="${ Produit == null}">
				${"PAS DE RESULTAT ! "}
		</c:if>
		<c:if test="${ Produit != null}">
			<br>
			<div class="detail">
				<div class='item' style="width: 300px">
					<div class="col">
						<img src="${Produit.getLienImage()}" width="200px" />
					</div>
				</div>
				<div class='item' style="width: 500px">
					<div class="col" style="text-align: left;">
						<p>Id Produit : ${Produit.getIdProduit()}</p>
						<p>Designation : ${Produit.getDesignation()}</p>
						<p>Categorie : ${Produit.getCategorie()}</p>
						<p>Prix : ${Produit.getPrix()}</p>
						<p>Description : ${Produit.getDescription()}</p>
					</div>
				</div>
			</div>
		</c:if>
	</div>

	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>

</html>