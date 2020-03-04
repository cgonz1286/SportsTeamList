package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SoccerPlayer;

public class SoccerPlayerDAO {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebSportsTeamList");
	
	public List<SoccerPlayer> showAllPlayers() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		
		List<SoccerPlayer> allPlayers = em.createQuery("SELECT players FROM SoccerPlayer players").getResultList();
		
		return allPlayers;
	}

	public void insertPlayer(SoccerPlayer toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(toAdd);
		em.getTransaction().commit();
		
		em.close();
	}

	public String deletePlayer(SoccerPlayer toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		//Write query to retrieve team to delete
		TypedQuery<SoccerPlayer> typedQuery = em.createQuery("select player from SoccerPlayer player where player.playerName = :selectedPlayerName and player.playerNumber = :selectedPlayerNumber " + 
														     "and player.team = :selectedTeam", SoccerPlayer.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedPlayerName", toDelete.getPlayerName());
		typedQuery.setParameter("selectedPlayerNumber", toDelete.getPlayerNumber());
		typedQuery.setParameter("selectedTeam", toDelete.getTeam());
		
		//We only want one result
		typedQuery.setMaxResults(1);
		
		String message = "";
		
		//Get the result and save it into a new list item
		try {
			SoccerPlayer result = typedQuery.getSingleResult();
			
			//If exists, Remove it
			em.remove(result);
			em.getTransaction().commit();
			
			message = "Player was deleted successfully!";
		} 
		catch(NoResultException e) {
			message = "Player was not deleted, because the entered player does not exist.";
		}
		
		em.close();
		
		return message;
	}

	public List<SoccerPlayer> searchForPlayerByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<SoccerPlayer> typedQuery = em.createQuery("select player from SoccerPlayer player where player.playerName = :selectedPlayerName", SoccerPlayer.class);
		typedQuery.setParameter("selectedPlayerName", playerName);
		List<SoccerPlayer> foundItems = typedQuery.getResultList();
		
		em.close();
		
		return foundItems;
	}

	public List<SoccerPlayer> searchForPlayerByPlayerNumber(String playerNumber) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<SoccerPlayer> typedQuery = em.createQuery("select player from SoccerPlayer player where player.playerNumber = :selectedPlayerNumber", SoccerPlayer.class);
		typedQuery.setParameter("selectedPlayerNumber", playerNumber);
		List<SoccerPlayer> foundItems = typedQuery.getResultList();
		
		em.close();
		
		return foundItems;
	}

	public List<SoccerPlayer> searchForPlayerByTeam(int teamId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<SoccerPlayer> typedQuery = em.createQuery("select player from SoccerPlayer player where player.teamId = :selectedTeamId", SoccerPlayer.class);
		typedQuery.setParameter("selectedTeamId", teamId);
		List<SoccerPlayer> foundItems = typedQuery.getResultList();
		
		em.close();
		
		return foundItems;
	}

	public SoccerPlayer searchForPlayerById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		SoccerPlayer found = em.find(SoccerPlayer.class, idToEdit);
		
		em.close();
		
		return found;
	}

	public void updatePlayer(SoccerPlayer toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		
		em.close();
	}

	public void cleanUp() {
		// TODO Auto-generated method stub
		emfactory.close();
	}

}
