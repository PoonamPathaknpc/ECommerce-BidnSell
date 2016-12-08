package com.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.PostitemREST;

/**
 * Servlet implementation class Postitemserv
 */
public class Postitemserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Postitemserv() {
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
		String name=request.getParameter("name");
		String desc=request.getParameter("desc");
		String quantity=request.getParameter("quantity");
		String scopegender=request.getParameter("scopegender");
		String dept=request.getParameter("dept");
		String used=request.getParameter("used");
		
		if(used!=null)
		{
			used="off";
		}
		new PostitemREST().Postitem(userId,name,desc,quantity,scopegender,dept,used);
		
		request.setAttribute("userId", userId);
		RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Postsuccess.jsp");	
		rd.forward(request,response);
	}

}
