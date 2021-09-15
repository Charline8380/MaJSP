<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="application.servlet.BoutonAjouterPanierServlet"%>
<%@page import="application.servlet.BoutonDiminuerPanierServlet"%>
<%@page import="application.servlet.BoutonSupprimerDuPanierServlet"%>
<%@page import="application.servlet.ConnexionServlet"%>
<%@page import="application.servlet.CreerProduitServlet"%>
<%@page import="application.servlet.CreerUserServlet"%>
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