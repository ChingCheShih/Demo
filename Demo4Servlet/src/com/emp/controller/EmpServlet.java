package com.emp.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.emp.model.EmpService;




public class EmpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String act = req.getParameter("action");
		
		if(act != null && act.equals("insert")){
			Map<String, String> err = new HashMap<String, String>();
			req.setAttribute("errorMsgs", err);
				
			String name =req.getParameter("name").trim();
			String age =req.getParameter("age").trim();
			String sal =req.getParameter("sal").trim();
			String job =req.getParameter("job").trim();
			int int_sal = 0;
			int int_age = 0;
				
			if(name.isEmpty() || name.length()==0)
				err.put("name", "name can't empty");
			
			if(age.isEmpty() || age.length()==0)
				err.put("age", "age can't empty");
			else {
				try {
					int_age = Integer.parseInt(age);
				} catch (NumberFormatException e) {
					err.put("age", "input error type in age");
				}
			}
			
			if(sal.isEmpty() || sal.length()==0)
				err.put("sal", "sal can't empty");
			else {
				try {
					int_sal = Integer.parseInt(sal);
				} catch (NumberFormatException e) {
					err.put("sal", "input error type in sal");
				}
			}
			
			if(job.isEmpty() || job.length()==0)
				err.put("job", "job can't empty");
			
			if(!err.isEmpty()){
				RequestDispatcher fail = req.getRequestDispatcher("/addEmp.jsp");
				fail.forward(req, res);
				return;
			}
			
			EmpService service = new EmpService();
			
			String id = req.getParameter("id").trim();
			if(id != null && !id.isEmpty() && id.length()!=0){
				service.updateEmp(id, name, int_age, int_sal, job);
				
				RequestDispatcher success = req.getRequestDispatcher("/listAllEmp.jsp");
				success.forward(req, res);
				return;
			}
			
			service.addEmp(name, int_age, int_sal, job);
			RequestDispatcher success = req.getRequestDispatcher("/listAllEmp.jsp");
			success.forward(req, res);
		} else if(act != null && act.equals("delete")){
			String uid = req.getParameter("id");
			EmpService service = new EmpService();
			service.deleteEmp(uid);
			
			RequestDispatcher success = req.getRequestDispatcher("/listAllEmp.jsp");
			success.forward(req, res);
		} else if (act != null && act.equals("update")){
			String uid = req.getParameter("id");
			EmpService service = new EmpService();
			Map<String, String> data =service.getEmpById(uid);
			req.setAttribute("data", data);
			
			RequestDispatcher update = req.getRequestDispatcher("/addEmp.jsp");
			update.forward(req, res);
		}
		
	}

}
