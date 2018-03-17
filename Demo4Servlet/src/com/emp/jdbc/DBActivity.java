package com.emp.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.emp.idb.IDBActivity;
import com.emp.util.DBUtil;

public class DBActivity implements IDBActivity{
	private static DataSource ds = null;

	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public int getLog() {
		Connection conn = null;
		
		try {
			conn =ds.getConnection();
			String sql = DBUtil.getSelectSql(IDBActivity.TABLE, IDBActivity.COLUMNS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		}catch(Exception e) {
			
		}
		
		return 0;
	}

}
