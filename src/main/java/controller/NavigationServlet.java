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
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String path = "";
		
		if(request.getParameter("doThisToTeam") != null) {
			SoccerTeamDAO dao = new SoccerTeamDAO();
			String action = request.getParameter("doThisToTeam");
			
			path = "/viewAllTeamsServlet";
			
			if (action.equals("Delete")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					SoccerTeam teamToDelete = dao.searchForTeamById(tempId);
					dao.deleteTeam(teamToDelete);
				} catch (NumberFormatException e) {
					System.out.println("Forgot to select a team");
				}	
			} else if (action.equals("Edit")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					SoccerTeam teamToEdit = dao.searchForTeamById(tempId);
					request.setAttribute("teamToEdit", teamToEdit);
					path = "/edit-team.jsp";
				} catch (NumberFormatException e) {
					System.out.println("Forgot to select a team");
				}
			} else if (action.equals("Add")) {
				path = "/index.html";
			}
		} else if(request.getParameter("doThisToPlayer") != null) {
			SoccerTeamDAO teamDAO = new SoccerTeamDAO();
			SoccerPlayerDAO playerDAO = new SoccerPlayerDAO();
			String action = request.getParameter("doThisToPlayer");
			
			path = "/viewAllPlayersServlet";
			
			if (action.equals("Delete")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					SoccerPlayer playerToDelete = playerDAO.searchForPlayerById(tempId);
					playerDAO.deletePlayer(playerToDelete);
				} catch (NumberFormatException e) {
					System.out.println("Forgot to select a player");
				}	
			} else if (action.equals("Edit")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					SoccerPlayer playerToEdit = playerDAO.searchForPlayerById(tempId);
					request.setAttribute("playerToEdit", playerToEdit);
					
					request.setAttribute("allTeams", teamDAO.showAllTeams());
					request.setAttribute("currentTeam", teamDAO.searchForTeamById(playerToEdit.getTeam().getId()));
					
					path = "/edit-player.jsp";
				} catch (NumberFormatException e) {
					System.out.println("Forgot to select a player");
				}
			} else if (action.equals("Add")) {
				request.setAttribute("allTeams", teamDAO.showAllTeams());				
				
				path = "/add-player.jsp";
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
