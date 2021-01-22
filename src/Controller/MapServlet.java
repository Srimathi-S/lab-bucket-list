package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.MapOperations;


@WebServlet(urlPatterns= {"/map"})
public class MapServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		
		String sortRandom = request.getParameter("sortrandomly");
		String sortInEntryOrder = request.getParameter("sortinentryorder");
		String sortAlphabetically = request.getParameter("sortalphabetically");
		String remove = request.getParameter("remove");
		String reset = request.getParameter("reset");
			
		if(add!=null) {
			// call the add method and store the return value in a map variable
			MapOperations mapOperations=new MapOperations();
			request.setAttribute("bucketList", mapOperations.add(new TouristPlace(name,destination,rank)));
			request.setAttribute("message", "user added successfully");
			
		}

		if(remove!=null) {
			// call the remove method and store the return value in a map variable
			MapOperations mapOperations=new MapOperations();
			request.setAttribute("bucketList", mapOperations.remove());
			
		}

		
		if(sortRandom!=null) {
			MapOperations mapOperations=new MapOperations();
			request.setAttribute("bucketList", mapOperations.sortRandomly());
			
		}

		if(sortInEntryOrder!=null) {
			MapOperations mapOperations=new MapOperations();
			request.setAttribute("bucketList", mapOperations.sortInEntryOrder());
			
		}
		if(sortAlphabetically!=null) {
			
			// call the sort Alphabetically and store the return value in a map variable
			MapOperations mapOperations=new MapOperations();
			request.setAttribute("bucketList", mapOperations.sortAlphabetically());
			
		}

		if(reset!=null) {	
			// call the reset method and store the return value in a map variable
			MapOperations mapOperations=new MapOperations();
			request.setAttribute("bucketList", mapOperations.reset());
			
		}
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

