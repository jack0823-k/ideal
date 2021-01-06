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

import model.IdealException;
import model.User;

/**
 * Servlet implementation class UserLoginSvl
 */
@WebServlet("/UserLoginSvl")
public class UserLoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginSvl() {
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
	String mail;
	String password;
	//インターフェイスからオブジェクトのセッションを生成
	HttpSession session = request.getSession();

	try{
		//リクエストパラメーターを取得
		mail = request.getParameter("mail");
		password = request.getParameter("password");
		//cookieオブジェクトを作成
		Cookie ck1 = new Cookie("eMail", mail);			//ログインに必要なemailを渡す
		Cookie ck2 = new Cookie("passWord", password);	//ログインに必要なpasswordを渡す
		Cookie ck3 = new Cookie("eMailFlg", request.getParameter("eMailFlg"));
		Cookie ck4 = new Cookie("passWordFlg", request.getParameter("passWordFlg"));
		System.out.println("UserLoginSvl:Coookie");
		System.out.println(mail);
		System.out.println(password);
		System.out.println(request.getParameter("eMailFlg"));
		System.out.println(request.getParameter("passWordFlg"));
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
		User ul = User.login(mail, password);		    //usrIdとpasswordを引数にloginメソッド
		if(ul != null){                                 //該当レコードが存在したら
			session.setAttribute("userInfo", ul);		//セッションにuserInfoとしてセット
			url = "userIndex.jsp";                      //遷移先
			System.out.println("ユーザー情報の取得に成功。");	//テスト用
		}else{
			url = "userLogin.jsp";
			throw new IdealException(IdealException.ERR_NO_NOT_MEMBER_EXCEPTION);
		}
	} catch (IdealException e) {
		request.setAttribute("msg", e.getMsg());       //「User.loginメソッド」OR「ログインできない場合」のメッセージが入る
	}catch(Exception e){
		e.printStackTrace();
	}
	//フォワーディング
	rd = request.getRequestDispatcher(url);
	rd.forward(request, response);
	}
}
