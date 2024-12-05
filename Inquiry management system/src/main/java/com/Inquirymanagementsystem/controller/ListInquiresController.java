package com.Inquirymanagementsystem.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Inquirymanagementsystem.model.DAOServiceImpl;

@WebServlet("/listInquiresController")
public class ListInquiresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ListInquiresController() {
        super();   
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
	    session.setMaxInactiveInterval(10);

		DAOServiceImpl service= new DAOServiceImpl();
		service.connectDB();
		ResultSet result = service.getAllInquiries();
		request.setAttribute("res", result); 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/all_inquiries.jsp");
		rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
