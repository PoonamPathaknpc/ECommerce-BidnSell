package com.servlets;

import com.google.gson.Gson;
import com.rest.LoginREST;
import com.rest.SignREST;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Loginserv
 */
public class Signupserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupserv() {
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
		String fn=request.getParameter("fname");
		String ln=request.getParameter("lname");
		String em=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String faddr=request.getParameter("faddr");
		String city=request.getParameter("city");
		String States = request.getParameter("state");
		String ZP = request.getParameter("zip");
		String Phn = request.getParameter("phn");
		
		System.out.println(em+pwd+fn+ln+Phn+faddr+city+States+ZP);
				
       String[] results=new SignREST().Signupmethod(em,pwd,fn,ln,Phn,faddr,city,States,ZP);
		
		if(results[0].equals("false"))
		{
			request.setAttribute("result", results[0]);
			RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Login.jsp");	
			rd.forward(request,response);
		}
		else
		{
			System.out.println("here");
			String result = results[0];
			String username = results[1];
			request.setAttribute("username", username);
			Cookie crunchifyCookie = new Cookie("userid", result);
            crunchifyCookie.setMaxAge(60 * 60);
            response.addCookie(crunchifyCookie);           			
		    RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Login.jsp");	
			rd.forward(request,response);
		}
	}

}
