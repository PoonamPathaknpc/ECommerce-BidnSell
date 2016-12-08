package com.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.CheckoutREST;
import com.rest.SearchREST;

/**
 * Servlet implementation class Checkoutserv
 */
@WebServlet("/Checkoutserv")
public class Checkoutserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkoutserv() {
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
		
		String result=new CheckoutREST().getCheckout(userId);
		if(result.equals("ERROR")){
			RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/Errorpage.jsp");	
			rd.forward(request,response);
			
		}
		
	    else{
	    	    	
	    	String status = "Congratualtions! Your order is Placed and a notification mail is sent to your id.";
	    	// sending an email address...
	    	request.setAttribute("status", status);
	    	String usermail=request.getParameter("usermail");
	    	final String fromEmail = "amardaniel100@gmail.com";
			final String password = "chandanavarada";
			final String toEmail = usermail;
			final String toEmail1 = "chandanavarada9@gmail.com";
			String subject = "Item sold";
			String body = "Hello, This order is placed";
			String body1 = "Hello, This order is placed";
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			sendEmail(session, toEmail, fromEmail, subject, body);
			session = Session.getInstance(props, auth);
			sendEmail(session, toEmail1, fromEmail, subject, body1);
	    	System.out.println(status);
	    	System.out.println("intrue");
		    RequestDispatcher rd=(RequestDispatcher) getServletContext().getRequestDispatcher("/CartadditionSuccess.jsp");	
		    rd.forward(request,response);
	        }
	}
	public static void sendEmail(Session session, String toEmail, String fromEmail, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);

			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress(fromEmail, "No Reply - WPL Project"));
			msg.setReplyTo(InternetAddress.parse(fromEmail, false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setSentDate(new Date());
			System.out.println("toEmail");
			System.out.println(toEmail);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
