package com.servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.SearchREST;

/**
 * Servlet implementation class Searchserv
 */
public class Searchserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchserv() {
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
		String search=request.getParameter("search");
		String result=new SearchREST().search(search,userId);
		if(result.equals("ERROR")){
			RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Errorpage.jsp");	
			rd.forward(request,response);
			
		}
		//String result="name:Iphone6s=itemId:3=dept:mobiles=pop:2=desc:Testing=gender:male=used:old=name:Iphone5s=itemId:3=dept:tablet=pop:1=desc:mobile=gender:female=used:new";
		System.out.println(result);
		System.out.println("result from search serv");
		result=result.substring(1);
		int count=0;
		int i=0;
		
		for (String item: result.split("=")) {
			String[] temp = item.split(":");
			count++;
			if(count%7==1)
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
		count=count/7;
		
		
		//System.out.println(count);
		request.setAttribute("count", count);
		request.setAttribute("userId", userId);
		
		RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/SearchLogin.jsp");	
		rd.forward(request,response);
		
		
		
	}

}
