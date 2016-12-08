package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.rest.LoginREST;


/**
 * Servlet implementation class Loginserv
 */
public class Loginserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		String em=request.getParameter("email");
		String pa=request.getParameter("pass");
		String[] results=new LoginREST().LoginValid(em,pa);
		
		
		if(results[0].equals("false"))
		{
			
			request.setAttribute("result", results[0]);
			RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/LoginFail.jsp");	
			rd.forward(request,response);
		}
		else
		{
			String result = results[0];
			String username = results[1];
			System.out.println(result);
			System.out.println(username);
			request.setAttribute("username", username);
			Cookie crunchifyCookie = new Cookie("userid", result);
            crunchifyCookie.setMaxAge(60 * 60);
            response.addCookie(crunchifyCookie);           			
		    RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Loginwelcome.jsp");	
			rd.forward(request,response);
		}
		
	}

}
