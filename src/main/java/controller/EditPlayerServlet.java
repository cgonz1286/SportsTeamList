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
 * Servlet implementation class EditPlayerServlet
 */
@WebServlet("/editPlayerServlet")
public class EditPlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPlayerServlet() {
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

		SoccerPlayerDAO playerDAO = new SoccerPlayerDAO();
		SoccerTeamDAO teamDAO = new SoccerTeamDAO();
		
		String playerName = request.getParameter("playerName");
		int playerNumber = Integer.parseInt(request.getParameter("playerNumber"));
		int teamId = Integer.parseInt(request.getParameter("teamId"));
		SoccerTeam team = teamDAO.searchForTeamById(teamId);
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		SoccerPlayer playerToUpdate = playerDAO.searchForPlayerById(tempId);
		playerToUpdate.setPlayerName(playerName);
		playerToUpdate.setPlayerNumber(playerNumber);
		playerToUpdate.setTeam(team);
		playerDAO.updatePlayer(playerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPlayersServlet").forward(request, response);
	}

}
