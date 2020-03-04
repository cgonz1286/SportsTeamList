package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy="team", orphanRemoval=true, cascade={CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private List<SoccerPlayer> players;
	
	public SoccerTeam() {
		super();
	}
	
	public SoccerTeam(String city, String nickname, int numOfPlayers) {
		super();
		this.city = city;
		this.nickname = nickname;
		this.numOfPlayers = numOfPlayers;
	}
	
	public SoccerTeam(int id, String city, String nickname, int numOfPlayers) {
		super();
		this.id = id;
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
	
    public List<SoccerPlayer> getPlayers() {
        return players;
    }
    
    public void addPlayer(SoccerPlayer player) {
        players.add(player);
        player.setTeam(this);
    }
	
	public String returnSoccerTeamDetails() {
		return city + ":" + nickname + ":" + numOfPlayers;
	}
	
	@Override
	public String toString() {
		return "SoccerTeam [id=" + id + ", city=" + city + ", nickname=" + nickname + 
			   ", numOfPlayers=" + numOfPlayers + ", players=" + players + "]";
	}
	
}
