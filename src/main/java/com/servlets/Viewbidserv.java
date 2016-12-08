package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ViewbidREST;
import com.servlets.Bean.SearchIteam;

/**
 * Servlet implementation class Viewbidserv
 */
public class Viewbidserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewbidserv() {
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
		System.out.println(userId);
		String result=new ViewbidREST().getItems(userId);
		
        int count=0;

    List<SearchIteam> searchitems= new ArrayList<SearchIteam>();
    if(result.equals("FALSE"))
    {
	request.setAttribute("status", "false");	
    }
    else
    {
	System.out.println(result);	
    for (String items: result.split(";")){
	System.out.println(items);
	SearchIteam sitem = new SearchIteam();
    for (String item: items.split("=")) {
	String[] temp = item.split(":");
	System.out.println(item);
	
	if(!temp[1].equals(null))
	   {
	
		System.out.println(temp[0]);
		if(temp[0].equals("itemId"))
		{
			sitem.setitemid(temp[1]);
            
		}
		
		else if(temp[0].equals("name"))
		{
			sitem.setname(temp[1]);
            	
		}
		else if (temp[0].equals("desc"))
		{
			sitem.setdesc(temp[1]);
             
			
		}
		else if(temp[0].equals("quantity"))
		{
			sitem.setquantity(temp[1]);
            
		}
		
		
	    }
	else
	   {
		break;
        }
       
      count++;
     }
    searchitems.add(sitem);
    
    }
    request.setAttribute("status", "true");
    }
    
       
		//System.out.println(count);
		request.setAttribute("count", count);
		request.setAttribute("userId", userId);
		request.setAttribute("SearchIteam", searchitems);	
		
		RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Viewbid.jsp");	
		rd.forward(request,response);
		
	}
	}
