package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MenuType {
	//フィールド
	private int typeId;
	private String typeName;

	//アクセスメソッド
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
	//引数なしのコンストラクター
		public MenuType(){
		super();
		}

	//getAlltype()メソッド
	public static ArrayList<MenuType> getAllType() throws IdealException{
		ArrayList<MenuType> al = new ArrayList<MenuType>();
		InitialContext ic =null;
		DataSource ds = null;
		Connection con = null;
		String sql = "";
		ResultSet rs = null;
		PreparedStatement pst = null;

	//データベースの分類テーブルより分類ID昇順で取得
		try{
			ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			con = ds.getConnection();
			sql = "SELECT * FROM menuType ORDER BY t_id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery(sql);

			while(rs.next()){
				MenuType mt = new MenuType();
				mt.setTypeId(rs.getInt("t_id"));
				mt.setTypeName(rs.getString("t_name"));
				al.add(mt);
			}

		}catch(Exception e){

		}finally{
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
				throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
			}
		}
		return al;
	}

}


