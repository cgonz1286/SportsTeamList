package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SoccerTeam;

/**
 * Servlet implementation class AddTeamServlet
 */
@WebServlet("/addTeamServlet")
public class AddTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String city = request.getParameter("city");
		String nickname = request.getParameter("nickname");
		int numOfPlayers = Integer.parseInt(request.getParameter("numOfPlayers"));
		
		SoccerTeam newTeam = new SoccerTeam(city, nickname, numOfPlayers);
		SoccerTeamDAO dao = new SoccerTeamDAO();
		dao.insertTeam(newTeam);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
