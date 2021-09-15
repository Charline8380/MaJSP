<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="application.servlet.CreerUserServlet"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="messages/application" />
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="css/style2.css" rel="stylesheet" type="text/css" />
<link href="css/accueil.css" rel="stylesheet" type="text/css" />
<title>Creation Compte User</title>
</head>

<body
	style="background: url('img/fondAccueil.png') no-repeat center fixed; background-size: cover;">
	<header>
		<jsp:include page="headerCon.jsp"></jsp:include>
	</header>

	<div class="box1">
		<div class="ajoutProduit">
			<div class="col">
				<h3>CREER COMPTE USER</h3>
			</div>
			<div class="form">
				<form method="post" action="${pageContext.request.contextPath}/CreerUserServlet">
					<input type="text" name="nom" placeholder="nom" /> <input
						type="text" name="prenom" placeholder="prenom" /> <input
						type="text" name="adresse" placeholder="adresse" /> <input
						type="text" name="email" placeholder="email" /> <input
						type="password" name="password" placeholder="mot de passe" />
					<button>CREER COMPTE USER</button><br/>
					<p style="color: Red;">${sessionScope.messageCreerUser}</p>
				</form>
			</div>
		</div>
	</div>

	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>

</html>