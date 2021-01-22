package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.ListOperations;


@WebServlet(urlPatterns= {"/list"})
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		String sortbydestination = request.getParameter("sortbydestination");
		String sortbyrank = request.getParameter("sortbyrank");
		String remove = request.getParameter("remove");
		String reset = request.getParameter("reset");
		
		System.out.println("Entering into list");
	
		if(add!=null) {
			// Call the add method in list operations and store the return list in list variable
			ListOperations listOperations=new ListOperations();
			System.out.println("calling add equals method");
			TouristPlace places=new TouristPlace(name,destination,rank);
			List<Integer>touristList=listOperations.add(places);
			request.setAttribute("bucketList", touristList);
			request.setAttribute("message", "user added successfully");
			
		}

		if(remove!=null) {
			// call the remove method and store the return list in a list variable
			ListOperations listOperations=new ListOperations();
			System.out.println("calling add equals method");
			TouristPlace places=new TouristPlace(name,destination,rank);
			List<Integer>touristList=listOperations.remove();
			request.setAttribute("bucketList", touristList);
			
		}

		
		if(sortbydestination!=null) {
			// call the sortByDestination method and store the value in a list variable
			ListOperations listOperations=new ListOperations();
			List<Integer>touristList=listOperations.sortByDestination();
			request.setAttribute("bucketList", touristList);
			
		}

		if(sortbyrank!=null) {
		// call the sortByRank method and store the value in a list variable
			ListOperations listOperations=new ListOperations();
			List<Integer>touristList=listOperations.sortByRank();
			request.setAttribute("bucketList", touristList);
		}

		if(reset!=null) {	
			// call the clear method and store the value in a list variable
			ListOperations listOperations=new ListOperations();
			List<Integer>touristList=listOperations.reset();
			request.setAttribute("bucketList", touristList);
		}
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
		rd.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
