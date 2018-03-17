package com.emp.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.sql.DataSource;

import com.emp.idb.IDBActivity;
import com.emp.idb.IDBEmployee;
import com.emp.model.EmpVO;
import com.emp.util.DBUtil;


public class DBEmployee implements IDBEmployee{
	
	public List<EmpVO> getAllEmp() {
		Connection conn = null;
		try {
			conn = com.emp.util.Context.getConnection();
			String sql = DBUtil.getSelectSql(IDBEmployee.TABLE, IDBEmployee.COLUMNS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			List<EmpVO> list = new ArrayList<EmpVO>();
			while (rs.next()){
				EmpVO emp = new EmpVO();
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setSal(rs.getInt("sal"));
				emp.setId(rs.getString("id"));
				emp.setJob(rs.getString("job"));
				list.add(emp);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Map<String, String> getIdEmp(String uid) {
		Connection conn = null;
		try {
			conn = com.emp.util.Context.getConnection();
			String sql = "SELECT job, name, age, sal FROM employee WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Map<String, String>map = new HashMap<String, String>();
			map.put("job", rs.getString("job"));
			map.put("name", rs.getString("name"));
			map.put("age", rs.getString("age"));
			map.put("sal", rs.getString("sal"));
			map.put("id", uid);
			
			rs.close();
			ps.close();
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
	
	public void addEmp(EmpVO vo) {
		Connection conn =null;
		try {
			conn = com.emp.util.Context.getConnection();
			conn.setAutoCommit(false);
			
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
			Date current = new Date();
			String date = sdFormat.format(current);
			String uid = UUID.randomUUID().toString();
		
			String emp = DBUtil.getInsertSql(IDBEmployee.TABLE, IDBEmployee.COLUMNS);
			PreparedStatement psEmp = conn.prepareStatement(emp);
			psEmp.setString(1, uid);
			psEmp.setString(2, vo.getJob());
			psEmp.setString(3, vo.getName());
			psEmp.setInt(4, vo.getAge());
			psEmp.setInt(5, vo.getSal());
			psEmp.execute();
			
			String log = DBUtil.getInsertSql(IDBActivity.TABLE, IDBActivity.COLUMNS);
			PreparedStatement psLog = conn.prepareStatement(log);
			psLog.setString(1, date);
			psLog.setString(2, uid);
			psLog.setString(3, IDBActivity.ADD);
			psLog.execute();
			
			conn.commit();
			
			psLog.close();
			psEmp.close();
		} catch (SQLException e) {
            try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
			}
		} finally {
			if(conn != null)
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	public void updateEmpById(EmpVO vo){
		Connection conn = null;
		try {
			conn = com.emp.util.Context.getConnection();
			conn.setAutoCommit(false);
			
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
			String date = sdFormat.format(new Date());
			
			String emp = DBUtil.getUpdateSql(IDBEmployee.TABLE, IDBEmployee.UPDATE_COLUMNS, "id");
			PreparedStatement psEmp = conn.prepareStatement(emp);
			psEmp.setString(1, vo.getJob());
			psEmp.setString(2, vo.getName());
			psEmp.setInt(3, vo.getAge());
			psEmp.setInt(4, vo.getSal());
			psEmp.setString(5, vo.getId());
			psEmp.execute();
			
			String act = DBUtil.getInsertSql(IDBActivity.TABLE, IDBActivity.COLUMNS);
			PreparedStatement psLog = conn.prepareStatement(act);
			psLog.setString(1, date);
			psLog.setString(2, vo.getId());
			psLog.setString(3, IDBActivity.UPDATE);
			psLog.execute();
			
			conn.commit();
			
			psLog.close();
			psEmp.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void deleteEmpById(String uid){
		Connection conn = null;
		try {
			conn = com.emp.util.Context.getConnection();
			conn.setAutoCommit(false);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
			String date = format.format(new Date());
			
			String sql = "DELETE FROM employee WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.execute();
			
			String act = DBUtil.getInsertSql(IDBActivity.TABLE, IDBActivity.COLUMNS);
			PreparedStatement psLog = conn.prepareStatement(act);
			psLog.setString(1, date);
			psLog.setString(2, uid);
			psLog.setString(3, IDBActivity.DELECT);
			psLog.execute();
			
			conn.commit();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
