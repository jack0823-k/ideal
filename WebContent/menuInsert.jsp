<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="controller.MenuOperationSvl"%>
<%@page import="model.MenuType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ include file="incFile.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新規メニュー登録画面</title>
	<style>
	<!--
		table 		{margin: auto;}
		caption 	{color: #009967; font-size: 18pt;}
		th 			{text-align: left; background: #A4FFDB; color: #007B66;}
		td			{background: #E3FFE3;}
		th#bottom 	{text-align: center;}
		p			{text-align: center;}
-->
	</style>

<script type="text/javascript">
<!--
	function dataCheck(obj) {
		var msg = "";
		if (obj.menuName.value.length < 1) {
			msg += "メニュー名を入力してください。\n";
		}
		if (!obj.price.value.match(/^[0-9]+$/g)) {
			msg += "価格を数値で入力してください。\n";
		}
		var i;
		for (i = 0; i < obj.orderFlg.length; i++) {
			if (obj.orderFlg[i].checked) {
				break;
			}
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
	try{
		typeId = Integer.parseInt(request.getParameter("typeId"));
	}catch(NumberFormatException e){
		typeId = 100;
	}
%>

<jsp:useBean id="mType" class = "java.util.ArrayList" scope = "request"/>
<jsp:useBean id="menu" class = "java.util.ArrayList" scope = "request"/>
<table border>
	<caption>新しいメニューを追加</caption>
	 <p align ="center"><%= fmtNull((String)request.getAttribute("msg")) %></p>

	<form action = "MenuOperationSvl" method = "post" onSubmit = "return dataCheck(this);">
	<tr>
		<th>メニュー名</th>
		<td><input type = "text" name = "menuName" size = "30"/></td>
	</tr>
	<tr>
		<th>価格</th>
		<td><input type = "text" name = "price" size = "6"/></td>
	</tr>
	<tr>
		<th>オーダー可</th>
		<td>
			<input type = "radio" name = "orderFlg" value = "1" size = "30"/>可
			<input type = "radio" name = "orderFlg" value = "0" size = "30"/>不可
		</td>
	</tr>
	<tr>
		<th>分類</th>
		<td>
			<select name = "typeId">
<%
			for(Object o : mType){
				MenuType mt = (MenuType)o;
				if(mt.getTypeId() == 100){
					continue;
				}
				String selected = "";
				if(typeId == mt.getTypeId()){
					selected = "selected";
				}else{
					selected = "";
				}
%>
			<option value = "<%=((MenuType)o).getTypeId() %>"<%= selected %>>
			<%= ((MenuType)o).getTypeName() %></option>
<%
}
%>
			</select>
		</td>
	</tr>
	<tr>
		<th>コメント</th>
		<td><textarea name="detail" cols="30" rows="4"
						style="ime-mode: active;"></textarea></td>
	</tr>
		<input type = "hidden" name = "mode" value = "<%= MenuOperationSvl.INSERT %>" />
	<tr>
		<th colspan = "2" id = "bottom"><input type = "submit" value = "メニューを追加"/></th>
	</tr>
	</form>
</table>
<p><a href = "MenuMaintenanceSvl">一覧表示画面へ戻る</a></p>
</body>
</html>