package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.IdealException;
import model.Reserve;

/**
 * Servlet implementation class AdminReserveListSvl
 */
@WebServlet("/AdminReserveListSvl")
public class AdminReserveListSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReserveListSvl() {
        super();
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
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		String url = ""; //遷移先URL
		HttpSession session = request.getSession();
		//AdminInfoがnullの場合は「ホーム」へ
		Admin ad = (Admin) session.getAttribute("adminInfo");
		if (ad == null) {
			url = "home.jsp";
			response.sendRedirect(url);
		}
		//閲覧する予約情報の年月日をリクエストパラメータから取得する
		//初回アクセス時は現在の年月日をセットする
		String selectedDateStr;
		if(request.getParameter("selectedDateStr") != null){
			selectedDateStr = request.getParameter("selectedDateStr");
		}else{
			selectedDateStr = LocalDate.now().toString();
		}
		//指定した年月日情報から、その日の予約情報一覧を取得しリクエストパラメータにセットする
		try{
			ArrayList<Reserve> rlist = Reserve.getReserveDailyList(selectedDateStr);
			//予約時間の昇順かつテーブルIDの昇順にソート
			Collections.sort(rlist, (r1, r2) -> {
				int i = 0;
				if(r1.getRsvHh() < r2.getRsvHh()){
					i = -1;
				}else if(r1.getRsvHh() > r2.getRsvHh()){
					i = 1;
				}else{
					if(r1.getRsvMi() < r2.getRsvMi()){
						i = -1;
					}else if(r1.getRsvMi() > r2.getRsvMi()){
						i = 1;
					}else{
						if(r1.getTableId() < r2.getTableId()){
							i = -1;
						}else{
							i = 1;
						}
					}
				}
				return i;
			});
			request.setAttribute("reserveList", rlist);
		}catch(IdealException e){
			request.setAttribute("msg", e.getMsg());
		}
		//フォワーディング
		url = "adminReserveList.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}