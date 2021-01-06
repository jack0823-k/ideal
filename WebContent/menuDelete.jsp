<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "incFile.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>メニューの削除</title>
<style>
<!--
table		{margin: auto;}
caption 	{color: #990000;font-size: 18pt;}
th 			{text-align: left;background: #990000;color: #FFD7D;}
td			{background: #FFD7D;}
th#bottom	{text-align: center;}
p			{text-align: center;}
-->
</style>
</head>
<body>
	<!--文字化け防止-->
	<% request.setCharacterEncoding("utf-8") ;%>
	<!--beansの宣言-->
	<jsp:useBean id = "oneMenu" class = "model.Menu" scope = "request" />
	<% int typeId = oneMenu.getTypeId(); %>

	<table border = "1">
		<caption>メニューの削除</caption>
		<p align ="center"><%= fmtNull((String)request.getAttribute("msg")) %></p>

			<form action = "MenuOperationSvl" method = "post">

				<!--メニュー名の表示 -->
				<tr>
					<th>メニュー名</th>
					<td><jsp:getProperty property = "menuName" name = "oneMenu" /></td>
				</tr>
				<!--価格の表示 -->
				<tr>
					<th>価格</th>
					<td><jsp:getProperty property = "price"  name = "oneMenu" /></td>
				</tr>
				<!--オーダー可不可の表示 -->
				<tr>
					<th>オーダー可</th>
					<%
					String order = "オーダー不可";
					if(oneMenu.getOrderFlg() == 1){
						order = "オーダー可";
					}
				%>
				<td>
					<%=order%>
				</td>

				</tr>
				<!--分類の表示 -->
				<tr>
					<th>分類</th>
					<td><jsp:getProperty property="typeName" name="oneMenu" /></td>
				</tr>
				<!--コメントの表示 -->
				<tr>
					<th>コメント</th>
					<td><%=fmtNull(oneMenu.getDetail())%></td>
				</tr>
				<tr>
					<th colspan="2" id="bottom"><input type="submit" value="メニューを削除" /></th>
				</tr>
								<input type ="hidden" name="mode" value="13"/>
				<input type ="hidden" name="typeId" value="<jsp:getProperty name ="oneMenu" property="typeId"/>"/>
				<input type ="hidden" name="menuId" value="<jsp:getProperty name ="oneMenu" property="menuId"/>"/>
			</form>
	</table>
	<p>
	<a href="#" onclick="window.history.back()">一覧表示画面へ戻る</a>
	</p>
</body>
</html>