package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import controller.CourseOperationSvl;

public class Course {
	// フィールド
	private int courseId;
	private String courseName;
	private String detail;
	private int orderFlg;
	private int price;
	private int typeId;
	private String typeName;
	private int menuType;
	private int menuId;
	private String menuName;
	public static final int[] COURSE_MENU_TYPE_ID = { 200, 210, 220, 300, 310,
			400 };

	// アクセスメソッド
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getOrderFlg() {
		return orderFlg;
	}

	public void setOrderFlg(int orderFlg) {
		this.orderFlg = orderFlg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getMenuType() {
		return menuType;
	}

	public void setMenuType(int menuType) {
		this.menuType = menuType;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public static int[] getCourseMenuTypeId() {
		return COURSE_MENU_TYPE_ID;
	}

	// コース情報処理メソッド
	/*
	 * 引数のコースID(c_id)で、データベースのコーステーブルより、該当するコース情報を 取得し呼び出し元に戻す。
	 */

	public static Course getCourse(int c_id) throws IdealException {
		// DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		// 変数の宣言と初期化
		Course c = null;
		String sql = "";

		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();

			// SQL文の作成
			sql += "SELECT * FROM";
			sql += " course";
			sql += " WHERE";
			sql += " c_id";
			sql += " = ?";

			pst = con.prepareStatement(sql);
			pst.setInt(1, c_id);
			rs = pst.executeQuery();

			if (rs.next()) {
				// Courseオブジェクトを生成
				c = new Course();
				c.setCourseId(rs.getInt("c_id"));
				c.setCourseName(rs.getString("c_name"));
				c.setDetail(rs.getString("detail"));
				c.setOrderFlg(rs.getInt("orderFlg"));
				c.setPrice(rs.getInt("price"));
				c.setTypeId(rs.getInt("t_id"));

			}

		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Course型で返す
		return c;

	}

	// コース情報取得処理メソッド（明細メニュー含む）
	/*
	 * データベースのコーステーブル及びコースコントロールテーブルメニューテーブルより、
	 * 引数のコースID(c_id)に対応するコース情報とコースの構成メニューをArrayList<Course>に格納し呼び出し元に戻す。
	 */

	public static ArrayList<Course> getOneCourse(int c_id)
			throws IdealException {
		ArrayList<Course> al = new ArrayList<>();

		// DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		// 変数の宣言と初期化
		Course c = null;
		String sql = "";

		try {
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");//idealではない
			con = ds.getConnection();

			// SQL文の作成:修正後
			sql += "SELECT * FROM course";
			sql += " INNER JOIN coursectl";
			sql += " USING(c_id)";
			sql += " INNER JOIN menu";
			sql += " USING(m_id)";
			sql += " WHERE c_id = ?;";

//			// SQL文の作成
//			sql += "SELECT * FROM";
//			sql += " INNER JOIN coursectl";
//			sql += " USING(c_id)";
//			sql += " INNER JOIN menu";
//			sql += " USING(m_id) WHERE";
//			sql += " WHERE c_id = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, c_id);
			rs = pst.executeQuery();

			while (rs.next()) {		//if文になってました
				// Courseオブジェクトを生成
				c = new Course();
				c.setCourseId(rs.getInt("c_id"));
				c.setCourseName(rs.getString("c_name"));
				c.setDetail(rs.getString("detail"));
				c.setOrderFlg(rs.getInt("orderFlg"));
				c.setPrice(rs.getInt("price"));
				c.setTypeId(rs.getInt("course.t_id"));//t_idの名称がかぶっているので完全修飾で記述
				// TODO 仕様書上はここに「メニュー分類ID（メニューテーブルより）」とあるが、対応するフィールドが存在しない
				c.setMenuType(rs.getInt("menu.t_id"));//t_idの名称がかぶっているので完全修飾で記述
				c.setMenuId(rs.getInt("m_id"));
				c.setMenuName(rs.getString("m_Name"));
				al.add(c);

			}

		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ArrayListオブジェクトを返す
		return al;
	}

	// コース情報一覧取得処理（明細メニュー含む）
	public static ArrayList<Course> getCourseList() throws IdealException {

		ArrayList<Course> al = new ArrayList<>();
		Course m = null;
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		try {
			// データベース接続
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();

			// DO SQLわからない
			sql = "SELECT * FROM course";
			sql += " INNER JOIN coursectl";
			sql += " USING(c_id)";
			sql += " INNER JOIN menu";
			sql += " USING(m_id)";
			sql += " ORDER BY c_id;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				m = new Course();
				m.setCourseId(rs.getInt("c_id"));
				m.setCourseName(rs.getString("c_name"));
				m.setDetail(rs.getString("course.detail"));
				m.setOrderFlg(rs.getInt("course.orderFlg"));
				m.setPrice(rs.getInt("course.price"));
				m.setTypeId(rs.getInt("course.t_id"));
				// TODO 仕様書上はここに「メニュー分類ID（メニューテーブルより）」とあるが、対応するフィールドが存在しない
				m.setMenuId(rs.getInt("m_id"));
				m.setMenuName(rs.getString("m_name"));
				al.add(m);

			}
		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			// クローズ処理
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
				}
			}
		}
		return al;
	}

	// コース情報一覧取得処理
	public static ArrayList<Course> getOneCourseList() throws IdealException {

		ArrayList<Course> al = new ArrayList<>();
		Course m = null;
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try {
			// データベース接続
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql = "SELECT c_id,c_name,detail,orderFlg,price,t_id FROM course";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				m = new Course();
				m.setCourseId(rs.getInt("c_id"));
				m.setCourseName(rs.getString("c_name"));
				m.setDetail(rs.getString("detail"));
				m.setOrderFlg(rs.getInt("orderFlg"));
				m.setPrice(rs.getInt("price"));
				m.setMenuId(rs.getInt("t_id"));
				al.add(m);

			}
		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			// クローズ処理
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (Exception e) {
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);

				}
			}
		}
		return al;
	}

	// データベースのコーステーブルから引数の分類ID(t_id)に該当するコース取得し、
	// ArrayList<Course>に格納して返すメソッド
	public static ArrayList<Course> getTypeCourseList(int t_id)
			throws IdealException {
		ArrayList<Course> al = new ArrayList<>();
		Course c = null;
		// データベース接続用の変数を宣言
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try {
			// データベース接続
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/ideal");
			con = ds.getConnection();
			// typeIDの値に応じて、SQL文を生成
			if (t_id == 100) {
				sql = "SELECT c_id, c_name, detail, orderFlg, price, t_id, t_name FROM course "
						+ "INNER JOIN menutype USING(t_id) WHERE t_id = ? ORDER BY c_id;";

			}
			// PreparedStatement型オブジェクトを生成
			pst = con.prepareStatement(sql);
			// インパラメータに値をセット
			pst.setInt(1, (t_id));
			// SQL文を発行
			rs = pst.executeQuery();
			while (rs.next()) {
				// 取得した情報をMenu型オブジェクトの各フィールドにセット
				c = new Course();
				c.setCourseId(rs.getInt("c_id"));
				c.setCourseName(rs.getString("c_name"));
				c.setDetail(rs.getString("detail"));
				c.setOrderFlg(rs.getInt("orderFlg"));
				c.setPrice(rs.getInt("price"));
				c.setTypeName(rs.getString("t_name"));
				// listに追加
				al.add(c);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("実行したSQL文: " + sql);
			e.printStackTrace();
		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		} finally {
			// クローズ処理
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return al;
	}

	// コース情報更新処理（modeに応じてcourse表、coursectl表にINSERT, UPDATE, DELETEを行うメソッド）
	public static int updateCourse(Course c, int mode,
			ArrayList<CourseCtl> coursectl) throws IdealException {
		System.out.println("updateCourse:");
		for (int i = 0; i < coursectl.size(); i++) {
			System.out.println(coursectl.get(i).toString());;

		}
		int n = 0; // 処理件数
		// データベース接続用の変数を宣言
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		ResultSet rs = null;
		String sql = "";
		String sql2 = "";
		String sql3 = "";
		int c_id = 0; //INSERT文でc_idを格納する変数
		try {
			// データベース接続
			ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			// modeの値に応じて処理を分ける
			switch (mode) {
			case CourseOperationSvl.INSERT: // INSERT処理
				// SQL文を生成(courseテーブル)
				sql = "INSERT INTO course VALUES(DEFAULT, ?, ?, ?, ?, ?);";
				// PreparedStatement型オブジェクトを生成
				pst = con.prepareStatement(sql);
				// 各インパラメータに値をセット
				pst.setString(1, c.getCourseName());
				pst.setString(2, c.getDetail());
				pst.setInt(3, c.getOrderFlg());
				pst.setInt(4, c.getPrice());
				pst.setInt(5, c.getTypeId());
				// SQL文を発行
				n += pst.executeUpdate();
				//INSERTのみで行う処理(UPDATE,DELETEでは新しい行は生成されない為行わない)
				//上記で追加した時点でc_idが出来る為SELECT文でc_idを取り出す
				sql3 += "SELECT * FROM course";
				sql3 += " WHERE";
				sql3 += " c_name = ?;";

				pst3 = con.prepareStatement(sql3);
				// 各インパラメータに値をセット
				pst3.setString(1, c.getCourseName());
				System.out.println(c.getCourseName());
				rs = pst3.executeQuery();

				if(rs.next()){
					//c_idを入れる変数を宣言
					c_id = rs.getInt("c_id");
					System.out.println(c_id);
				}

				// SQL文を作成(coursectlテーブル)
				sql2 = "INSERT INTO coursectl VALUES(?, ?)";
				pst2 = con.prepareStatement(sql2);
				// 各インパラメータに値をセット
				for (int i = 0; i < coursectl.size(); i++) {
					if (coursectl.get(i).getM_Id() ==0) {
						continue;
					}
					// ArrayListに格納されているクラスの参照(m_id)
					pst2.setInt(1, c_id);
					pst2.setInt(2, coursectl.get(i).getM_Id());
					// SQL文を発行
					n += pst2.executeUpdate();
				}
				break;

			case CourseOperationSvl.UPDATE: // UPDATE処理
				// SQL文を生成(courseテーブル)
				System.out.println(" CourseOperationSvl.UPDATE:start");

				sql = "UPDATE course SET c_name = ?, detail = ?, orderFlg = ?, price = ?, t_id = ? WHERE c_id = ?;";
				// PreparedStatement型オブジェクトを生成
				pst = con.prepareStatement(sql);
				// 各インパラメータに値をセット
				pst.setString(1, c.getCourseName());
				pst.setString(2, c.getDetail());
				pst.setInt(3, c.getOrderFlg());
				pst.setInt(4, c.getPrice());
				pst.setInt(5, c.getTypeId());
				pst.setInt(6, c.getCourseId());
				// SQL文を発行
				n += pst.executeUpdate();
				System.out.println(sql);
				// SQL文を作成(coursectlテーブル)
				System.out.println(" CourseOperationSvl.UPDATE:coursestl:start");
				c_id = c.getCourseId();
				System.out.println(c_id);
				sql2 = "DELETE FROM coursectl WHERE c_id = ? ;";
				pst2 = con.prepareStatement(sql2);
				pst2.setInt(1, c_id);
				pst2.executeUpdate();
				// SQL文を作成(coursectlテーブル)
				sql3 = "INSERT INTO coursectl VALUES(?, ?)";
				pst3 = con.prepareStatement(sql3);
				// 各インパラメータに値をセット
				System.out.println("updateCourse:coursectl");
				for (int i = 0; i < coursectl.size(); i++) {
					System.out.println(coursectl.get(i).toString());;
				}
				System.out.println("updateCourse:m_Idが0だとループから抜けてしまう");
				for (int i = 0; i < coursectl.size(); i++) {
					if (coursectl.get(i).getM_Id() ==0) {
						continue;
					}
					// ArrayListに格納されているクラスの参照(m_id)
					pst3.setInt(1, c_id);
					System.out.println(coursectl.get(i).toString());
					pst3.setInt(2, coursectl.get(i).getM_Id());
					// SQL文を発行
					n += pst3.executeUpdate();
				}
				break;

			case CourseOperationSvl.DELETE: // DELETE処理
				//外部キー制約を無効化
				sql = "SET FOREIGN_KEY_CHECKS = 0;";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
				pst.close();
				// SQL文を生成、発行(coursectlテーブル)
				sql2 = "DELETE FROM coursectl WHERE c_id = ?;";
				pst2 = con.prepareStatement(sql2);
				pst2.setInt(1, c.getCourseId());
				n += pst2.executeUpdate();
				// SQL文を生成、発行(courseテーブル)
				sql3 = "DELETE FROM course WHERE c_id = ?;";
				pst3 = con.prepareStatement(sql3);
				int couseId = c.getCourseId();
				pst3.setInt(1,couseId);
				n += pst3.executeUpdate();
				//外部キー制約を有効化
				sql = "SET FOREIGN_KEY_CHECKS = 1;";
				pst = con.prepareStatement(sql);
				pst.executeUpdate();
				break;

			default:
				System.out.println("渡されたmodeの値(=" + mode + ")が不正です。");
				break;
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("実行したSQL文: " + sql);
			e.printStackTrace();
			// ロールバック処理
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		} catch (Exception e) {
			throw new IdealException(IdealException.ERR_NO_EXCEPTION);
		} finally {
			// コミット処理
			if (con != null) {
				try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// クローズ処理
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst2 != null) {
				try {
					pst2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return n;
	}

}
