<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container">
	<div class="col">
		<a href="page.html"> <img src="img/photo.jpg" width="100px" />
		</a>
	</div>
	<div class="col">
		<h1>GET WELL SOON</h1>
		<h2>Chat - Aliments - Accesoires</h2>
	</div>
	<div class="col">
		<c:if test="${sessionScope.User == null }">
			<a href="VoirCreerUserServlet"><img src="img/addUser.png"
				width="60px" alt="img" /></a>
			<a href="ConnexionServlet"><img src="img/login.png" width="60px"
				alt="img" /></a>
			<br />
		</c:if>
		<c:if test="${sessionScope.User != null }">
			<a href="VoirCompteUserServlet"><img src="img/sign.png"
				width="40px" alt="img" /></a>
			<a href="DeconnexionServlet"><img src="img/logout.png"
				width="40px" alt="img" /></a>
			<br />
			<hr />
			<a href="VoirPanierServlet"><img src="img/pan.png" width="40px"
				alt="img" /></a>
		</c:if>
	</div>
</div>
<hr />
<div class="menu">
	<c:if test="${sessionScope.User != null }">
		<div class="col">
			<h2>
				<a href="VoirCreerProduitServlet"><img src="img/newProd.png"
					width="60px" alt="img" /></a>
			</h2>
		</div>
		<div class="col">
			<h2>
				<a href="ListeProduitsServlet"><img src="img/nosProduits.png"
					width="60px" alt="img" /></a>
			</h2>
		</div>
		<div class="col">
			<h2>
				<a href="VoirPanierServlet"><img src="img/pan.png" width="60px"
					alt="img" /></a>
			</h2>
		</div>
		<div class="col">
			<h2>
				<a href="VoirAchatsServlet"><img src="img/mesPan.png"
					width="60px" alt="img" /></a>
			</h2>
		</div>
	</c:if>
</div>
<hr />
