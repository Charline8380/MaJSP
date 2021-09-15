<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="css/style2.css" rel="stylesheet" type="text/css" />
<link href="css/accueil.css" rel="stylesheet" type="text/css" />
<title>Page de Connexion</title>
</head>

<body
	style="background: url('img/fondAccueil.png') no-repeat center fixed; background-size: cover;">
	<header>
		<jsp:include page="headerCon.jsp"></jsp:include>
	</header>
	<div class="login-page">
		<div class="form">
			<form method="post" action="${pageContext.request.contextPath}/ConnexionServlet">
				<input type="text" name="email" placeholder="email" />
				<input type="password" name="motDePasse" placeholder="password" />
				<button>SE CONNECTER</button>
				<br/>
				<c:if test="${sessionScope.User == null }">
					<p style="color: Red">${sessionScope.messageErreur}</p>
				</c:if>
			</form>
		</div>
	</div>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>

</html>