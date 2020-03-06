import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.SoccerPlayerDAO;
import controller.SoccerTeamDAO;
import model.SoccerPlayer;
import model.SoccerTeam;

public class SportsTeamTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SoccerTeamDAO teamDAO = new SoccerTeamDAO();
		SoccerPlayerDAO playerDAO = new SoccerPlayerDAO();
		
//		SoccerPlayer chris = new SoccerPlayer("Chris", 22, teamDAO.searchForTeamById(17));
//		SoccerPlayer ben = new SoccerPlayer("Ben", 21, teamDAO.searchForTeamById(17));
//		SoccerPlayer luke = new SoccerPlayer("Luke", 20, teamDAO.searchForTeamById(17));
//		SoccerPlayer sam = new SoccerPlayer("Sam", 19, teamDAO.searchForTeamById(7));
//		SoccerPlayer abbie = new SoccerPlayer("Abbie", 18, teamDAO.searchForTeamById(8));

//		playerDAO.insertPlayer(chris);
//		playerDAO.insertPlayer(ben);
//		playerDAO.insertPlayer(luke);
//		playerDAO.insertPlayer(sam);
//		playerDAO.insertPlayer(abbie);
		
//		List<SoccerPlayer> allPlayers = playerDAO.showAllPlayers();
//		for (SoccerPlayer p : allPlayers) {
//			System.out.println(p.toString());
//		}
		
		SoccerPlayer player = playerDAO.searchForPlayerById(36);
		player.setPlayerName("Luke Gonzalez");
		player.setPlayerNumber(1);
		player.setTeam(player.getTeam());
		
		playerDAO.updatePlayer(player);
//		playerDAO.deletePlayer(player);
		
//		SoccerTeam existingTeam = teamDAO.searchForTeamById(7);
		
//		SoccerPlayer newPlayer = new SoccerPlayer("Abbie", 18, existingTeam);
//		existingTeam.addPlayer(newPlayer);
//	    teamDAO.updateTeam(existingTeam);
		
//		SoccerTeam newTeam = new SoccerTeam("Chelsea", "The Blues", 25);		
//		teamDAO.insertTeam(newTeam);
//		
//		System.out.println(existingTeam.toString());
		
//		teamDAO.deleteTeam(existingTeam);		

	}

}
