package com.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.datamanager.DataManager;
import com.model.RegistrationModal;


@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistrationModal registrationModal;
	private DataManager dataManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		registrationModal = new RegistrationModal();
		dataManager = new DataManager();
		String FirstName = request.getParameter("fname");
		//out.println("First Name is :"+FirstName);
		String LastName = request.getParameter("lname");
		//out.println("Last Name is :"+LastName);
		String email = request.getParameter("email");
		//out.println("Email is :"+email);
		String ContactNo = request.getParameter("contact");
		//out.println("Phone No is :"+ContactNo);
		String Country = request.getParameter("country");
		//out.println("Country is :"+Country);
		registrationModal.setFirstName(FirstName);
		registrationModal.setLastName(LastName);
		registrationModal.setEmail(email);
		registrationModal.setContactNo(ContactNo);
		registrationModal.setCountry(Country);
		int i = dataManager.datainsert(registrationModal);
		if(i>0)
		{
			out.println("Record inserted successfully..");
		}
		else
		{
			out.println("Record not inserted...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
