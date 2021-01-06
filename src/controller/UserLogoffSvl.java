package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogoffSvl
 */
@WebServlet("/UserLogoffSvl")
public class UserLogoffSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoffSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = null;
		String url = "";
		HttpSession session = request.getSession();//インターフェイスからオブジェクトのセッションを生成
		session.invalidate();                      //セッションを破棄
		url = "home.jsp";                          //遷移先

		 String eMail = "";
		 String passWord = "";
		 String eMailFlg = "";
		 String passWordFlg = "";

		 Cookie[] cks = request.getCookies();

		 if(cks != null){
		        for(int ck=0; ck<cks.length; ck++){
		                if(cks[ck].getName().equals("eMail")){
		                	eMail = cks[ck].getValue();
		                }
		                else if(cks[ck].getName().equals("passWord")){
		                        passWord = cks[ck].getValue();
		                }
		                else if(cks[ck].getName().equals("eMailFlg")){
		                	eMailFlg = cks[ck].getValue();
		            }
		                else if(cks[ck].getName().equals("passWordFlg")){
		                	passWordFlg = cks[ck].getValue();
		            }
		        }
		 }
		 if (eMailFlg.length() == 0) {
			eMail = "";
		}
		 if (passWordFlg.length() == 0) {
			passWord = "";
		}
		//cookieオブジェクトを作成
		Cookie ck1 = new Cookie("eMail", eMail);			//ログインに必要なemailを渡す
		Cookie ck2 = new Cookie("passWord", passWord);	//ログインに必要なpasswordを渡す
		Cookie ck3 = new Cookie("eMailFlg", eMailFlg);
		Cookie ck4 = new Cookie("passWordFlg", passWordFlg);
		System.out.println("UserLogoffSvl:Coookie");
		System.out.println(eMail);
		System.out.println(passWord);
		System.out.println(eMailFlg);
		System.out.println(passWordFlg);
		ck1.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
		ck2.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
		ck3.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定
		ck4.setMaxAge(60*60*24*180);	//Cookieの有効期限を180日に設定

		try {
			response.addCookie(ck1);	//クッキーに送信するcookieオブジェクトを追加
			response.addCookie(ck2);	//クッキーに送信するcookieオブジェクトを追加
			response.addCookie(ck3);	//クッキーに送信するcookieオブジェクトを追加
			response.addCookie(ck4);	//クッキーに送信するcookieオブジェクトを追加

		} catch (IllegalArgumentException e) {//Cookieでは「スペース」や「カンマ」などの文字が許容されない
            System.out.print(" : Some information was not saved to Cookie because illegal character such as ',' was used"+"</br>");
            System.out.print("Please use characters which are in ASCII");
            }
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
