package com.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.BidrequestREST;

/**
 * Servlet implementation class Bidrequestserv
 */
public class Bidrequestserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bidrequestserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String userId=request.getParameter("userId");
		String itemId=request.getParameter("itemId");
		String price=request.getParameter("price");
		System.out.println(itemId + ":: " +  userId + "::" + price); 
		new BidrequestREST().Addbid(userId,itemId,price);
		RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Bidsuccess.jsp");	
		rd.forward(request,response);
		
	}

}
