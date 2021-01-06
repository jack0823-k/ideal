<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>

<%@ include file="incFile.jsp"%>
<%@ page import="model.*"%>
<%@ page import="controller.*"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Delete Course</title>
<style>
<!--
table {
	margin: auto;
}

caption {
	color: #990000;
	font-size: 18pt;
}

th {
	text-align: left;
	background: #990000;
	color: #FFD7D7;
}

td {
	background: #FFD7D7;
}

th#bottom {
	text-align: center;
}

p {
	text-align: center;
}
-->
</style>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		NumberFormat nfCur = NumberFormat.getCurrencyInstance();
		ArrayList<Course> oneCourses = (ArrayList<Course>) request
				.getAttribute("oneCourse");
		Course c = oneCourses.get(0);
		String str;
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
		int t_id;
		try {
			t_id = Integer.parseInt(request.getParameter("typeId"));
		} catch (NumberFormatException e) {
			t_id = 100;
		}
	%>


	<jsp:useBean id="typeMenuList" class="java.util.ArrayList"
		scope="request" />
		<p align ="center"><%= fmtNull((String)request.getAttribute("msg")) %></p>

	<table border>
		<caption>コースの削除</caption>

		<form id="frm1" name="frm1" action="CourseOperationSvl" method="post">
			<tr>
				<th>コース名</th>
				<td><%=fmtNull(c.getCourseName())%></td>
			</tr>
			<tr>
				<th>価格</th>
				<td><%=nfCur.format(c.getPrice()) %></td>
			</tr>
			<tr>
				<th>オーダー可</th>
				<%
					String order = "オーダー不可";
					if(c.getOrderFlg() == 1){
						order = "オーダー可";
					}
				%>
				<td>
					<%=order%>
				</td>
			</tr>
		<tr>
			<th>コメント</th>
			<td><%=fmtNull(c.getDetail())%></td>
		</tr>

		<tr>
			<th>前菜</th>
			<%
			String app = "";
				ArrayList<Menu> appetizer = (ArrayList<Menu>) typeMenuList.get(0);
				Course co;
			if(appetizerId){
				for (int i = 0; i < oneCourses.size(); i++) {
					co = oneCourses.get(i);
					if (co.getMenuType() == Course.COURSE_MENU_TYPE_ID[0]) {
						for (Menu m : appetizer) {
							if (co.getMenuId() == m.getMenuId()) {
								app = m.getMenuName();
							}
						}
					}
				}
			}
			%>
			<td><%=app %></td>
		</tr>

		<tr>
			<th>スープ</th>
						<%
			String sou = "";
				ArrayList<Menu> soup = (ArrayList<Menu>) typeMenuList.get(1);
				Course co1;
				if(soupId){
				for (int i = 0; i < oneCourses.size(); i++) {
					co1 = oneCourses.get(i);
					if (co1.getMenuType() == Course.COURSE_MENU_TYPE_ID[1]) {
						for (Menu m : soup) {
							if (co1.getMenuId() == m.getMenuId()) {
								sou = m.getMenuName();
							}
						}
					}
				}
			}
			%>
			<td><%=sou %></td>
		</tr>

		<tr>
			<th>パスタ</th>
						<%
			String pas = "";
				ArrayList<Menu> pasta = (ArrayList<Menu>) typeMenuList.get(2);
				Course co2;
				if(pastaId){
				for (int i = 0; i < oneCourses.size(); i++) {
					co2 = oneCourses.get(i);
					if (co2.getMenuType() == Course.COURSE_MENU_TYPE_ID[2]) {
						for (Menu m : pasta) {
							if (co2.getMenuId() == m.getMenuId()) {
								pas = m.getMenuName();
							}
						}
					}
				}
			}
			%>
			<td><%=pas %></td>
		</tr>

		<tr>
			<th>肉料理</th>
						<%
			String mea = "";
				ArrayList<Menu> meat = (ArrayList<Menu>) typeMenuList.get(3);
				Course co3;
				if(meatId){
				for (int i = 0; i < oneCourses.size(); i++) {
					co3 = oneCourses.get(i);
					if (co3.getMenuType() == Course.COURSE_MENU_TYPE_ID[3]) {
						for (Menu m : meat) {
							if (co3.getMenuId() == m.getMenuId()) {
								mea = m.getMenuName();
							}
						}
					}
				}
			}
			%>
			<td><%=mea %></td>
		</tr>

		<tr>
			<th>魚料理</th>
						<%
			String fis = "";
				ArrayList<Menu> fish = (ArrayList<Menu>) typeMenuList.get(4);
				Course co4;
				if(fishId){
				for (int i = 0; i < oneCourses.size(); i++) {
					co4 = oneCourses.get(i);
					if (co4.getMenuType() == Course.COURSE_MENU_TYPE_ID[4]) {
						for (Menu m : fish) {
							if (co4.getMenuId() == m.getMenuId()) {
								fis = m.getMenuName();
							}
						}
					}
				}
			}
			%>
			<td><%=fis %></td>
		</tr>

		<tr>
			<th>デザート</th>
						<%
			String des = "";
				ArrayList<Menu> dessert = (ArrayList<Menu>) typeMenuList.get(5);
				Course co5;
				if(dessertId){
				for (int i = 0; i < oneCourses.size(); i++) {
					co5 = oneCourses.get(i);
					if (co5.getMenuType() == Course.COURSE_MENU_TYPE_ID[5]) {
						for (Menu m : dessert) {
							if (co5.getMenuId() == m.getMenuId()) {
								des = m.getMenuName();
							}
						}
					}
				}
			}
			%>
			<td><%=des %></td>
		</tr>
		<input type="hidden" name="mode" value="<%=CourseOperationSvl.DELETE %>" />
		<input type="hidden" name="courseId" value="<%=request.getParameter("menuId") %>" /> <input type="hidden" name="typeId"
				value="<%=request.getParameter("typeId") %>" />
		<tr>
			<th colspan="2" id="bottom"><input type="submit" value="コースを削除" /></th>
		</tr>
		</form>
	</table>
	<p>
		<a href="MenuMaintenanceSvl?typeID=100">一覧表示画面へ戻る</a>
	</p>
</body>
</html>