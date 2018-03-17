package com.emp.model;

import java.util.List;
import java.util.Map;

import com.emp.idb.IDBActivity;
import com.emp.idb.IDBEmployee;
import com.emp.jdbc.DBEmployee;

public class EmpDAOImpl implements IEmpDAO{
	private IDBEmployee emp;
	private IDBActivity act;
	
	EmpDAOImpl(){
		emp = new DBEmployee();
	}
	
	public void addEmp(EmpVO vo) {
		emp.addEmp(vo);
	}

	public List<EmpVO> getAll() {
		return emp.getAllEmp();
	}

	public void deleteEmp(String uid) {
		emp.deleteEmpById(uid);
	}

	public void updateEmp(EmpVO vo) {
		emp.updateEmpById(vo);
	}
	
	public Map<String, String> getEmpById(String uid){
		return emp.getIdEmp(uid);
	}

}
