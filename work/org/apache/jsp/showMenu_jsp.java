/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2020-11-13 04:49:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;
import java.text.*;
import java.io.*;
import model.Menu;
import model.Course;

public final class showMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_dependants.put("/incFile.jsp", Long.valueOf(1605242901286L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.Menu");
    _jspx_imports_classes.add("model.Course");
    _jspx_imports_classes.add("model.User");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>Menu | Restaurante IDEALLE</title>\r\n");
      out.write("\r\n");
      out.write("<!-- cssのインポート -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"homeAction.css\" />\r\n");
      out.write("<!-- タイトル用フォントのインポート -->\r\n");
      out.write("<style>\r\n");
      out.write("@import\r\n");
      out.write("\turl('https://fonts.googleapis.com/css2?family=Limelight&display=swap');\r\n");
      out.write("</style>\r\n");
      out.write("<!-- 日本語レビュー用フォントのインポート -->\r\n");
      out.write("<style>\r\n");
      out.write("@import\r\n");
      out.write("\turl('https://fonts.googleapis.com/css2?family=M+PLUS+1p&display=swap');\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("<!--\r\n");
      out.write("\r\n");
      out.write("\t//1.メニュー名クリック時のコメント表示、\r\n");
      out.write("\tfunction showDetail(id) {\r\n");
      out.write("\t\t//1.引き渡されたメニュー番号の\"style.display\"が\"block\"の時、\r\n");
      out.write("\t\tif (document.getElementById(id).style.display == 'block') {\r\n");
      out.write("\t\t\t//1.引き渡されたメニュー番号の\"style.display\"を\"none\"に設定する。\r\n");
      out.write("\t\t\tdocument.getElementById(id).style.display = 'none';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//2.引き渡されたメニュー番号の\"style.display\"が\"block\"以外の時、\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\t//1.引き渡されたメニュー番号の\"style.display\"を\"block\"に設定する。\r\n");
      out.write("\t\t\tdocument.getElementById(id).style.display = 'block';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//2.メニュー名クリック時のメニュー名のフォント変更、\r\n");
      out.write("\tfunction change(id, val) {\r\n");
      out.write("\t\t//1.引き渡された色区分(val)が\"0\"の時\r\n");
      out.write("\t\tif (val == 0) {\r\n");
      out.write("\t\t\t//1.引き渡されたメニュー番号のフォント色を\"red\"、フォントの太さを\"bold\"に設定する。\r\n");
      out.write("\t\t\tdocument.getElementById(id).style.color = 'red';\r\n");
      out.write("\t\t\tdocument.getElementById(id).style.fontWeight = 'bold';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//2.引き渡された色区分(val)が\"0\"以外の時\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\t//1.引き渡されたメニュー番号のフォント色を\"DarkOliveGreen\"、フォントの太さを\"normal\"に設定する。\r\n");
      out.write("\t\t\tdocument.getElementById(id).style.color = 'DarkOliveGreen';\r\n");
      out.write("\t\t\tdocument.getElementById(id).style.fontWeight = 'normal';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t-->\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"showMenu.css\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");

		User user = (User) session.getAttribute("userInfo");
	
      out.write("\r\n");
      out.write("\t<header>\r\n");
      out.write("\r\n");
      out.write("<div style=\"display: flex;margin: 0 auto;\">\r\n");
      out.write("\r\n");
      out.write("<div  style=\"float:left; width:10%;\r\n");
      out.write("         padding: 5px; text-align:center;margin: 0 auto;\">\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write(" <a href=\"home.jsp\">\r\n");
      out.write(" <img src=\"./img/logo.png\"  width=\"200px\"/ >\r\n");
      out.write(" </a>\r\n");
      out.write("    </div>\r\n");
      out.write("<div  style=\"float:right; width:70%;\r\n");
      out.write("         padding: 5px; text-align:left;margin: 0 auto;\">\r\n");
      out.write("<div1 style=\"font-size:x-large;\">\r\n");
      out.write("<font class=\"left\"  color=\"#FFFAF0\" >\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("\r\n");
      out.write("        <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ristorante Idealle</h1>\r\n");
      out.write("</font>\r\n");
      out.write("</div1>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("<div class=\"buttons-coll\">\r\n");
      out.write("  <ul class=\"clearfix\" style=\"text-align:center ;\">\r\n");
      out.write("    <li >\r\n");
      out.write("        <button class=\"custom-btn btn-2\">\r\n");
      out.write("        <a href=\"home.jsp\">Top</button></a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li >\r\n");
      out.write("        <button class=\"custom-btn btn-2\">\r\n");
      out.write("        <a href=\"ShowMenuSvl\">Menu</button></a>\r\n");
      out.write("    </li>\r\n");
      out.write("    <li >\r\n");
      out.write("        <button class=\"custom-btn btn-2\">\r\n");
      out.write("        <a href=\"information.jsp\">About</button></a>\r\n");
      out.write("    </li>\r\n");
      out.write("     <li >\r\n");
      out.write("        <button class=\"custom-btn btn-2\">\r\n");
      out.write("        <a href=\"review.jsp\">Review</button></a>\r\n");
      out.write("    </li>\r\n");
      out.write("</div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</nav> <!--  追尾するメニューバーの表示 --> <!--  <table id=\"auto\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th id=\"auto\"><a href=\"reserveInsert.jsp\">ご予約</a></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th id=\"auto\"><a href=\"userInsert.jsp\">新規お客様登録</a></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th id=\"auto\"><a href=\"userLogin.jsp\">ログイン</a></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t</table>\t--> <!--\t\tアコーディオンメニューの表示\t\t\t-->\r\n");
      out.write("\t<div class=\"cp_menu\">\r\n");
      out.write("\t\t");

			if (user != null) {
		
      out.write("\r\n");
      out.write("\t\t<label for=\"cp_menu_bar1\">ようこそ！");
      out.print(user.getUsrName());
      out.write("様\r\n");
      out.write("\t\t</label> <input type=\"radio\" name=\"radio\" id=\"cp_menu_bar1\" class=\"accordion\" />\r\n");
      out.write("\t\t<ul id=\"link1\">\r\n");
      out.write("\t\t\t<li><a href=\"UserUpdateSvl\">お客様情報変更</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"UserDeleteSvl\">脱会手続き</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"UserLogoffSvl\">ログオフ</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<label for=\"cp_menu_bar3\">ご予約はこちら</label> <input type=\"radio\"\r\n");
      out.write("\t\t\tname=\"radio\" id=\"cp_menu_bar3\" class=\"accordion\" />\r\n");
      out.write("\t\t<ul id=\"link3\">\r\n");
      out.write("\t\t\t<li><a href=\"ReserveListSvl\">ご予約一覧</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"ReserveInsertSvl\">新規予約</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t");

			} else {
		
      out.write("\r\n");
      out.write("\t\t<label for=\"cp_menu_bar1\">ようこそ！ゲスト様</label> <input type=\"radio\"\r\n");
      out.write("\t\t\tname=\"radio\" id=\"cp_menu_bar1\" class=\"accordion\" />\r\n");
      out.write("\t\t<ul id=\"link1\">\r\n");
      out.write("\t\t\t<li><a href=\"userLogin.jsp\">ログイン</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"userInsert.jsp\">新規入会</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t");

			}
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>Menu</h2>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<!-- Beanを生成 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		request.setCharacterEncoding("utf-8");
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");
      java.util.ArrayList courseList = null;
      courseList = (java.util.ArrayList) _jspx_page_context.getAttribute("courseList", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (courseList == null){
        courseList = new java.util.ArrayList();
        _jspx_page_context.setAttribute("courseList", courseList, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      out.write('	');
      java.util.ArrayList menuList = null;
      menuList = (java.util.ArrayList) _jspx_page_context.getAttribute("menuList", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (menuList == null){
        menuList = new java.util.ArrayList();
        _jspx_page_context.setAttribute("menuList", menuList, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"clearfix\">\r\n");
      out.write("\t\t<div id=\"fake1\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 左側メニュー目次の表示 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<table id=\"mokuzi\" align=\"left\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th id=\"right\"><a href=\"#jump1\">コース料理</a></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th id=\"right\"><a href=\"#jump2\">アラカルト</a></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"fake2\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- コースの表示 -->\r\n");
      out.write("\r\n");
      out.write("\t\t<table id=\"main\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td id=\"left\"><img src=\"./img/lefttop.png\" /></td>\r\n");
      out.write("\t\t\t\t<td id=\"right\"><img src=\"./img/righttop.png\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><div id=\"jump1\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\"><div class=\"box1\">\r\n");
      out.write("\t\t\t\t\t\t<p>～ コース料理 ～</p>\r\n");
      out.write("\t\t\t\t\t</div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td id=\"center\" ><div class=\"cen\">\r\n");
      out.write("<img src=\"./img/course1.jpg\"  class=\"appIconBig\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				int current_cId = 0;

				for (int i = 0; i < courseList.size(); i++) {
					Course c = (Course) courseList.get(i);

					//コース名は一回のみ表示する
					if (current_cId != c.getCourseId()) {
						current_cId = c.getCourseId();
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr><td><br /></td></tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th id=\"c_name\"><div id=\"area1\" />～&nbsp;");
      out.print(c.getCourseName());
      out.write("&nbsp;～</div></th>\r\n");
      out.write("\t\t\t\t<th id=\"c_price\">");
      out.print(nf.format(c.getPrice()));
      out.write("</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th id=\"c_detail\">");
      out.print(c.getDetail());
      out.write("</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- 先頭2文字分くらいさげたい -->\r\n");
      out.write("\t\t\t\t<th id=\"c_name\">");
      out.print(c.getMenuName());
      out.write("</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!--ここから  <tr>\r\n");
      out.write("\t\t\t\t<td id=\"left\"><img src=\"./img/leftunder.png\"  class=\"conner\"/></td>\r\n");
      out.write("\t\t\t\t<td id=\"right\"><img src=\"./img/rightunder.png\"  class=\"conner\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"clearfix\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"fake3\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t<table id = \"main\"  >\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td id = \"left\"><img src=\"./img/lefttop.png\"  /></td>\r\n");
      out.write("\t\t\t\t<td id = \"right\"><img src=\"./img/righttop.png\"  /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\tここまでコメントアウト-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td><div id=\"jump2\"></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td id=\"title\" colspan=\"2\"><div class=\"box2\">\r\n");
      out.write("\t\t\t\t\t\t<p>～ アラカルトメニュー ～</p>\r\n");
      out.write("\t\t\t\t\t</div> <br /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td id=\"center\" ><div class=\"cen\"><img src=\"./img/imageex3.jpg\" class=\"applconBig\" /></div></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				int current_cId2 = 0;

				for (int i = 0; i < menuList.size(); i++) {
					Menu m = (Menu) menuList.get(i);

					//分類名は一回のみ表示する
					if (current_cId2 != m.getTypeId()) {
						current_cId2 = m.getTypeId();
			
      out.write("\r\n");
      out.write("\t\t\t<tr><td><br /></td></tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<th><div id=\"area1\">～&nbsp;");
      out.print(m.getTypeName());
      out.write("&nbsp;～</div></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td id =\"menu\">\r\n");
      out.write("\t\t\t\t<font color=\"DarkOliveGreen\">\r\n");
      out.write("\t\t\t\t<div class=\"menu\"\r\n");
      out.write("\t\t\t\tid=\"menu");
      out.print( m.getMenuId() );
      out.write("\"\r\n");
      out.write("\t\t\t\tonmouseover =\"change('menu");
      out.print( m.getMenuId() );
      out.write("' , 0)\"\r\n");
      out.write("\t\t\t\tonmouseout=\"change('menu");
      out.print( m.getMenuId() );
      out.write("' , 1)\"\r\n");
      out.write("\t\t\t\tonclick=\"showDetail('exp");
      out.print( m.getMenuId() );
      out.write("')\">\r\n");
      out.write("\t\t\t\t\t\t◆");
      out.print(m.getMenuName());
      out.write("\r\n");
      out.write("\t\t\t\t</div> </td>\r\n");
      out.write("\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t<th id=\"m_price\">");
      out.print(nf.format(m.getPrice()));
      out.write("</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th><div id=\"exp");
      out.print( m.getMenuId() );
      out.write("\"  style=\"display:none\">");
      out.print(fmtNull(m.getDetail()) );
      out.write("</div></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- 下部の装飾 -->\r\n");
      out.write("\t\t\t\t<td id=\"left\"><img src=\"./img/leftunder.png\" /></td>\r\n");
      out.write("\t\t\t\t<td id=\"right\"><img src=\"./img/rightunder.png\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</br>\r\n");
      out.write("\t</br>\r\n");
      out.write("\t</br>\r\n");
      out.write("\r\n");
      out.write("\t<footer> <nav>\r\n");
      out.write("\t<ul style=\"text-align: center;\">\r\n");
      out.write("\t\t<li class=”current”><div>\r\n");
      out.write("\t\t\t\t<a href=\"https://www.instagram.com/?hl=ja\" target=\"_blank\"\r\n");
      out.write("\t\t\t\t\trel=\"noopener noreferrer\"><img\r\n");
      out.write("\t\t\t\t\tsrc=\"./img/200520133708-5ec4b3f4bb74a.png\" /></a>\r\n");
      out.write("\t\t\t</div></li>\r\n");
      out.write("\t\t<li><div>\r\n");
      out.write("\t\t\t\t<a href=\"https://ja-jp.facebook.com/\" target=\"_blank\"\r\n");
      out.write("\t\t\t\t\trel=\"noopener noreferrer\"><img\r\n");
      out.write("\t\t\t\t\tsrc=\"./img/200528153054-5ecf5a9ebd033.png\" /></a>\r\n");
      out.write("\t\t\t</div></li>\r\n");
      out.write("\t\t<li><div>\r\n");
      out.write("\t\t\t\t<a href=\"https://www.ubereats.com/jp\" target=\"_blank\"\r\n");
      out.write("\t\t\t\t\trel=\"noopener noreferrer\"><img\r\n");
      out.write("\t\t\t\t\tsrc=\"./img/200529091516-5ed0541485804.png\" /></a>\r\n");
      out.write("\t\t\t</div></li>\r\n");
      out.write("\t\t<li><div>\r\n");
      out.write("\t\t\t\t<a href=\"https://www.foxnews.com/\" target=\"_blank\"\r\n");
      out.write("\t\t\t\t\trel=\"noopener noreferrer\"><img\r\n");
      out.write("\t\t\t\t\tsrc=\"./img/200529090425-5ed051899491f.png\" /></a>\r\n");
      out.write("\t\t\t</div></li>\r\n");
      out.write("\t\t<li><div>\r\n");
      out.write("\t\t\t\t<a href=\"https://thebase.in/\" target=\"_blank\"\r\n");
      out.write("\t\t\t\t\trel=\"noopener noreferrer\"><img\r\n");
      out.write("\t\t\t\t\tsrc=\"./img/200529092244-5ed055d4afce8.png\" /></a>\r\n");
      out.write("\t\t\t</div></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t</nav> <br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t\t<font class=\"right\" size=\"1\" color=\"#FFFAF0\"><p>\r\n");
      out.write("\t\t\t\t【Ristorante Idealle】<br /> 〒060-0005<br /> 札幌市中央区北５条西2−５<br />\r\n");
      out.write("\t\t\t\tJRタワーオフィスプラザさっぽろ19F<br /> TEL: 011-206-1663 <br /> Mail:\r\n");
      out.write("\t\t\t\tsapporo@kenschool.jp<br />\r\n");
      out.write("\t\t\t</p> </font>\r\n");
      out.write("\t\t<div style=\"text-align: right;\">\r\n");
      out.write("\t\t\t<a href=\"adminLogin.jsp\">●管理者ログイン</a> <br /> <font color=\"#FFFAF0\"\r\n");
      out.write("\t\t\t\tsize=\"2\">※Created by\r\n");
      out.write("\t\t\t\tKamiyama,Kawata,Nagata,Yanagisawa,Yokoi,Mizuki <br /> ※Unauthorized\r\n");
      out.write("\t\t\t\tcopying of the All of this site are strictly prohibited. <br />\r\n");
      out.write("\t\t\t</font>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- TODO①値をgetできてるかチェック -->\r\n");
      out.write("\t<!-- TODO②コース部分の表示が整っているか -->\r\n");
      out.write("\t<!-- TODO③コース詳細、メニュー詳細をonmouseoverで表示 -->\r\n");
      out.write("\r\n");
      out.write("\t<br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!--\r\n");
      out.write("\t\t//顧客ログイン済のときuserIndex.jspに遷移\r\n");
      out.write("\t\tif(){\r\n");
      out.write("\t\t\t<p><a href=\"userIndex.jsp\">[戻る]</a></p>\r\n");
      out.write("\r\n");
      out.write("\t\t}%\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t//顧客未ログインのときhome.jspに遷移\r\n");
      out.write("\t\tif(){\r\n");
      out.write("\t\t\t<p><a href=\"home.jsp\">[戻る]</a></p>\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t-->\r\n");
      out.write("\r\n");
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
