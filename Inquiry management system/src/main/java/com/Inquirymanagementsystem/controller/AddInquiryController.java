package com.Inquirymanagementsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Inquirymanagementsystem.model.DAOServiceImpl;


@WebServlet("/addInquiry")
public class AddInquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddInquiryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/add_inquiry.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			HttpSession session = request.getSession(false);
			if(session.getAttribute("email")!=null) {
		     session.setMaxInactiveInterval(10);

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String course = request.getParameter("course");
			
			DAOServiceImpl service =new  DAOServiceImpl();
			service.connectDB();
			service.addInquiry(name, email, mobile, course);
			request.setAttribute("msg", "Record is save!!");
			 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/add_inquiry.jsp");
				rd.forward(request, response);
			}else {
				
				 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
			}
			
			
		}catch(Exception e) {
			request.setAttribute("error", "Session timedout!!!"); 
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
