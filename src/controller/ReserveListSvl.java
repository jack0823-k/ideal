package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.IdealException;
import model.Reserve;
import model.User;

/**
 * Servlet implementation class ReserveListSvl
 */
@WebServlet("/ReserveListSvl")
public class ReserveListSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveListSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get送信の場合でもdoPost()を呼び出す
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = null;
		String url = "";

		HttpSession session = request.getSession();
		int userId ;
		User user = (User) session.getAttribute("userInfo");//セッション情報の取得
		if (user == null) {				//nullの場合は「ホーム」へ
			url = "home.jsp";
			response.sendRedirect(url);
		}
		try {
			userId = user.getUsrId();
			ArrayList<Reserve> reserveList = Reserve.getReserveList(userId);
			//予約IDで昇順にソート
			java.util.Collections.sort(reserveList, (r1,r2) -> r1.getRsvId() - r2.getRsvId());
			request.setAttribute("reserveList", reserveList);				//予約情報一覧をセット
			url = "reserveList.jsp";										//「予約一覧画面」へ
		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());
			url = "userIndex.jsp";											//「顧客処理選択画面」へ
			e.printStackTrace();
		}
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
