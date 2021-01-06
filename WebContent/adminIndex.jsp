<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Restaurante IDEALLE</title>
			<style type="text/css">
			<!--
				* 		{padding: 5px;
						margin: 0px;}
				body   	{text-align: center;}
				table  	{width: 510px;
						background: white;
						border: 1px #000000;
						border-collapse: collapse;
						margin: auto;}
				h2	   	{width: 500px;
						border: 1px solid #000000;
						background: #8FBC8F;
						margin: 0 auto;}
				td		{text-align:left;}
			-->
			</style>
	</head>
	<body>
		<%
		Admin ad = (Admin)session.getAttribute("adminInfo");
		%>

		<h2>Restaurante IDEALLE</h2>
		<br/>

		<h3><%=ad.getAdmName()  %>様、いらっしゃいませ。</h3>
		<br />
        <table align="center">
		<tr><td><a href="MenuMaintenanceSvl">■メニューメンテナンス</a></td></tr>
		<tr><td><a href="AdminReserveListSvl">■予約情報一覧</a></td></tr>
		<tr><td><a href="AdminLogoffSvl">■ログオフ</a></td></tr>

		</table>
		</body>
</html>