<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,controller.*,model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>顧客情報変更画面</title>
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
#bo{color:red;}
-->
</style>
<script type="text/javascript">
<!--
	function frmCheck() {
		if (document.frm1.userName.value == "") {
			alert("お名前を入力してください。");
			document.frm1.userName.focus();
			return false;
		} else if (document.frm1.password.value == "") {
			alert("パスワードを入力してください。");
			document.frm1.password.focus();
			return false;
		}
	}
//-->
</script>
</head>

<body>
		<%
		request.setCharacterEncoding("utf-8");
		User u= (User)request.getAttribute("user");
		%>
	<center>
		<h2>お客様情報変更</h2>

		<br />
		<%
			request.setCharacterEncoding("utf-8");
			String error = (String) request.getAttribute("msg");
			if (error == null) {
				error = "";
			}
		%>
		<form id="frm1" name="frm1" method="post" action="AdminUserOperationSvl">
			<table>
				<tr>
					<th>お客様ID</th>
					<td><%=u.getUsrId()%></td>
				</tr>
				<tr>
					<th>お名前</th>
					<td><input type="text" name="usrName" value="<%=u.getUsrName()%>" size="30" maxlength="30"/></td>
				</tr>
				<tr>
					<th>ご住所</th>
					<td><input type="text" name="address" value="<%=u.getAddress()%>" size="50" maxlength="200"/></td>
				</tr>
				<tr>
					<th>お電話番号</th>
					<td><input type="text" name="phone" value="<%=u.getPhone()%>" size="15" maxlength="20"/></td>
				</tr>
				<tr>
					<th>E-mail</th>
					<td><input type="text" name="mail" value="<%=u.getMail()%>" size="30" maxlength="100"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="password" name="password" size="8" maxlength="8"/>※変更時入力してください。 </td>
				</tr>
				<tr>
					<td bgcolor="#99CC99" colspan="2" id="button">
					<span id ="bo">
					※は必修入力です。
					</span>
					<input type="submit" value=" 変 更 " /></td>
				</tr>
			</table>
			<input type="hidden" name="usrId" value="<%=u.getUsrId()%>"/>
			<input type="hidden" name="mode"  value="<%=AdminUserOperationSvl.UPDATE%>"/>
		</form>
		<br />
		<p>
			<a href="UserList">処理メニューに戻る</a>
		</p>
	</center>
</body>
</html>