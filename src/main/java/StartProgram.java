import java.util.List;
import java.util.Scanner;

import controller.SoccerTeamDAO;
import model.SoccerTeam;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static SoccerTeamDAO soccerTeamDAO = new SoccerTeamDAO();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}
	
	public static void runMenu() {
		boolean showMenu = true;
		System.out.println("--- Welcome to the best list of sports teams in the world! ---");
		
		while (showMenu) {
			System.out.println();
			System.out.println("*******************************");
			System.out.println("*  1 -- Add a new team        *");
			System.out.println("*  2 -- Edit an existing team *");
			System.out.println("*  3 -- Delete a team         *");
			System.out.println("*  4 -- View the entire list  *");
			System.out.println("*  5 -- EXIT                  *");
			System.out.println("*******************************");
			System.out.print("*  Select an option (1-5): ");
			int selection = in.nextInt();
			in.nextLine();
			System.out.println();

			if (selection == 1) {
				addATeam();
			} else if (selection == 2) {
				editATeam();
			} else if (selection == 3) {
				deleteATeam();
			} else if (selection == 4) {
				viewTheList();
			} else {
				soccerTeamDAO.cleanUp();
				System.out.println();
				System.out.println("--- Goodbye! ---");
				showMenu = false;
			}
		}
	}
	
	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<SoccerTeam> allTeams = soccerTeamDAO.showAllTeams();
		
		for(SoccerTeam singleTeam : allTeams) {
			System.out.println(singleTeam.returnSoccerTeamDetails());
		}
	}

	private static void addATeam() {
		// TODO Auto-generated method stub
		System.out.print("Enter a city: ");
		String city = in.nextLine();
		System.out.print("Enter a team nickname: ");
		String nickname = in.nextLine();
		System.out.print("Enter the number of players: ");
		int numOfPlayers = in.nextInt();
		
		SoccerTeam toAdd = new SoccerTeam(city, nickname, numOfPlayers);
		
		soccerTeamDAO.insertTeam(toAdd);
	}

	private static void deleteATeam() {
		// TODO Auto-generated method stub
		System.out.print("Enter the city to delete: ");
		String city = in.nextLine();
		System.out.print("Enter the team nickname to delete: ");
		String nickname = in.nextLine();
		System.out.print("Enter the number of players to delete: ");
		int numOfPlayers = in.nextInt();
		
		SoccerTeam toDelete = new SoccerTeam(city, nickname, numOfPlayers);
		
		String message = soccerTeamDAO.deleteTeam(toDelete);
		
		System.out.println();
		System.out.println(message);
	}

	private static void editATeam() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by City");
		System.out.println("2 : Search by Nickname");
		System.out.println("3 : Search by Number of Players");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<SoccerTeam> foundTeams;
		if (searchBy == 1) {
			System.out.print("Enter the city: ");
			String city = in.nextLine();
			foundTeams = soccerTeamDAO.searchForTeamByCity(city);
		} else if (searchBy == 2) {
			System.out.print("Enter the team nickname: ");
			String nickname = in.nextLine();
			foundTeams = soccerTeamDAO.searchForTeamByNickname(nickname);
		} else {
			System.out.print("Enter the number of players: ");
			int numOfPlayers = in.nextInt();
			foundTeams = soccerTeamDAO.searchForTeamByNumOfPlayers(numOfPlayers);
		}
		
		System.out.println();

		if (!foundTeams.isEmpty()) {
			System.out.println("Found Results.");
			for (SoccerTeam team : foundTeams) {
				System.out.println(team.getId() + " : " + team.returnSoccerTeamDetails());
			}
			System.out.println();
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			SoccerTeam toEdit = soccerTeamDAO.searchForTeamById(idToEdit);
			System.out.println();
			System.out.println("Retrieved " + toEdit.returnSoccerTeamDetails());
			System.out.println("What would you like to update?");
			System.out.println("1 : Update City");
			System.out.println("2 : Update Nickname");
			System.out.println("3 : Update Number of Players");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New City: ");
				String newStore = in.nextLine();
				toEdit.setCity(newStore);
			} else if (update == 2) {
				System.out.print("New Nickname: ");
				String newItem = in.nextLine();
				toEdit.setNickname(newItem);
			} else {
				System.out.println("New Number of Players: ");
				int newNumOfPlayers = in.nextInt();
				toEdit.setNumOfPlayers(newNumOfPlayers);
			}

			soccerTeamDAO.updateTeam(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

}
