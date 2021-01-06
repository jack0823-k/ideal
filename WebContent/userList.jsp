<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="controller.*"%>
<%@ page import="model.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>顧客情報管理画面</title>
<link rel="stylesheet" type="text/css" href="ichirann_a.css"/>
</head>
<body>
	<%
		ArrayList<User> al = (ArrayList<User>) request
				.getAttribute("userList");
	%>
	<h2>顧客情報一覧</h2>
	<br />


	<table border>

	<tr>
		<td id="head">ユーザID</td>
		<td id="head">氏名</td>
		<td colspan="3" id="head"></td>
	</tr>


	<tr>
		<td width="50px"></td>
		<td width="250px"></td>
		<td width="100px"></td>
		<td width="50px"></td>
		<td width="50px"></td>

	</tr>

	<%
		for (User u : al) {
	%>
	<tr>


		<td id="meisai"><%=u.getUsrId()%></td>

		<td id="meisai"><%=u.getUsrName()%></td>
		<form action="AdminReserveListSvl" method="post">
			<td id="meisai">
				<!--1.確認ボタン --> <input type="submit"
				value="予約確認" /> <input type="hidden" name="usrId"
				value="<%=u.getUsrId()%>" />
			</td>
		</form>

		<form action="AdminUserUpdateSvl" method="post">
			<td id="meisai">
				<!--1.更新ボタン  --> <input type="submit"
				value="変更" /> <input type="hidden" name="usrId"
				value="<%=u.getUsrId()%>" />
			</td>
		</form>
		<form action="AdminUserDeleteSvl" method="post">
			<td id="meisai">
				<!--2.削除ボタン --> <input type="submit"
				value="削除" /> <input type="hidden" name="usrId"
				value="<%=u.getUsrId()%>" />
			</td>
		</form>
	</tr>

	<%
		}
	%>


	<tr>
		<td colspan="10" id="boder">

			<form action="userInsert.jsp" method="post">

				<input type="submit" value="新規顧客追加" />
			</form>
		</td>
	</tr>
	</table>
	<br />
	<br />

	<p id="boder">
		<a href="adminIndex.jsp">戻る</a>
	</p>
</body>
</html>