<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="model.*"%>
<%@ page import="controller.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%@ include file="incFile.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新規コース登録画面</title>
<style>
<!--
table {
	margin: auto;
}

caption {
	color: #009967;
	font-size: 18pt;
}

th {
	text-align: left;
	background: #A4FFDB;
	color: #007B66;
}

td {
	background: #E3FFE3;
}

th#bottom {
	text-align: center;
}

p {
	text-align: center;
}
-->
</style>

<script type="text/javascript">
<!--
	function dataCheck(obj) {
		var msg = "";
		if (obj.courseName.value.length < 1) {
			msg += "コース名を入力してください。\n";
		}
		if (!obj.price.value.match(/^[0-9]+$/g)) {
			msg += "価格を数値で入力してください。\n";
		}
		var i;
		for (i = 0; i < obj.orderFlg.length; i++) {
			if (obj.orderFlg[i].checked)
				break;
		}
		if (i >= obj.orderFlg.length) {
			msg += "オーダーの可否をチェックしてください\n";
		}
		if (msg.length > 0) {
			alert(msg);
			return false;
		} else {
			return true;
		}
	}
//-->
</script>
</head>
<body>
	<%
		int typeId;
		try {
			typeId = Integer.parseInt(request.getParameter("typeId"));
		} catch (NumberFormatException e) {
			typeId = 100;
		}
	%>
	<jsp:useBean id="typeMenuList" class="java.util.ArrayList"
		scope="request" />

	<table border>
		<caption>新しいコースを追加</caption>
		<p align="center"><%=fmtNull((String) request.getAttribute("msg"))%></p>

		<form action="CourseOperationSvl" method="post"
			onSubmit="return dataCheck(this);">
			<tr>
				<th>コース名</th>
				<td><input type="text" name="courseName" size="30"
					maxlength="30" style="ime-mode: active;" value="" /></td>
			</tr>
			<tr>
				<th>価格</th>
				<td><input type="text" name="price" size="6" maxlength="6"
					style="ime-mode: active;" value="" /></td>
			</tr>
			<tr>
				<th>オーダー可</th>
				<td><input type="radio" name="orderFlg" value="1" />可 <input
					type="radio" name="orderFlg" value="0" />不可</td>
			</tr>
			<tr>
				<th>コメント</th>
				<td><textarea name="detail" cols="30" rows="4"
						style="ime-mode: active;"></textarea></td>
			</tr>
			<tr>
				<th>前菜</th>
				<td><select name="appetizerId">
						<option value="0"></option>
						<%
							ArrayList<Menu> al = (ArrayList<Menu>) typeMenuList.get(0);
							for (Menu m : al) {
						%>
						<option value="<%=m.getMenuId()%>">
							<%=m.getMenuName()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>

			<tr>
				<th>スープ</th>
				<td><select name="soupId">
						<option value="0"></option>

						<%
							ArrayList<Menu> al1 = (ArrayList<Menu>) typeMenuList.get(1);
							for (Menu m : al1) {
						%>
						<option value="<%=m.getMenuId()%>">
							<%=m.getMenuName()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>パスタ</th>
				<td><select name="pastaId">
						<option value="0"></option>

						<%
							ArrayList<Menu> al2 = (ArrayList<Menu>) typeMenuList.get(2);
							for (Menu m : al2) {
						%>
						<option value="<%=m.getMenuId()%>">
							<%=m.getMenuName()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>肉料理</th>
				<td><select name="meatId">
						<option value="0"></option>

						<%
							ArrayList<Menu> al3 = (ArrayList<Menu>) typeMenuList.get(3);
							for (Menu m : al3) {
						%>
						<option value="<%=m.getMenuId()%>">
							<%=m.getMenuName()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>魚料理</th>
				<td><select name="fishId">
						<option value="0"></option>

						<%
							ArrayList<Menu> al4 = (ArrayList<Menu>) typeMenuList.get(4);
							for (Menu m : al4) {
						%>
						<option value="<%=m.getMenuId()%>">
							<%=m.getMenuName()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>デザート</th>
				<td><select name="dessertId">
						<option value="0"></option>

						<%
							ArrayList<Menu> al5 = (ArrayList<Menu>) typeMenuList.get(5);
							for (Menu m : al5) {
						%>
						<option value="<%=m.getMenuId()%>">
							<%=m.getMenuName()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>
			<input type="hidden" name="mode" value="21" /> <input type="hidden"
				name="typeId" value="100" />
			<tr>
				<th colspan="2" id="bottom"><input type="submit" value="登録" /></th>
			</tr>

		</form>
	</table>
	<p>
		<a href="MenuMaintenanceSvl?typeID=100">一覧表示画面へ戻る</a>
	</p>
</body>
</html>