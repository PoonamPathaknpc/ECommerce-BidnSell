package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.CartremoveREST;
import com.servlets.Bean.Cart;

/**
 * Servlet implementation class Cartremoveserv
 */
public class Cartremoveserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cartremoveserv() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int count = 0;
		int i=0;
        String status = "true";
		String userId = request.getParameter("userId");
		String itemId = request.getParameter("itemId");
		System.out.println("the user id is " + userId);
		System.out.println("the user id is " + itemId);
		String result = new CartremoveREST().removeCart(userId, itemId);

		if(result.equals("ERROR")){
			RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Errorpage.jsp");	
			rd.forward(request,response);
			
		}
		else if (result.equals("FALSE"))
		{
			status = "false";
			
		}
		
		else{
		
			result=result.substring(1);
			
			for (String item: result.split("=")) {
				String[] temp = item.split(":");
				count++;
				if(count%5==1)
					i++;
				if(!temp.equals(null))
					{//System.out.println(temp[0]);
				//System.out.println(temp[1]);
					String temp1=temp[0]+Integer.toString(i);
					request.setAttribute(temp1, temp[1]);
					
					}
				else 
					break;
				
		      }
			count=count/5;
			
			    }
			
		    request.setAttribute("status", status);	
            request.setAttribute("userId", userId);
			request.setAttribute("count", count);
			RequestDispatcher rd = (RequestDispatcher) getServletContext().getRequestDispatcher("/Cart.jsp");
			rd.forward(request, response);
		}
	}   

