/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2020-11-08 13:07:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.stream.Stream;
import java.io.*;
import java.text.*;
import java.util.*;
import model.*;
import controller.*;

public final class courseUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


	static String fmtNull(String s){
		if(s == null || s.equals("")){
			s = "";
		}
		return s;

	}


  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/incFile.jsp", Long.valueOf(1604636712141L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("controller");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("model");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.stream.Stream");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>Update Menu</title>\r\n");
      out.write("<style>\r\n");
      out.write("<!--\r\n");
      out.write("table {\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("caption {\r\n");
      out.write("\tcolor: #006799;\r\n");
      out.write("\tfont-size: 18pt;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tbackground: #006799;\r\n");
      out.write("\tcolor: #C8EDFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tbackground: #C8EDFF;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th#bottom {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\tfunction dataCheck(obj) {\r\n");
      out.write("\t\tvar msg = \"\";\r\n");
      out.write("\t\tif (obj.courseName.value.length < 1) {\r\n");
      out.write("\t\t\tmsg += \"コース名を入力してください。\\n\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (!obj.price.value.match(/^[0-9]+$/g)) {\r\n");
      out.write("\t\t\tmsg += \"価格を数値で入力してください。\\n\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar i;\r\n");
      out.write("\t\tfor (i = 0; i < obj.orderFlg.length; i++) {\r\n");
      out.write("\t\t\tif (obj.orderFlg[i].checked)\r\n");
      out.write("\t\t\t\tbreak;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (i >= obj.orderFlg.length) {\r\n");
      out.write("\t\t\tmsg += \"オーダーの可否をチェックしてください\\n\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (msg.length > 0) {\r\n");
      out.write("\t\t\talert(msg);\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

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
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      java.util.ArrayList typeMenuList = null;
      typeMenuList = (java.util.ArrayList) _jspx_page_context.getAttribute("typeMenuList", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (typeMenuList == null){
        typeMenuList = new java.util.ArrayList();
        _jspx_page_context.setAttribute("typeMenuList", typeMenuList, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<table border>\r\n");
      out.write("\t\t<caption>コースの更新</caption>\r\n");
      out.write("\t\t<p align=\"center\">");
      out.print(fmtNull((String) request.getAttribute("msg")));
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("\t\t<form action=\"CourseOperationSvl\" method=\"post\"\r\n");
      out.write("\t\t\tonsubmit=\"return dataCheck(this);\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>コース名</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"courseName\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(fmtNull(c.getCourseName()));
      out.write("\" size=\"30\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>価格</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"price\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(fmtNull(String.valueOf(c.getPrice())));
      out.write("\" size=\"10\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>オーダー可</th>\r\n");
      out.write("\t\t\t\t");

					String[] order = { "不可", "可" };
				
      out.write("\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");

						for (int i = 0; i < order.length; i++) {
							String checked = "";

							if (c.getOrderFlg() == i) {
								checked = "checked";
							}
					
      out.write(" <input type=\"radio\" name=\"orderFlg\" value=\"");
      out.print(i);
      out.write('"');
      out.write(' ');
      out.print(checked);
      out.write(" />\r\n");
      out.write("\t\t\t\t\t");
      out.print(order[i]);
      out.write("&nbsp;&nbsp;&nbsp; ");

 	}
 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>コメント</th>\r\n");
      out.write("\t\t\t\t<td><textarea name=\"detail\" cols=\"30\" rows=\"4\">");
      out.print(fmtNull(c.getDetail()));
      out.write("\r\n");
      out.write("        </textarea></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>前菜</th>\r\n");
      out.write("\t\t\t\t<td><select name=\"appetizerId\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"0\"></option>\r\n");
      out.write("\t\t\t\t\t\t");

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
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write('"');
      out.write(' ');
      out.print(selected);
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t");

										}
									}
								}
							}else{		//コース内に前菜がないので、前菜のプルダウンリストを作成するが
								for(Menu m: appetizer){//リストをセレクトせず、先頭の空白リストが選択される
									
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

								}
							}
						
      out.write("\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>スープ</th>\r\n");
      out.write("\t\t\t\t<td><select name=\"soupId\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"0\"></option>\r\n");
      out.write("\t\t\t\t\t\t");

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
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write('"');
      out.write(' ');
      out.print(selected);
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t");

									}
								}
							}
						}else{
							for(Menu m: soup){
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
						}
					
      out.write("\r\n");
      out.write("\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>パスタ</th>\r\n");
      out.write("\t\t\t\t<td><select name=\"pastaId\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"0\"></option>\r\n");
      out.write("\t\t\t\t\t\t");

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
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write('"');
      out.write(' ');
      out.print(selected);
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t");

										}
									}
								}
							}else{
								for(Menu m: pasta){
									
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");

								}
							}
						
      out.write("\r\n");
      out.write("\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>肉料理</th>\r\n");
      out.write("\t\t\t\t<td><select name=\"meatId\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"0\"></option>\r\n");
      out.write("\t\t\t\t\t\t");

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
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write('"');
      out.write(' ');
      out.print(selected);
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t");

									}
								}
							}
						}else{
							for(Menu m: meat){
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
						}
					
      out.write("\r\n");
      out.write("\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>魚料理</th>\r\n");
      out.write("\t\t\t\t<td><select name=\"fishId\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"0\"></option>\r\n");
      out.write("\t\t\t\t\t\t");

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
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write('"');
      out.write(' ');
      out.print(selected);
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t");

									}
								}
							}
						}else{
							for(Menu m: fish){
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
						}
					
      out.write("\r\n");
      out.write("\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>デザート</th>\r\n");
      out.write("\t\t\t\t<td><select name=\"dessertId\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"0\"></option>\r\n");
      out.write("\t\t\t\t\t\t");

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
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write('"');
      out.write(' ');
      out.print(selected);
      out.write(">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t");

									}
								}
							}
						}else{
							for(Menu m: dessert){
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<option value=\"");
      out.print(m.getMenuId());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t");

							}
						}
					
      out.write("\r\n");
      out.write("\t\t\t</select></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"mode\" value=\"");
      out.print(CourseOperationSvl.UPDATE );
      out.write("\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\t\tname=\"courseId\" value=\"");
      out.print(request.getParameter("menuId") );
      out.write("\" /> <input type=\"hidden\" name=\"typeId\"\r\n");
      out.write("\t\t\t\tvalue=\"");
      out.print(request.getParameter("typeId") );
      out.write("\" />\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th colspan=\"2\" id=\"bottom\"><input type=\"submit\" value=\"コースを更新\" /></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<p>\r\n");
      out.write("\t\t<a href=\"MenuMaintenanceSvl?typeID=100\">一覧表示画面へ戻る</a>\r\n");
      out.write("\t</p>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
