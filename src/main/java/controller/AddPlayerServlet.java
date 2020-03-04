package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SoccerPlayer;
import model.SoccerTeam;

/**
 * Servlet implementation class AddTeamServlet
 */
@WebServlet("/addPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SoccerTeamDAO teamDAO = new SoccerTeamDAO();
		
		request.setAttribute("allTeams", teamDAO.showAllTeams());
		
		getServletContext().getRequestDispatcher("/add-player.jsp").forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String playerName = request.getParameter("playerName");
		int playerNumber = Integer.parseInt(request.getParameter("playerNumber"));
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		SoccerTeamDAO teamDAO = new SoccerTeamDAO();
		SoccerTeam team = teamDAO.searchForTeamById(teamId);
		
		SoccerPlayer newPlayer = new SoccerPlayer(playerName, playerNumber, team);
		team.addPlayer(newPlayer);
		teamDAO.updateTeam(team);
		
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}

}
