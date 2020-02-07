package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.SoccerTeam;

public class SoccerTeamDAO {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SportsTeamList");
	
	public List<SoccerTeam> showAllTeams() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		
		List<SoccerTeam> allTeams = em.createQuery("SELECT teams FROM SoccerTeam teams").getResultList();
		
		return allTeams;
	}

	public void insertTeam(SoccerTeam toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(toAdd);
		em.getTransaction().commit();
		
		em.close();
	}

	public String deleteTeam(SoccerTeam toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		//Write query to retrieve team to delete
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select team from SoccerTeam team where team.city = :selectedCity and team.nickname = :selectedNickname " + 
														   "and team.numOfPlayers = :selectedNumOfPlayers", SoccerTeam.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedNickname", toDelete.getNickname());
		typedQuery.setParameter("selectedNumOfPlayers", toDelete.getNumOfPlayers());
		
		//We only want one result
		typedQuery.setMaxResults(1);
		
		String message = "";
		
		//Get the result and save it into a new list item
		try {
			SoccerTeam result = typedQuery.getSingleResult();
			
			//If exists, Remove it
			em.remove(result);
			em.getTransaction().commit();
			
			message = "Team was deleted successfully!";
		} 
		catch(NoResultException e) {
			message = "Team was not deleted, because the entered team does not exist.";
		}
		
		em.close();
		
		return message;
	}

	public List<SoccerTeam> searchForTeamByCity(String city) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select team from SoccerTeam team where team.city = :selectedCity", SoccerTeam.class);
		typedQuery.setParameter("selectedCity", city);
		List<SoccerTeam> foundItems = typedQuery.getResultList();
		
		em.close();
		
		return foundItems;
	}

	public List<SoccerTeam> searchForTeamByNickname(String nickname) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select team from SoccerTeam team where team.nickname = :selectedNickname", SoccerTeam.class);
		typedQuery.setParameter("selectedNickname", nickname);
		List<SoccerTeam> foundItems = typedQuery.getResultList();
		
		em.close();
		
		return foundItems;
	}

	public List<SoccerTeam> searchForTeamByNumOfPlayers(int numOfPlayers) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<SoccerTeam> typedQuery = em.createQuery("select team from SoccerTeam team where team.numOfPlayers = :selectedNumOfPlayers", SoccerTeam.class);
		typedQuery.setParameter("selectedNumOfPlayers", numOfPlayers);
		List<SoccerTeam> foundItems = typedQuery.getResultList();
		
		em.close();
		
		return foundItems;
	}

	public SoccerTeam searchForTeamById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		SoccerTeam found = em.find(SoccerTeam.class, idToEdit);
		
		em.close();
		
		return found;
	}

	public void updateTeam(SoccerTeam toEdit) {
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
