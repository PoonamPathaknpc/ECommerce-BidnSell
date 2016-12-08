package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.CartREST;

/**
 * Servlet implementation class Cartserv
 */
public class Cartserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartserv() {
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
		String sellerId=request.getParameter("sellerId");
		String price=request.getParameter("price");
		String quantity=request.getParameter("quantity");
		String itemId=request.getParameter("itemId");
		String result=new CartREST().cartAdd(userId,price,quantity,itemId);
		System.out.println(result);
		if(result.equals("ERROR")){
			RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Errorpage.jsp");	
			rd.forward(request,response);
			
		}
    if(result.equals("FALSE")){
    	String status = "Sorry!Item out odf stock.";
    	System.out.println(status);
    	System.out.println("infalse");
    	request.setAttribute("status", status);
    	RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/CartadditionSuccess.jsp");	
    	rd.forward(request,response);
    }
    else{
    	    	
    	String status = "Item is added successfully to the cart";
    	request.setAttribute("status", status);
    	System.out.println(status);
    	System.out.println("intrue");
	    RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/CartadditionSuccess.jsp");	
	    rd.forward(request,response);
        }
    
    
	}

}
