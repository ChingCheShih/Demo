package com.emp.model;

import java.util.List;
import java.util.Map;

public interface IEmpDAO {
	void addEmp(EmpVO vo);
	List<EmpVO> getAll();
	void deleteEmp(String uid);
	void updateEmp(EmpVO vo);
	Map<String, String> getEmpById(String uid);
}
