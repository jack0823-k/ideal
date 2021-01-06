<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.sun.swing.internal.plaf.metal.resources.metal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controller.MenuDeleteSvl"%>
<%@page import="controller.MenuOperationSvl"%>
<%@page import="model.Menu"%>
<%@ page import="model.MenuType"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<%@ include file="incFile.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu Maintenance</title>
<style type="text/css">
<!--
table {
	text-align: center;
	margin: auto;
}

caption {
	font-size: 18pt;
	color: #009967;
}

tr#data0 {
	background: #E3FFE3;
}

tr#data1 {
	background: #A4FFDB;
}

th#data2 {
	background: #007B66;
	line-height: 35px
}

th {
	background: #007B66;
	color: #ECFFF3;
}

td {
	text-align: left;
	vertical-align: top;
	white-space: nowrap;
}

td#outer {
	padding: 10px;
	background: #FAFFE3;
}

#code {
	width: 40px;
	text-align: center;
}

#menu {
	width: 250px;
}

#price {
	width: 60px;
	text-align: right;
	padding-right: 5px;
}

#comm {
	width: 400px;
}

#ord {
	width: 100px;
	text-align: center;
}

#btn {
	width: 100px;
}

h1 {
	text-align: center;
	background: #007B66;
	color: #ECFFF3;
}

div#type1 {
	width: 150px;
	border: solid gray 1px;
	background: #E3FFE3;
	color: #007B53;
	padding: 2px;
	cursor: pointer;
	margin-top: 5px;
}

div#type2 {
	width: 150px;
	border: solid gray 1px;
	background: #007B53;
	color: #E3FFE3;
	padding: 2px;
	cursor: pointer;
	margin-top: 5px;
}

.button {
	display: inline-block;
	border-radius: 5%; /* 角丸       */
	font-size: 10pt; /* 文字サイズ */
	text-align: center; /* 文字位置   */
	cursor: pointer; /* カーソル   */
	padding: 5px 5px; /* 余白       */
	background: #e7e7e7; /* 背景色     */
	color: #000000; /* 文字色     */
	line-height: 1em; /* 1行の高さ  */
	transition: .3s; /* なめらか変化 */
	box-shadow: 7px 7px 5px #666666; /* 影の設定 */
	border: 2px solid #e7e7e7; /* 枠の指定 */
	font-weight: bold;
}

.button:hover {
	box-shadow: none; /* カーソル時の影消去 */
	opacity: 0.95;
}

.bluebutton {
	display: inline-block;
	border-radius: 20%; /* 角丸       */
	font-size: 9pt; /* 文字サイズ */
	text-align: center; /* 文字位置   */
	cursor: pointer; /* カーソル   */
	padding: 5px 5px; /* 余白       */
	background: rgba(0, 123, 102, 0.79); /* 背景色     */
	color: #ffffff; /* 文字色     */
	line-height: 1em; /* 1行の高さ  */
	transition: .3s; /* なめらか変化 */
	box-shadow: 4px 4px 3px #666666; /* 影の設定 */
	border: 2px solid rgba(0, 0, 102, 0.46); /* 枠の指定 */
}

.bluebutton:hover {
	box-shadow: none; /* カーソル時の影消去 */
	color: rgba(0, 123, 102, 0.79); /* 背景色     */
	background: #ffffff; /* 文字色     */
}

.redbutton {
	display: inline-block;
	border-radius: 20%; /* 角丸       */
	font-size: 9pt; /* 文字サイズ */
	text-align: center; /* 文字位置   */
	cursor: pointer; /* カーソル   */
	padding: 5px 5px; /* 余白       */
	background: rgba(225, 19, 19, 0.72); /* 背景色     */
	color: #ffffff; /* 文字色     */
	line-height: 1em; /* 1行の高さ  */
	transition: .3s; /* なめらか変化 */
	box-shadow: 4px 4px 3px #666666; /* 影の設定 */
	border: 2px solid rgba(255, 0, 0, 0.52); /* 枠の指定 */
}

.redbutton:hover {
	box-shadow: none; /* カーソル時の影消去 */
	color: rgba(225, 19, 19, 0.72); /* 背景色     */
	background: #ffffff; /* 文字色     */
}
-->
</style>
</head>
<body>

	<h1>=== メニューマスターメンテナンス ===</h1>

	<!-- Beanを生成(typeID,menuID,modeの3種類) -->
<%
	ArrayList<MenuType> mType = (ArrayList<MenuType>)request.getAttribute("mType");
	ArrayList<Menu> menu = (ArrayList<Menu>)request.getAttribute("menu");
	String mode = (String)request.getAttribute("mode");
%>
		<p align="center"><%=fmtNull((String) request.getAttribute("msg"))%></p>

	<table align="left" style="border-collapse: collapse">

		<!-- TODO:メッセージの表示メソッド -->

		<%
			//左側のメニュータイプ欄を表示する
			for (int i = 0; i < mType.size(); i++) {
				MenuType mt = (MenuType) mType.get(i);
				String divId = null;
				if (request.getParameter("typeId") != null) {
					if (Integer.parseInt(request.getParameter("typeId")) == mt
							.getTypeId()) {
						divId = "type2";
					} else {
						divId = "type1";
					}
				} else {
					if (100 == mt.getTypeId()) {
						divId = "type2";
					} else {
						divId = "type1";
					}
				}
		%>
		<tr>
			<td>
				<form id="frm<%=i%>" name="frm<%=i%>"
					action="MenuMaintenanceSvl" method="post">

					<input type="hidden" name="typeId" value="<%=mt.getTypeId()%>" />
					<div id="<%=divId%>" onclick="document.frm<%=i%>.submit();"><%=mt.getTypeName()%></div>
				</form>
			</td>
		</tr>
		<%
			}
		%>

	</table>

	<%
		//価格の表示用
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		//オーダー可不可の表示
		String[] order = { "不可", "可" };
	%>

	<!-- 一覧表 -->
	<table>
		<tr>
			<th id="id">ID</th>
			<th id="menu" width="400">メニュー</th>
			<th id="price">価格</th>
			<th id="comment" width="500">コメント</th>
			<th id="order">オーダー可</th>
			<th id="button" colspan="2"></th>
		</tr>

		<%
			for (int i = 0; i < menu.size(); i++) {
				Menu m = (Menu) menu.get(i);
		%>
		<tr id="data<%=i % 2%>">
			<td id="id"><%=m.getMenuId()%></td>
			<td id="menu"><%=m.getMenuName()%></td>
			<td id="price"><%=nf.format(m.getPrice())%></td>
			<td id="comment"><%=fmtNull(m.getDetail())%></td>
			<td id="order"><%=order[m.getOrderFlg()]%></td>
			<td>
				<form id="frmUpdate" name="frmUpdate" action="MenuUpdateSvl"
					method="post">
					<input type="hidden" name="mode"
						value="<%=MenuOperationSvl.UPDATE%>" /> <input type="hidden"
						name="typeId" value="<%=m.getTypeId()%>" /> <input
						type="hidden" name="menuId" value="<%=m.getMenuId()%>" /> <input
						type="submit" value="更新" class="bluebutton" />
				</form>
			</td>
			<td>
				<form id="frmDelete" name="frmDelete" action="MenuDeleteSvl"
					method="post">
					<input type="hidden" name="mode"
						value="<%=MenuOperationSvl.DELETE%>" /> <input type="hidden"
						name="typeId" value="<%=m.getTypeId()%>" /> <input
						type="hidden" name="menuId" value="<%=m.getMenuId()%>" /> <input
						type="submit" value="削除" class="redbutton" />
				</form>
			</td>
		</tr>
		<%
			}
		%>
		<tr height="40">
			<form action="MenuInsertSvl" method="post">
				<th colspan="7" id="data2"><input type="hidden" name="typeId"
					value="<%=request.getParameter("typeId")%>" /> <input
					type="hidden" name="mode" value="<%=MenuOperationSvl.INSERT%>" />
					<input type="submit" value="新しいメニューの追加" class="button" /></th>
			</form>
		</tr>
	</table>
	<br />
		<div align="center"><a href="adminIndex.jsp">管理者メニューへ戻る</a></div>

</body>
</html>