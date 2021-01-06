package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import controller.MenuOperationSvl;

public class Menu implements Serializable{

	private static final long serialVersionUID = 1L;

	//フィールド
	private int    menuId;		//メニューID
	private String menuName;	//メニュー名
	private String detail;		//詳細
	private int    orderFlg;	//オーダー可否 (0:不可 1:可)
	private int    price;		//価格
	private int    typeId;		//分類ID
	private String typeName;	//分類名

	//コンストラクター
	public Menu(){
		super();
	}

	//アクセスメソッド
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

	/**
	 * メニュー情報取得処理。<br>
	 * メニューIDと分類IDからメニュー情報を取得し、Menu型で返すメソッド。
	 * @param menuId メニューID
	 * @param typeId 分類ID
	 * @return 取得したメニューの情報
	 * @throws IdealException
	 */
	public static Menu getOneMenu(int menuId, int typeId) throws IdealException {
		Menu m = new Menu();
		//データベース接続用の変数を宣言
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try{
			//データベース接続
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			//typeIDの値に応じてSQL文と、PreparedStatement型オブジェクトを生成
			if(typeId == 100){
				sql = "SELECT c_id AS id, c_name AS name, detail, orderFlg, price, t_id, t_name "
						+ "FROM course INNER JOIN menutype USING(t_id) "
						+ "WHERE c_id = ? "
						+ "ORDER BY id;";
			}else{
				sql = "SELECT m_id AS id, m_name AS name, detail, orderFlg, price, t_id, t_name "
						+ "FROM menu INNER JOIN menutype USING(t_id) "
						+ "WHERE m_id = ? "
						+ "ORDER BY id;";
			}
			pst = con.prepareStatement(sql);
			//インパラメータに値をセット
			pst.setInt(1, menuId);
			//SQL文を発行
			rs = pst.executeQuery();
			while(rs.next()){
				//取得した情報をMenu型オブジェクトの各フィールドにセット
				m.setMenuId(rs.getInt("id"));
				m.setMenuName(rs.getString("name"));
				m.setDetail(rs.getString("detail"));
				m.setOrderFlg(rs.getInt("orderFlg"));
				m.setPrice(rs.getInt("price"));
				m.setTypeId(rs.getInt("t_id"));
				m.setTypeName(rs.getString("t_name"));
			}
		}catch(Exception e){
			System.out.println("実行したSQL文：" + sql);
			e.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally{
			//クローズ処理
			try{
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return m;
	}

	/**
	 * メニュー情報一覧取得処理。<br>
	 * menu表のすべての行からMenu型オブジェクトを生成し、listに格納して返すメソッド。
	 * @return メニュー情報のArrayList
	 * @throws IdealException
	 */
	public static ArrayList<Menu> getMenuList() throws IdealException{
		ArrayList<Menu> al = new ArrayList<>();
		Menu m = null;
		//データベース接続用の変数を宣言
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try{
			//データベース接続
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			//SQL文、PreparedStatement型オブジェクトを生成
			sql = "SELECT m_id, m_name, detail, orderFlg, price, t_id, t_name "
					+ "FROM menu INNER JOIN menutype USING(t_id) "
					+ "ORDER BY t_id, m_id;";
			pst = con.prepareStatement(sql);
			//SQL文を発行
			rs = pst.executeQuery();
			while(rs.next()){
				//取得した情報をMenu型オブジェクトの各フィールドにセット
				m = new Menu();
				m.setMenuId(rs.getInt("m_id"));
				m.setMenuName(rs.getString("m_name"));
				m.setDetail(rs.getString("detail"));
				m.setOrderFlg(rs.getInt("orderFlg"));
				m.setPrice(rs.getInt("price"));
				m.setTypeId(rs.getInt("t_id"));
				m.setTypeName(rs.getString("t_name"));
				//listに追加
				al.add(m);
			}
		}catch(Exception e){
			System.out.println("実行したSQL文：" + sql);
			e.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally{
			//クローズ処理
			try{
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return al;
	}

	/**
	 * 分類別メニュー情報一覧取得処理。<br>
	 * 引数で指定された分類のメニュー情報をMenu型オブジェクトのlistで返す。
	 * @param typeId 分類ID
	 * @return メニュー情報のArrayList
	 * @throws IdealException
	 */
	public static ArrayList<Menu> getMenu(int typeId) throws IdealException{
		ArrayList<Menu> al = new ArrayList<>();
		Menu m = null;
		//データベース接続用の変数を宣言
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try{
			//データベース接続
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			//typeIDの値に応じてSQL文と、PreparedStatement型オブジェクトを生成
			if(typeId == 100){
				sql = "SELECT c_id AS id, c_name AS name, detail, orderFlg, price, t_id, t_name "
						+ "FROM course INNER JOIN menutype USING(t_id) "
						+ "WHERE t_id = ? "
						+ "ORDER BY id;";
			}else{
				sql = "SELECT m_id AS id, m_name AS name, detail, orderFlg, price, t_id, t_name "
						+ "FROM menu INNER JOIN menutype USING(t_id) "
						+ "WHERE t_id = ? "
						+ "ORDER BY id;";
			}
			pst = con.prepareStatement(sql);
			//インパラメータに値をセット
			pst.setInt(1, typeId);
			//SQL文を発行
			rs = pst.executeQuery();
			while(rs.next()){
				//取得した情報をMenu型オブジェクトの各フィールドにセット
				m = new Menu();
				m.setMenuId(rs.getInt("id"));
				m.setMenuName(rs.getString("name"));
				m.setDetail(rs.getString("detail"));
				m.setOrderFlg(rs.getInt("orderFlg"));
				m.setPrice(rs.getInt("price"));
				m.setTypeId(rs.getInt("t_id"));
				m.setTypeName(rs.getString("t_name"));
				//listに追加
				al.add(m);
			}
		}catch(Exception e){
			System.out.println("実行したSQL文：" + sql);
			e.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally{
			//クローズ処理
			try{
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return al;
	}

	/**
	 * メニュー情報更新処理。<br>
	 * modeに応じてmenu表、course表にINSERT, UPDATE, DELETEを行うメソッド。
	 * @param m メニュー情報（Menu型オブジェクト）
	 * @param mode 処理のモード
	 * @return 処理件数
	 * @throws IdealException
	 */
	public static int updateMenu(Menu m, int mode) throws IdealException{
		int n = 0;	//処理件数
		//データベース接続用の変数を宣言
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";
		try{
			//データベース接続
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			//modeの値に応じて処理を分ける
			switch(mode){
				case MenuOperationSvl.INSERT:	//INSERT処理
					//SQL文とPreparedStatement型オブジェクトを生成
					if(m.getTypeId() == 100){
						sql = "INSERT INTO course VALUES(DEFAULT, ?, ?, ?, ?, ?);";
					}else{
						sql = "INSERT INTO menu VALUES(DEFAULT, ?, ?, ?, ?, ?);";
					}
					pst = con.prepareStatement(sql);
					//各インパラメータに値をセット
					pst.setString(1, m.getMenuName());
					pst.setString(2, m.getDetail());
					pst.setInt(3, m.getOrderFlg());
					pst.setInt(4, m.getPrice());
					pst.setInt(5, m.getTypeId());
					//SQL文を発行
					n += pst.executeUpdate();
					break;
				case MenuOperationSvl.UPDATE:	//UPDATE処理
					//SQL文とPreparedStatement型オブジェクトを生成
					if(m.getTypeId() == 100){
						sql = "UPDATE course "
								+ "SET c_name = ?, detail = ?, orderFlg = ?, price = ?, t_id = ? "
								+ "WHERE c_id = ?;";
					}else{
						sql = "UPDATE menu "
								+ "SET m_name = ?, detail = ?, orderFlg = ?, price = ?, t_id = ? "
								+ "WHERE m_id = ?;";
					}
					pst = con.prepareStatement(sql);
					//各インパラメータに値をセット
					pst.setString(1, m.getMenuName());
					pst.setString(2, m.getDetail());
					pst.setInt(3, m.getOrderFlg());
					pst.setInt(4, m.getPrice());
					pst.setInt(5, m.getTypeId());
					pst.setInt(6, m.getMenuId());
					//SQL文を発行
					n += pst.executeUpdate();
					break;
				case MenuOperationSvl.DELETE:	//DELETE処理
					if(m.getTypeId() == 100){
						sql = "DELETE FROM course WHERE c_id = ?;";
					}else{
						sql = "DELETE FROM menu WHERE m_id = ?;";
					}
					pst = con.prepareStatement(sql);
					pst.setInt(1, m.getMenuId());
					n += pst.executeUpdate();
					break;
				default:
					System.out.println("渡されたmodeの値(=" + mode + ")が不正です。");
					break;
			}
		}catch(NamingException | SQLException e){
			System.out.println("実行したSQL文：" + sql);
			e.printStackTrace();
			throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}finally{
			//クローズ処理
			try{
				if(rs != null){
					rs.close();
				}
				if(pst != null){
					pst.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return n;
	}

}