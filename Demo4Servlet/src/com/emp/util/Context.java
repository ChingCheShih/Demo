package com.emp.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Context {
	private static DataSource ds = null;
	
	static {
		try {
			javax.naming.Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			Connection conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
