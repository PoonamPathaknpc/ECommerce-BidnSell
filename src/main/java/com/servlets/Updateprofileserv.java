package com.servlets;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ProfileREST;
import com.rest.UpdateprofileREST;

import net.spy.memcached.MemcachedClient;

/**
 * Servlet implementation class Updateprofileserv
 */
public class Updateprofileserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateprofileserv() {
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
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String faddr=request.getParameter("faddr");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		new UpdateprofileREST().Update(userId, fname, lname, faddr, phone, zip, city, state);	
		
		MemcachedClient c = new MemcachedClient(new InetSocketAddress("localhost",11211));
		String result =new ProfileREST().Fetch(userId);
		System.out.println(result);
		c.delete(userId);
		c.set(userId, 7200, result);
		
		
		
		request.setAttribute("userId", userId);
		RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Updatesuccess.jsp");	
		rd.forward(request,response);
		
	}

}
