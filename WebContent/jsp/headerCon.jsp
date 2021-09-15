<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="application.servlet.VoirCreerUserServlet"%>
<%@page import="application.servlet.ListeProduitsServlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container">
	<div class="col">
		<img src="img/photo.jpg" width="100px" />
	</div>
	<div class="col">
		<h1>GET WELL SOON</h1>
		<h2>Chat - Aliments - Accesoires</h2>
	</div>
	<div class="col">
		<a href="VoirCreerUserServlet"><img src="img/addUser.png" width="80px" alt="img" /></a>
		<a href="ConnexionServlet"><img src="img/login.png" 	width="80px" alt="img" /></a>
	</div>
</div>
<hr />
<div class="menu" style="padding-left:750px; padding-Right: 750px;">
	<div class="col" >
		<h2>
			<a href="ListeProduitsServlet"><img src="img/nosProduits.png" width="60px" alt="img" /></a>
		</h2>
	</div>
</div>
<hr />
