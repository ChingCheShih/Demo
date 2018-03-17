package com.emp.util;

public class DBUtil {
	public static String getSelectSql(String table, String[] cols){
		StringBuilder sb = new StringBuilder().append("SELECT ");
		
		for(int i =0; i<cols.length; i++){
			if(i>0)
				sb.append(", ");
			
			sb.append(cols[i]);
		}
		sb.append(" FROM ").append(table);
		
		return sb.toString();
	}
	
	public static String getInsertSql(String table, String[] cols){
		StringBuilder sb = new StringBuilder().append("INSERT INTO ").append(table);
		sb.append(" (");
		for(int i =0; i<cols.length; i++){
			if (i>0)
				sb.append(", ");
			
			sb.append(cols[i]);
		}
		sb.append(" ) VALUES (");
		for(int mapping =0; mapping<cols.length; mapping++){
			if(mapping >0)
				sb.append(", ");
			
			sb.append("?");
		}
		sb.append(" )");
		
		return sb.toString();
	}
	
	public static String getUpdateSql(String table, String[] cols, String... where) {
		StringBuilder sb = new StringBuilder().append("UPDATE ")
				.append(table).append(" SET ");
		for(int i=0; i<cols.length; i++) {
			if(i!=0)
				sb.append(" ,");
			
			sb.append(cols[i] + " = ?");
		}
		
		sb.append(" WHERE ");
		
		for(int i =0; i< where.length; i++) {
			if(i!=0)
				sb.append(" AND ");
			
			sb.append(where[i]).append(" = ?");
		}
		
		return sb.toString();
	}
}
