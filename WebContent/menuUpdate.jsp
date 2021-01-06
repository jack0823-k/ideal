<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="javax.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import="controller.MenuOperationSvl"%>
<%@page import="model.MenuType"%>
<%@ include file ="incFile.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>メニューの更新</title>
			<style>
			<!--
				table{margin:auto;}
				caption{color:#006799;font-size:18pt;}
				th{text-align:left;background:#006799;color:#C8EDFF;}
				td{background:#C8EDFF;}
				th#bottom{text-align:center;}
				p{text-align:center;}
			-->
			</style>
			<script type="text/javascript">
			<!--
				function dataCheck(obj){
					var msg = "";
					if(obj.menuName.value.length < 1){
						msg += "メニュー名を入力してください。\n";
					}
					if(!obj.price.value.match(/^[0-9]+$/g)){
						msg += "価格を数値で入力してください。\n";
					}
					var i;
					for(i = 0 ; i < obj.orderFlg.length ; i++){
						if(obj.orderFlg[i].checked){
							break;
						}
					}
					if(i >= obj.orderFlg.length){
						msg += "オーダーの可否をチェックしてください\n";
					}
					if(msg.length > 0){
						alert(msg);
						return false;
					}else{
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
				typeId = 200;
			}
		%>
		<jsp:useBean id="oneMenu" class = "model.Menu" scope="request"/>
		<jsp:useBean id="mType" class = "java.util.ArrayList" scope="request"/>

		<form id="frm1" name="frm1" method="post" action="MenuOperationSvl"
			                                                 onsubmit="return dataCheck(this)">
				<table border>
					<caption>メニューの更新</caption>
					<p align ="center"><%= fmtNull((String)request.getAttribute("msg")) %></p>

					<tr>
						<th>メニュー名</th>
						<td>
						<input type = "text" name = "menuName" value="<jsp:getProperty name ="oneMenu" property="menuName"/>" size="30"/>
						</td>
						</tr>
					<tr>
						<th>価格</th>
						<td><input type ="text" name="price" value="<jsp:getProperty name ="oneMenu" property="price"/>" size="6"/></td>
					</tr>
					<tr>
						<th>オーダー可</th>
							<td>
								<%if(oneMenu.getOrderFlg()==1){ %>
								<input type="radio" name="orderFlg" value="1" checked ="checked"/>可
								<input type="radio" name="orderFlg" value="0"/>不可
								<%} %>
								<%if(oneMenu.getOrderFlg()==0){ %>
								<input type="radio" name="orderFlg" value="1"/>可
								<input type="radio" name="orderFlg" value="0" checked ="checked"/>不可
								<%} %>
							</td>
					</tr>
					<tr>
						<th>分類</th>
						<td><select name="typeId">
						<%
							for(Object o : mType){
								MenuType mt = (MenuType)o;
								if(mt.getTypeId() == 100){
									continue;
								}
								String selected = "";
								if(typeId == mt.getTypeId()){
									selected = "selected";
								}
						%>
							<option value="<%= mt.getTypeId() %>" <%= selected %>><%= mt.getTypeName() %></option>
						<% } %>
							</select></td>
					</tr>
						<tr>
						<th>コメント</th>
						<td>
						<textarea name="detail" cols="30" rows="4"><%=fmtNull( oneMenu.getDetail())%></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" id="button"><input type ="submit" value ="メニューを更新"/></td>
					</tr>
					<tr>
						<td colspan="2"><a href="#" onclick="window.history.back()">一覧表示画面へ戻る</a></td>
					</tr>
				</table>
				<input type ="hidden" name="mode" value="<%= MenuOperationSvl.UPDATE %>"/>
				<input type ="hidden" name="typeId" value="<jsp:getProperty name ="oneMenu" property="typeId"/>"/>
				<input type ="hidden" name="menuId" value="<jsp:getProperty name ="oneMenu" property="menuId"/>"/>
		</form>

	</body>
</html>