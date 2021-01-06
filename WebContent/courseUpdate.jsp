<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.stream.Stream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.util.*"%>

<%@ include file="incFile.jsp"%>
<%@ page import="model.*"%>
<%@ page import="controller.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Update Menu</title>
<style>
<!--
table {
	margin: auto;
}

caption {
	color: #006799;
	font-size: 18pt;
}

th {
	text-align: left;
	background: #006799;
	color: #C8EDFF;
}

td {
	background: #C8EDFF;
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
		request.setCharacterEncoding("UTF-8");
		ArrayList<Course> oneCourses = (ArrayList<Course>) request
				.getAttribute("oneCourse");
		Course c = oneCourses.get(0);
		//コース内に格納されているメニューのメニュータイプがあれば、trueが入る変数の宣言
		boolean appetizerId = false;
		boolean soupId = false;
		boolean pastaId = false;
		boolean meatId = false;
		boolean fishId = false;
		boolean dessertId = false;
		for (Course course : oneCourses) {
			if (course.getMenuType() == Course.COURSE_MENU_TYPE_ID[0]) {
				appetizerId = true;
			}
			if (course.getMenuType() == Course.COURSE_MENU_TYPE_ID[1]) {
				soupId = true;
			}
			if (course.getMenuType() == Course.COURSE_MENU_TYPE_ID[2]) {
				pastaId = true;
			}
			if (course.getMenuType() == Course.COURSE_MENU_TYPE_ID[3]) {
				meatId = true;
			}
			if (course.getMenuType() == Course.COURSE_MENU_TYPE_ID[4]) {
				fishId = true;
			}
			if (course.getMenuType() == Course.COURSE_MENU_TYPE_ID[5]) {
				dessertId = true;
			}
		}
	%>
	<jsp:useBean id="typeMenuList" class="java.util.ArrayList"
		scope="request" />

	<table border>
		<caption>コースの更新</caption>
		<p align="center"><%=fmtNull((String) request.getAttribute("msg"))%></p>

		<form action="CourseOperationSvl" method="post"
			onsubmit="return dataCheck(this);">
			<tr>
				<th>コース名</th>
				<td><input type="text" name="courseName"
					value="<%=fmtNull(c.getCourseName())%>" size="30" /></td>
			</tr>
			<tr>
				<th>価格</th>
				<td><input type="text" name="price"
					value="<%=fmtNull(String.valueOf(c.getPrice()))%>" size="10" /></td>
			</tr>
			<tr>
				<th>オーダー可</th>
				<%
					String[] order = { "不可", "可" };
				%>
				<td>
					<%
						for (int i = 0; i < order.length; i++) {
							String checked = "";

							if (c.getOrderFlg() == i) {
								checked = "checked";
							}
					%> <input type="radio" name="orderFlg" value="<%=i%>" <%=checked%> />
					<%=order[i]%>&nbsp;&nbsp;&nbsp; <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<th>コメント</th>
				<td><textarea name="detail" cols="30" rows="4"><%=fmtNull(c.getDetail())%>
        </textarea></td>
			</tr>
			<tr>
				<th>前菜</th>
				<td><select name="appetizerId">
						<option value="0"></option>
						<%
							@SuppressWarnings("unchecked")
							ArrayList<Menu> appetizer = (ArrayList<Menu>) typeMenuList.get(0);
							Course co;
							if (appetizerId) {		//コース内に前菜メニューがあればtrue
								for (int i = 0; i < oneCourses.size(); i++) {
									co = oneCourses.get(i);
									if (co.getMenuType() == Course.COURSE_MENU_TYPE_ID[0]) {//oneCourses内から前菜のMENU_TYPE_ID
										for (Menu m : appetizer) {							//と同じmenuTypeを特定し、selectedを付与
											String selected = "";
											if (co.getMenuId() == m.getMenuId()) {
												selected = "selected";
											}
						//selectedが付与され、プルダウンリストがセレクトされた状態で表示される
						%>
						<option value="<%=m.getMenuId()%>" <%=selected%>>
							<%=m.getMenuName()%>
						</option>
						<%
										}
									}
								}
							}else{		//コース内に前菜がないので、前菜のプルダウンリストを作成するが
								for(Menu m: appetizer){//リストをセレクトせず、先頭の空白リストが選択される
									%>
									<option value="<%=m.getMenuId()%>">
										<%=m.getMenuName()%>
									</option>
									<%
								}
							}
						%>
				</select></td>

			</tr>

			<tr>
				<th>スープ</th>
				<td><select name="soupId">
						<option value="0"></option>
						<%
							@SuppressWarnings("unchecked")

							ArrayList<Menu> soup = (ArrayList<Menu>) typeMenuList.get(1);
						if (soupId) {
							for (int i = 0; i < oneCourses.size(); i++) {
								co = oneCourses.get(i);
								if (co.getMenuType() == Course.COURSE_MENU_TYPE_ID[1]) {
									for (Menu m : soup) {
										String selected = "";
										if (co.getMenuId() == m.getMenuId()) {
											selected = "selected";
										}
					%>
					<option value="<%=m.getMenuId()%>" <%=selected%>>
						<%=m.getMenuName()%>
					</option>
					<%
									}
								}
							}
						}else{
							for(Menu m: soup){
								%>
								<option value="<%=m.getMenuId()%>">
									<%=m.getMenuName()%>
								</option>
								<%
							}
						}
					%>
			</select></td>
			</tr>
			<tr>
				<th>パスタ</th>
				<td><select name="pastaId">
						<option value="0"></option>
						<%
							@SuppressWarnings("unchecked")

							ArrayList<Menu> pasta = (ArrayList<Menu>) typeMenuList.get(2);
							if (pastaId) {
								for (int i = 0; i < oneCourses.size(); i++) {
									co = oneCourses.get(i);
									if (co.getMenuType() == Course.COURSE_MENU_TYPE_ID[2]) {
										for (Menu m : pasta) {
											String selected = "";
											if (co.getMenuId() == m.getMenuId()) {
												selected = "selected";
											}
						%>
						<option value="<%=m.getMenuId()%>" <%=selected%>>
							<%=m.getMenuName()%>
						</option>
						<%
										}
									}
								}
							}else{
								for(Menu m: pasta){
									%>
									<option value="<%=m.getMenuId()%>">
										<%=m.getMenuName()%>
									</option>
									<%
								}
							}
						%>
				</select></td>
			</tr>
			<tr>
				<th>肉料理</th>
				<td><select name="meatId">
						<option value="0"></option>
						<%
							@SuppressWarnings("unchecked")

							ArrayList<Menu> meat = (ArrayList<Menu>) typeMenuList.get(3);
						if (meatId) {
							for (int i = 0; i < oneCourses.size(); i++) {
								co = oneCourses.get(i);
								if (co.getMenuType() == Course.COURSE_MENU_TYPE_ID[3]) {
									for (Menu m : meat) {
										String selected = "";
										if (co.getMenuId() == m.getMenuId()) {
											selected = "selected";
										}
					%>
					<option value="<%=m.getMenuId()%>" <%=selected%>>
						<%=m.getMenuName()%>
					</option>
					<%
									}
								}
							}
						}else{
							for(Menu m: meat){
								%>
								<option value="<%=m.getMenuId()%>">
									<%=m.getMenuName()%>
								</option>
								<%
							}
						}
					%>
			</select></td>
			</tr>
			<tr>
				<th>魚料理</th>
				<td><select name="fishId">
						<option value="0"></option>
						<%
							@SuppressWarnings("unchecked")

							ArrayList<Menu> fish = (ArrayList<Menu>) typeMenuList.get(4);
						if (fishId) {
							for (int i = 0; i < oneCourses.size(); i++) {
								co = oneCourses.get(i);
								if (co.getMenuType() == Course.COURSE_MENU_TYPE_ID[4]) {
									for (Menu m : fish) {
										String selected = "";
										if (co.getMenuId() == m.getMenuId()) {
											selected = "selected";
										}
					%>
					<option value="<%=m.getMenuId()%>" <%=selected%>>
						<%=m.getMenuName()%>
					</option>
					<%
									}
								}
							}
						}else{
							for(Menu m: fish){
								%>
								<option value="<%=m.getMenuId()%>">
									<%=m.getMenuName()%>
								</option>
								<%
							}
						}
					%>
			</select></td>
			</tr>
			<tr>
				<th>デザート</th>
				<td><select name="dessertId">
						<option value="0"></option>
						<%
							@SuppressWarnings("unchecked")

							ArrayList<Menu> dessert = (ArrayList<Menu>) typeMenuList.get(5);
						if (dessertId) {
							for (int i = 0; i < oneCourses.size(); i++) {
								co = oneCourses.get(i);
								if (co.getMenuType() == Course.COURSE_MENU_TYPE_ID[5]) {
									for (Menu m : dessert) {
										String selected = "";
										if (co.getMenuId() == m.getMenuId()) {
											selected = "selected";
										}
					%>
					<option value="<%=m.getMenuId()%>" <%=selected%>>
						<%=m.getMenuName()%>
					</option>
					<%
									}
								}
							}
						}else{
							for(Menu m: dessert){
								%>
								<option value="<%=m.getMenuId()%>">
									<%=m.getMenuName()%>
								</option>
								<%
							}
						}
					%>
			</select></td>
			</tr>
			<input type="hidden" name="mode" value="<%=CourseOperationSvl.UPDATE %>" /> <input type="hidden"
				name="courseId" value="<%=request.getParameter("menuId") %>" /> <input type="hidden" name="typeId"
				value="<%=request.getParameter("typeId") %>" />
			<tr>
				<th colspan="2" id="bottom"><input type="submit" value="コースを更新" /></th>
			</tr>
		</form>
	</table>
	<p>
		<a href="MenuMaintenanceSvl?typeID=100">一覧表示画面へ戻る</a>
	</p>
</body>
</html>