package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogoffSvl
 */
@WebServlet("/AdminLogoffSvl")
public class AdminLogoffSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogoffSvl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get送信の場合でもdoPost()を呼び出す
		this.doPost(request, response);	}

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
		session.invalidate();			//sessionの破棄
		url = "home.jsp";				//遷移先URLのセット
		//フォワーディング
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
