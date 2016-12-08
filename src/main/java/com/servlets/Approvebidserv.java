package com.servlets;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.ApprovebidsREST;
import com.servlets.Bean.SearchIteam;

/**
 * Servlet implementation class Approvebidserv
 */
public class Approvebidserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approvebidserv() {
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
		System.out.println(itemId + ":: " +  userId ); 
		String name=request.getParameter("name");
		String result=new ApprovebidsREST().Fetchbids(userId,itemId);
		if(result.equals("ERROR")){
			RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Errorpage.jsp");	
			rd.forward(request,response);
			
		}
		
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
System.out.println(temp[0]);
if(!temp[1].equals(null))
   {
	
	if(temp[0].equals("Bidid"))
	{
		sitem.setitemid(temp[1]);
        
		
	}
	else if (temp[0].equals("Bidder_NAME"))
	{
		sitem.setname(temp[1]);
        
	}
	
	else if (temp[0].equals("Bid"))
	{
		sitem.setquantity(temp[1]);
        
	}
	
	
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
	
		RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Approvebids.jsp");	
		rd.forward(request,response);
	}

}
