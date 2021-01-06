package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.User;

/**
 * Servlet implementation class UserUpdateSvl
 */
@WebServlet("/UserUpdateSvl")
public class UserUpdateSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateSvl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = null;
		String url = "";
		// インターフェイスからオブジェクトのセッションを生成
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userInfo");// セッション情報の取得
		User us ;
		int usrId;
		try {
			if (user == null) {                            // セッション情報がnullのとき
				url = "home.jsp";                          // ホームページに遷移
				response.sendRedirect(url);
			} else {
				usrId = user.getUsrId();
				us = User.getUser(usrId);                  //UserからusrIdに対応する顧客情報を取得
				request.setAttribute("user", us);          //リクエストオブジェクトuserに顧客情報を設定
				url = "userUpdate.jsp";                    //顧客情報変更画面に遷移
			}
		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());       //例外が発生したときに、メッセージを取得
			e.printStackTrace();
			url = "userIndex.jsp";                         //顧客処理選択画面に遷移
		}
		// フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
