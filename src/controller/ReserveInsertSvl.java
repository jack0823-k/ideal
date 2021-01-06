package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Course;
import model.IdealException;
import model.Reserve;
import model.User;

/**
 * Servlet implementation class ReserveInsertSvl
 */
@WebServlet("/ReserveInsertSvl")
public class ReserveInsertSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveInsertSvl() {
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
		//Reserveオブジェクトの各パラメータが入る変数を宣言
		int rsvYy;
		int rsvMm;
		int rsvDd;
		int rsvHh;
		int rsvMi;
		int usrId;
		int person;
		int courseId;

		User user = (User) session.getAttribute("userInfo");//セッション情報の取得
		if (user == null) {				//nullの場合は「ホーム」へ
			url = "home.jsp";
			response.sendRedirect(url);
		}
		try {
			usrId = user.getUsrId();		//念のためセッションから取得
		} catch (Exception e) {
			request.setAttribute("msgUser", "userIdが取得できていません");
			usrId = 0;
			e.printStackTrace();
		}
		try {
			rsvYy = Integer.parseInt(request.getParameter("rsvYy"));
			rsvMm = Integer.parseInt(request.getParameter("rsvMm"));
			rsvDd = Integer.parseInt(request.getParameter("rsvDd"));
			rsvHh = Integer.parseInt(request.getParameter("rsvHh"));
			rsvMi = Integer.parseInt(request.getParameter("rsvMi"));
			person = Integer.parseInt(request.getParameter("person"));
			courseId = Integer.parseInt(request.getParameter("courseId"));
		} catch (NumberFormatException e) {
			rsvYy = 0;
			rsvMm = 0;
			rsvDd = 0;
			rsvHh = 0;
			rsvMi = 0;
			person = 0;
			courseId = 0;
		}
		try {
			ArrayList<Course> courses = Course.getOneCourseList();
			courses.removeIf( c -> c.getOrderFlg() == 0);//オーダー不可の要素をListから削除
			request.setAttribute("courseList", courses);

			if (rsvYy == 0) {			//日時が0の場合は現在時刻を設定
				LocalDateTime lo = LocalDateTime.now();
				rsvYy = lo.getYear();
				rsvMm = lo.getMonthValue();
				rsvDd = lo.getDayOfMonth();
				rsvHh = lo.getHour();
				rsvMi = lo.getMinute();
			}
			//予約情報の生成(Reserve)
			Reserve reserve = new Reserve();
			reserve.setRsvYy(rsvYy);
			reserve.setRsvMm(rsvMm);
			reserve.setRsvDd(rsvDd);
			reserve.setRsvHh(rsvHh);
			reserve.setRsvMi(rsvMi);
			reserve.setUsrId(usrId);
			reserve.setPerson(person);
			reserve.setCourseId(courseId);
			request.setAttribute("reserve", reserve);
			url = "reserveInsert.jsp";			//「新規予約画面」へ

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
