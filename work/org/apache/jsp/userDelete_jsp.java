/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.20
 * Generated at: 2020-11-07 02:39:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class userDelete_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
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
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>お客様登録削除手続き</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"homeActionUserIndex.css\"/>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"showMenu.css\" />\r\n");
      out.write("<style>\r\n");
      out.write("@import url('https://fonts.googleapis.com/css2?family=Limelight&display=swap');\r\n");
      out.write("</style>\r\n");
      out.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("@import url('https://fonts.googleapis.com/css2?family=Meddon&display=swap');\r\n");
      out.write("\r\n");
      out.write("h2,\r\n");
      out.write("h3{\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("    color:white\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th{color:white}\r\n");
      out.write("td{color:white}\r\n");
      out.write("p1{text-align: center;\r\n");
      out.write("   color:white;\r\n");
      out.write("   font-size:x-large;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a.index {\r\n");
      out.write("    -webkit-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);\r\n");
      out.write("    -moz-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);\r\n");
      out.write("    -ms-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);\r\n");
      out.write("    -o-transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);\r\n");
      out.write("    transition: all 200ms cubic-bezier(0.390, 0.500, 0.150, 1.360);\r\n");
      out.write("    display: block;\r\n");
      out.write("    margin: 1px auto;\r\n");
      out.write("    max-width: 250px;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    border-radius: 4px;\r\n");
      out.write("    padding: 20px 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#button {\r\n");
      out.write("    color: rgba(255, 255, 255, 0.85);\r\n");
      out.write("    box-shadow: rgba(255, 255, 255, 0.85) 0 0px 0px 1px inset;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#button:hover {\r\n");
      out.write("    color: rgba(255, 255, 255, 0.85);\r\n");
      out.write("    box-shadow: rgba(153, 102, 0, 1) 0 0px 0px 40px inset;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<body><div class=\"center\">\r\n");
      out.write("<header>\r\n");

        User user = (User) session.getAttribute("userInfo");

      out.write("\r\n");
      out.write("<!--        アコーディオンメニューの表示          -->\r\n");
      out.write("    <div class=\"cp_menu\">\r\n");
      out.write("        ");

            if (user != null) {
        
      out.write("\r\n");
      out.write("        <label for=\"cp_menu_bar1\">ようこそ！");
      out.print(user.getUsrName());
      out.write("様\r\n");
      out.write("        </label> <input type=\"radio\" name=\"radio\" id=\"cp_menu_bar1\" class=\"accordion\" />\r\n");
      out.write("        <ul id=\"link1\">\r\n");
      out.write("            <li><a href=\"UserUpdateSvl\">お客様情報変更</a></li>\r\n");
      out.write("            <li><a href=\"UserDeleteSvl\">脱会手続き</a></li>\r\n");
      out.write("            <li><a href=\"UserLogoffSvl\">ログオフ</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <label for=\"cp_menu_bar3\">ご予約はこちら</label> <input type=\"radio\"\r\n");
      out.write("            name=\"radio\" id=\"cp_menu_bar3\" class=\"accordion\" />\r\n");
      out.write("        <ul id=\"link3\">\r\n");
      out.write("            <li><a href=\"ReserveListSvl\">ご予約一覧</a></li>\r\n");
      out.write("            <li><a href=\"ReserveInsertSvl\">新規予約</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        ");

            } else {
        
      out.write("\r\n");
      out.write("        <label for=\"cp_menu_bar1\">ようこそ！ゲスト様</label> <input type=\"radio\"\r\n");
      out.write("            name=\"radio\" id=\"cp_menu_bar1\" class=\"accordion\" />\r\n");
      out.write("        <ul id=\"link1\">\r\n");
      out.write("            <li><a href=\"userLogin.jsp\">ログイン</a></li>\r\n");
      out.write("            <li><a href=\"userInsert.jsp\">新規入会</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<h2>お客様登録削除手続き</h2>\r\n");
      out.write("\r\n");
      out.write("\t<!-- メッセージの表示 -->\r\n");
      out.write("\t<h1 align =\"center\">");
      out.print( fmtNull((String)request.getAttribute("msg")) );
      out.write("</h1>\r\n");
      out.write("\t<table border= \"1\" align = \"center\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>お客様ID</th>\r\n");
      out.write("\t\t\t<td>");
      out.print( user.getUsrId()  );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>お名前</th>\r\n");
      out.write("\t\t\t<td>");
      out.print( user.getUsrName()  );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>住 所</th>\r\n");
      out.write("\t\t\t<td>");
      out.print( user.getAddress()  );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>電話番号</th>\r\n");
      out.write("\t\t\t<td>");
      out.print( user.getPhone() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th>e-mail</th>\r\n");
      out.write("\t\t\t<td>");
      out.print( user.getMail() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td id=\"sub\" align = \"center\" colspan=\"2\">確認し、削除ボタンをクリックしてください。\r\n");
      out.write("\t\t<form action = \"UserOperationSvl\" method = \"post\">\r\n");
      out.write("\t\t<input type = \"hidden\" name = \"mode\" value = \"13\" />\r\n");
      out.write("\t\t<input type = \"hidden\" name = \"usrId\" value = \"");
      out.print( user.getUsrId() );
      out.write("\" />\r\n");
      out.write("\t\t<input type=\"submit\" value=\" 削除 \" />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table><br/>\r\n");
      out.write("\t<p1><a class = \"index\" href=\"userIndex.jsp\" id=\"button\">◀◀◀ BACK</a></p1>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("<footer>\r\n");
      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("<ul style=\"text-align:center;\">\r\n");
      out.write("\t<li class=”current”><div> <a href=\"https://www.instagram.com/?hl=ja\" target=\"_blank\" rel=\"noopener noreferrer\"><img src=\"./img/200520133708-5ec4b3f4bb74a.png\"/></a></div></li>\r\n");
      out.write("\t<li><div><a href=\"https://ja-jp.facebook.com/\"  target=\"_blank\" rel=\"noopener noreferrer\"><img src=\"./img/200528153054-5ecf5a9ebd033.png\"/></a></div></li>\r\n");
      out.write("\t<li><div><a href=\"https://www.ubereats.com/jp\" target=\"_blank\" rel=\"noopener noreferrer\"><img src=\"./img/200529091516-5ed0541485804.png\"/></a></div></li>\r\n");
      out.write("\t<li><div><a href=\"https://www.foxnews.com/\" target=\"_blank\" rel=\"noopener noreferrer\"><img src=\"./img/200529090425-5ed051899491f.png\"/></a></div></li>\r\n");
      out.write("\t<li><div><a href=\"https://thebase.in/\" target=\"_blank\" rel=\"noopener noreferrer\"><img src=\"./img/200529092244-5ed055d4afce8.png\"/></a></div></li>\r\n");
      out.write("</ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("<br/>\r\n");
      out.write("<br/>\r\n");
      out.write("    </div>\r\n");
      out.write("        </div>\r\n");
      out.write("<hr>\r\n");
      out.write("<font class=\"right\" size=\"1\" color=\"#FFFAF0\" ><p>\r\n");
      out.write("         【Ristorante Idealle】<br/>\r\n");
      out.write("〒060-0005<br/>\r\n");
      out.write("札幌市中央区北５条西2−５<br/>\r\n");
      out.write("JRタワーオフィスプラザさっぽろ19F<br/>\r\n");
      out.write("TEL: 011-206-1663 <br/>\r\n");
      out.write("Mail: sapporo@kenschool.jp<br/>\r\n");
      out.write("</p>\r\n");
      out.write("</font>\r\n");
      out.write("<div style=\"text-align: right;\" >\r\n");
      out.write(" <a href=\"adminLogin.jsp\" >●管理者ログイン</a>\r\n");
      out.write("<br/>\r\n");
      out.write("<font  color=\"#FFFAF0\" size=\"2\">※Created by Kamiyama,Kawata,Nagata,Yanagisawa,Yokoi,Mizuki\r\n");
      out.write("<br/>\r\n");
      out.write("※Unauthorized copying of the All of this site are strictly prohibited.\r\n");
      out.write("<br/>\r\n");
      out.write("</font>\r\n");
      out.write(" </div>\r\n");
      out.write("</footer>\r\n");
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
