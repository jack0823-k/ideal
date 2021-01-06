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

import model.Course;
import model.CourseCtl;
import model.IdealException;

/**
 * Servlet implementation class CourseOperationSvl
 */
@WebServlet("/CourseOperationSvl")
public class CourseOperationSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//フィールド
	public static final int INSERT = 21;
	public static final int UPDATE = 22;
	public static final int DELETE = 23;
	public static final int[] COURSE_MENU_TYPE_ID = {200, 210, 220, 300, 310, 400};

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseOperationSvl() {
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
		String url = "home.jsp";	//遷移先URL
		//セッションのadminInfoがnullならホームへ遷移
		HttpSession session = request.getSession();
		if(session.getAttribute("adminInfo") == null){
			response.sendRedirect(url);
		}
		int mode;	//モード(INSERT or UPDATE or DELETE)
		try{
			mode = Integer.parseInt(request.getParameter("mode"));
		}catch(NumberFormatException e){
			mode = 100;
		}
		//共通の変数、オブジェクトを生成
		Course c = new Course();;
		CourseCtl cc = null;
		ArrayList<CourseCtl> cclist = new ArrayList<>();
		String[] idNameArray = {"appetizerId", "soupId", "pastaId", "meatId", "fishId", "dessertId"};
		try{
			switch(mode){
				case INSERT:	//INSERT処理
					//リクエストパラメータの情報からCourseオブジェクトに値をセット
					c.setCourseName(request.getParameter("courseName"));
					c.setDetail(request.getParameter("detail"));
					c.setOrderFlg(Integer.parseInt(request.getParameter("orderFlg")));
					c.setPrice(Integer.parseInt(request.getParameter("price")));
					c.setTypeId(Integer.parseInt(request.getParameter("typeId")));
					//リクエストパラメータの情報からCourseCtlのlistにオブジェクトを追加
					for(String idName : idNameArray){
						cc = new CourseCtl();
						try{
							cc.setM_Id(Integer.parseInt(request.getParameter(idName)));
							cclist.add(cc);
						}catch(NumberFormatException e){
							continue;
						}
					}
					//データベース更新
					Course.updateCourse(c, mode, cclist);
					//リクエストオブジェクトにtypeIdをセット
					request.setAttribute("typeId", request.getParameter("typeId"));
					url = "MenuMaintenanceSvl";
					break;
				case UPDATE:	//UPDATE処理
					//リクエストパラメータの情報からCourseオブジェクトに値をセット
					System.out.println("couseoperationsvl;Updatestart");
					c.setCourseId(Integer.parseInt(request.getParameter("courseId")));
					c.setCourseName(request.getParameter("courseName"));
					c.setDetail(request.getParameter("detail"));
					c.setOrderFlg(Integer.parseInt(request.getParameter("orderFlg")));
					c.setPrice(Integer.parseInt(request.getParameter("price")));
					c.setTypeId(Integer.parseInt(request.getParameter("typeId")));
					//リクエストパラメータの情報からCourseCtlのlistにオブジェクトを追加
					for(String idName : idNameArray){
						cc = new CourseCtl();
						try{
							cc.setM_Id(Integer.parseInt(request.getParameter(idName)));
							cclist.add(cc);
							System.out.println(cc.toString());

						}catch(NumberFormatException e){
							System.out.println("updateでnumberformatexception");
							continue;
						}
					}
					//データベース更新
					Course.updateCourse(c, mode, cclist);
					//リクエストオブジェクトにtypeIdをセット
					request.setAttribute("typeId", request.getParameter("typeId"));
					url = "MenuMaintenanceSvl";
					break;
				case DELETE:	//DELETE処理
					//リクエストパラメータの情報からCourseオブジェクトに値をセット
					try {
						c.setCourseId(Integer.parseInt(request.getParameter("courseId")));
						c.setTypeId(Integer.parseInt(request.getParameter("typeId")));
						System.out.println("CourseOperationSvlのDELETE:ID確認");
						System.out.println(c.getCourseId());
						System.out.println(c.getTypeId());
						System.out.println(mode);
						System.out.println(cclist);


					} catch (NumberFormatException e) {
						System.out.println("courseId typeIdisnull");
					}
					//データベース更新
					Course.updateCourse(c, mode, cclist);
					//リクエストオブジェクトにtypeIdをセット
					request.setAttribute("typeId", request.getParameter("typeId"));
					url = "MenuMaintenanceSvl";
					break;
				default:
					System.out.println("modeの値 (" + mode + ") が不正です。");
					break;
			}
		}catch(IdealException e){
			request.setAttribute("msg", e.getMsg());
			url = "MenuMaintenanceSvl";
		}catch(Exception e){
			e.printStackTrace();
		}
		//フォワーディング
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}