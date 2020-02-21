package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SoccerTeam;

/**
 * Servlet implementation class EditTeamServlet
 */
@WebServlet("/editTeamServlet")
public class EditTeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTeamServlet() {
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
		
		SoccerTeamDAO dao = new SoccerTeamDAO();
		
		String city = request.getParameter("city");
		String nickname = request.getParameter("nickname");
		int numOfPlayers = Integer.parseInt(request.getParameter("numOfPlayers"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		SoccerTeam teamToUpdate = dao.searchForTeamById(tempId);
		teamToUpdate.setCity(city);
		teamToUpdate.setNickname(nickname);
		teamToUpdate.setNumOfPlayers(numOfPlayers);
		dao.updateTeam(teamToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllTeamsServlet").forward(request, response);
	}

}
