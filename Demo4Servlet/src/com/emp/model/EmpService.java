package com.emp.model;

import java.util.List;
import java.util.Map;

public class EmpService {
	IEmpDAO dao = null;
	
	public EmpService(){
		dao = new EmpDAOImpl();
	}
	
	public void addEmp(String name, int age, int sal, String job){
		EmpVO vo = new EmpVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setSal(sal);
		vo.setJob(job);
		dao.addEmp(vo);
	}
	
	public void updateEmp(String id, String name, int age, int sal, String job){
		EmpVO vo = new EmpVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setSal(sal);
		vo.setJob(job);
		vo.setId(id);
		dao.updateEmp(vo);
	}
	
	public List<EmpVO> getAll(){
		return dao.getAll();
	}
	
	public void deleteEmp(String uid){
		dao.deleteEmp(uid);
	}
	
	public Map<String, String> getEmpById(String uid){
		return dao.getEmpById(uid);
	}
	
}
