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
<title>Ajouter nouveau produit</title>
</head>

<body
	style="background: url('img/fondEcran.png') no-repeat center fixed; background-size: cover;">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="box1">
		<div class="ajoutProduit">
			<div class="col">
				<h3>AJOUTER UN PRODUIT</h3>
			</div>
			<div class="form">
				<form method="post" action="${pageContext.request.contextPath}/CreerProduitServlet">
					
					<input type="text" name="designation" id="" 		placeholder="Désignation Produit" />
					<br/> 
					<select name="categorie" id="categorie1">
						<option value="categorie1" selected>Catégorie 1 - Animal</option>
						<option value="categorie2" selected>Catégorie 2 - Aliment</option>
						<option value="categorie3" selected>Catégorie 3 - Autres</option>
						<option value="categorie0" selected>Choisir la catégorie du produit</option>
					</select>
					<br /> 
					<input type="text" name="prix" id="" placeholder="Prix" />
					<br/>
					<input type="text" name="lienImage" id="" placeholder="url image" />
					<br/>
					<textarea name="description" id="description"
						placeholder="Entrez la description du produit" rows=10 cols=60></textarea>
					<br /><br />
					<button>AJOUTER</button><br/>
					<p style="color: Red;">${sessionScope.messageCreerProduit}</p>
				</form>
			</div>
		</div>
	</div>


	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>

</html>