package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="soccer_teams")
public class SoccerTeam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="NICKNAME")
	private String nickname;
	
	@Column(name="NUM_OF_PLAYERS")
	private int numOfPlayers;
	
	public SoccerTeam() {
		super();
	}
	
	public SoccerTeam(String city, String nickname, int numOfPlayers) {
		super();
		this.city = city;
		this.nickname = nickname;
		this.numOfPlayers = numOfPlayers;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	public String returnSoccerTeamDetails() {
		return city + ":" + nickname + ":" + numOfPlayers;
	}
	
}
