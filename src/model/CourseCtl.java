package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CourseCtl {
	private int c_Id;
	private int m_Id;

	public int getC_Id() {
		return c_Id;
	}
	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public int getM_Id() {
		return m_Id;
	}
	public void setM_Id(int m_Id) {
		this.m_Id = m_Id;
	}

	//コース内メニュー管理処理
	public static void courseMenuChk(int mId) throws IdealException{
		//DB接続の準備
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "";

		//DB接続
		try{
			//データソースをリース
			ic = new InitialContext();
			//データソースをリース
			ds = (DataSource)ic.lookup("java:comp/env/mysql");
			//コネクションを実装
			con = ds.getConnection();

			//SQL文の作成:mId
			sql += "SELECT m_Id";
			sql += " FROM coursectl";
			sql += " WHERE m_Id = ?;";

			pst = con.prepareStatement(sql);
			pst.setInt(1, mId);
			rs = pst.executeQuery();

			//if(コースコントロールテーブルにm_Idが存在したとき)
			//throw new IdealException(IdealException.ERR_NO_NOT_MENU_DELETE);
			if(rs.next()){
				throw new IdealException(IdealException.ERR_NO_NOT_MENU_DELETE);
			}
		//例外発生時は以下をスロー
		//throw new IdealException(IdealException.ERR_NO_DB_EXCEPTION);
		}catch(SQLException  | NamingException e){
			throw new IdealException(IdealException.ERR_NO_NOT_MENU_DELETE);


		//クローズ処理
		}finally{
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			}catch(Exception e){
				e.printStackTrace();
				}
			}
		}
	@Override
	public String toString() {
		return "CourseCtl [c_Id=" + c_Id + ", m_Id=" + m_Id + "]";
	}
	}
