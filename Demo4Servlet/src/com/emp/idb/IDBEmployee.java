package com.emp.idb;

import java.util.List;
import java.util.Map;

import com.emp.model.EmpVO;

public interface IDBEmployee {
	final String TABLE ="employee";
	final String[] COLUMNS= {
		"id",
		"job",
		"name",
		"age",
		"sal",
	};
	
	final String[] UPDATE_COLUMNS= {
			"job",
			"name",
			"age",
			"sal",
	};
	
	void addEmp(EmpVO vo);
	List<EmpVO> getAllEmp();
	void deleteEmpById(String uid);
	void updateEmpById(EmpVO vo);
	Map<String, String> getIdEmp(String uid);
}
