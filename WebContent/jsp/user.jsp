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

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Compte User</title>
</head>
<body
	style="background: url('img/fondEcran.png') no-repeat center fixed; background-size: cover;">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>

	<div class="box1">
		<jsp:useBean id="User" scope="session" type="application.bean.User"></jsp:useBean>
		<h3>
			COMPTE USER<br />${User.getNom()}</h3>
		<div class="detail">
			<div class='item' style="width: 300px">
				<div class="col">
					<img src="img/sign.png" width="200px" alt="img" />
				</div>
			</div>
			<div class='item' style="width: 500px">
				<div class="col" style="text-align: left;">
					<p>Id User : ${User.getId()}</p>
					<p>Nom : ${User.getNom()}</p>
					<p>Prenom : ${User.getPrenom()}</p>
					<p>Adresse: ${User.getAdresse()}</p>
					<p>Email : ${User.getEmail()}</p>
					<p>Mot de Passe : ${User.getMotDePasse()}</p>
				</div>
			</div>
		</div>
	</div>


	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>