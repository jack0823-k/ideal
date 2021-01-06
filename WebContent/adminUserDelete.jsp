<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,controller.*,model.*" %>
<%@ include file= "incFile.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>お客様脱会手続き</title>
<style>
<!--
* {
	padding: 5px;
	margin: 0px;
}
h2 {
	width: 590px;
	border: 1px black solid;
	background: #99CC99;
	margin: 0 auto;
}

table {
	width: 600px;
	border-collapse: collapse;
	text-align: center;
}

th {
	background: #99CC99;
	border: 1px black solid;
	padding: 5px;
	text-align: center;
}

td {
	border: 1px black solid;
	padding: 5px;
	text-align: left;
}
td#button {
	border: 1px black solid;
	padding: 5px;
	text-align: right;
}
-->
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		User u= (User)request.getAttribute("user");
		%>

	<center>
		<h2>お客様脱会手続き</h2>

		<form id="frm1" name="frm1" method="post" action="AdminUserOperationSvl">
			<table>
				<tr>
					<th>お客様ＩＤ</th>
					<td> <%= u.getUsrId() %> </td>
				</tr>
				<tr>
					<th>お名前</th>
					<td> <%= u.getUsrName() %> </td>
				</tr>
				<tr>
					<th>ご住所</th>
					<td><%= u.getAddress() %> </td>
				</tr>
				<tr>
					<th>お電話番号</th>
					<td> <%= u.getPhone() %> </td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td> <%= u.getMail() %> </td>
				</tr>
				<tr>
					<td bgcolor="#99CC99" colspan="2" id="button"><font color="red">確認し、退会ボタンをクリックして下さい。</font>
					<input type="submit" value=" 脱 会 " /></td>
					<input type = "hidden" name = "mode" value = "<%= AdminUserOperationSvl.DELETE %>"/>
					<input type="hidden" name="usrId" value="<%= u.getUsrId() %>"/>
				</tr>
			</table>

		</form>
		<br />
		<p>
			<a href="UserList">処理メニューに戻る</a>
		</p>
	</center>
</body>
</html>