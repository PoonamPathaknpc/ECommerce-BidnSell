package com.servlets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ProfileREST;

import net.spy.memcached.MemcachedClient;

/**
 * Servlet implementation class Profileserv
 */
public class Profileserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profileserv() {
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
		
		try {
			MemcachedClient c = new MemcachedClient(new InetSocketAddress("localhost",11211));
			String str = "";
			System.out.println(userId);
			String result = null;
			if(c.get(userId)==null)
			{
				result =new ProfileREST().Fetch(userId);
				if(result.equals("ERROR")){
					RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Errorpage.jsp");	
					rd.forward(request,response);
					
				}
				c.set(userId, 7300, result).get();
				System.out.println("It is a miss in memcache.");
			}
			else
			{
				str = (String)c.get(userId);
				System.out.println("It is a hit in memcache. The value fetched is: " + str);
				result = str;
			}
			
			
			//String result= "fname:chandana=lname:varada=email:hai@hu.com=caddr:gyh 2 huj=phone:1234=date:12-13-29=time:12:30=location:texas";
		       int count=0;
				
				for (String item: result.split("=")) {
					String[] temp = item.split(":");
					count++;
					if(!temp.equals(null))
					{
						System.out.println(temp[0] + ":::" + temp[1]);
						request.setAttribute(temp[0], temp[1]);
					}
					else 
						break;
					
			      }
				count=count/10;
				
				request.setAttribute("count", count);
				request.setAttribute("userId", userId);
				RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Profiledetails.jsp");	
				rd.forward(request,response);
				
				
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
		

}
