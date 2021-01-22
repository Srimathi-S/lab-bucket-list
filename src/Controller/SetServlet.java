package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.SetOperations;

@WebServlet(urlPatterns= {"/set"})

public class SetServlet extends HttpServlet {
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
		
		if(add!=null) {
			// call the add method and store the return value in a set variable
			SetOperations setOperations=new SetOperations();
			request.setAttribute("bucketList",setOperations.add(new TouristPlace(name,destination,rank)));
			request.setAttribute("message", "user added successfully");
			
		}

		if(remove!=null) {
			// call the remove method and store the return value in a set variable
			SetOperations setOperations=new SetOperations();
			request.setAttribute("bucketList", setOperations.remove());
			
		}

		
		if(sortbydestination!=null) {
			// call the sortByDestination method and store the return value in a set variable
			SetOperations setOperations=new SetOperations();
			request.setAttribute("bucketList", setOperations.sortByDestination());
			
		}

		if(sortbyrank!=null) {
			// call the sortByRank method and store the return value in a set variable
			SetOperations setOperations=new SetOperations();
			request.setAttribute("bucketList", setOperations.sortByRank());
			
		}

		if(reset!=null) {
			// call the reset method and store the return value in a set variable
			SetOperations setOperations=new SetOperations();
			request.setAttribute("bucketList", setOperations.reset());
			
		}
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/set.jsp");
		rd.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}



}
