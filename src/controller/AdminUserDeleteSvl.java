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
 * Servlet implementation class UserDeleteSvl
 */
@WebServlet("/AdminUserDeleteSvl")
public class AdminUserDeleteSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserDeleteSvl() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charset=UTF-8");
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		int usrId = Integer.parseInt(request.getParameter("usrId"));
		String url;
		if (session.getAttribute("adminInfo") == null) {
			response.sendRedirect("home.jsp");
		}
		try{
			request.setAttribute("user",User.getUser(usrId));
			url = "adminUserDelete.jsp";
		}catch(IdealException e){
			//リクエストオブジェクト"msg"に独自例外()よりメッセージを取得し設定する。
			request.setAttribute("msg", e.getMsg());
			url = "userIndex.jsp";
		}
		rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
