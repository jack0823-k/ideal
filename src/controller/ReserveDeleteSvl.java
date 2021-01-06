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
import model.Reserve;
import model.User;

/**
 * Servlet implementation class ReserveDeleteSvl
 */
@WebServlet("/ReserveDeleteSvl")
public class ReserveDeleteSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveDeleteSvl() {
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
		User user = (User) session.getAttribute("userInfo");// セッション情報の取得
		if (user == null) { // nullの場合は「ホーム」へ
			url = "home.jsp";
			response.sendRedirect(url);
		}
		try {
			int rsvId = Integer.parseInt(request.getParameter("rsvId"));
			Reserve reserve = Reserve.getReserve(rsvId);
			request.setAttribute("reserve", reserve);
			url = "reserveDelete.jsp";
		} catch (NumberFormatException e) {
			request.setAttribute("msg", "rsvIdが取得できません。");
			url = "ReserveListSvl";				//「予約一覧表示処理(サーブレット)」へ
			e.printStackTrace();
		} catch (IdealException e) {
			request.setAttribute("msg", e.getMsg());
			url = "ReserveListSvl";				//「予約一覧表示処理(サーブレット)」へ
			e.printStackTrace();
		}

		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
