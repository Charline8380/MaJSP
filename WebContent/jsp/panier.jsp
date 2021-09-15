<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Panier</title>
</head>

<body
	style="background: url('img/fondEcran.png') no-repeat center fixed; background-size: cover;">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="box1">
		<h1>MON PANIER</h1>
		<HR />
		<br>
		<!-- recuperer le panier dans la session -->
		<jsp:useBean id="Panier" scope="session"
			type="application.bean.Panier"></jsp:useBean>

		<!-- si panier vide afficher panier vide -->
		<c:if test="${Panier.getMapDesProduitsQte().size() == 0}">
				${"PANIER VIDE ! "}
			</c:if>

		<!-- sinon afficher panier -->
		<c:if test="${ Panier.getMapDesProduitsQte().size() > 0 }">
			
			<table style="width: 100%; text-align: center">

				<!-- entête du  panier -->
				<tr>
					<th>DESIGNATION</th>
					<th>QUANTITE</th>
					<th>PRIX UNITAIRE</th>
					<th>MODIFIER QTE</th>
					<th>PRIX TOTAL</th>
					<th></th>
				</tr>

				<!-- corp du panier -->
				<c:forEach items="${Panier.mapDesProduitsQte}" var="type">
					<tr>
						<td>${type.key.getDesignation()}<br /> <img
							src="${type.key.getLienImage()}"
							width="60px" /></td>
						<td>${type.value.getQuantite()}</td>
						<td>${type.key.getPrix()}</td>
						<td>
						<!-- Corriger bug de recupération quantité pour les boutton ajouter/diminuer/supprimerDupanier -->
						 <a	href="BoutonAjouterPanierServlet?id=${type.key.getIdProduit()}"><img src="img/ajoutQtePan.png" width="35px" alt="img" /></a>
						<a href="BoutonDiminuerPanierServlet?id=${type.key.getIdProduit()}"><img src="img/dimQtePan.png" width="35px" alt="img" /></a>
						</td>
						<td>${type.value.getPrixParProduit()}</td>
						<td>
							<div style="float: right">
								<a href="BoutonSupprimerDuPanierServlet?id=${type.key.getIdProduit()}"><img src="img/suppDuPan.png" width="35px" alt="img" /></a>
							</div>

						</td>
					</tr>
				</c:forEach>
			</table>

			<!-- montants et remise du panier -->
			<table
				style="border-top: 2px solid black; align: right; text-align: right;">
				<tr>
					<th>TOTAL AVANT REMISE</th>
					<td>${sessionScope.Panier.getTotalAvantRemise()}</td>
				</tr>
				<tr>
					<th>Remise</th>
					<td>${sessionScope.Panier.getRemise()}</td>
				</tr>
				<tr>
					<th>TOTAL APRES REMISE</th>
					<td>${sessionScope.Panier.getTotalApresRemise()}</td>
				</tr>
			</table>
			<br />

			<!-- vider ou valider panier -->
			<div align="right">
				<a href="ViderPanierServlet"><img src="img/suppPan.png"
					width="50px" alt="img" /></a> <a href="ValiderPanierServlet"><img
					src="img/validePan.png" width="50px" alt="img" /></a>
			</div>
		</c:if>
		<br /> <br />

	</div>

	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>

</html>