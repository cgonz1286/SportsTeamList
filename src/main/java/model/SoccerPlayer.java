package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="soccer_players")
public class SoccerPlayer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PLAYER_ID")
	private int playerId;
	
	@Column(name="PLAYER_NAME")
	private String playerName;
	
	@Column(name="PLAYER_NUMBER")
	private int playerNumber;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="TEAM_ID")
	private SoccerTeam team;
	
	public SoccerPlayer() {
		super();
	}
	
	public SoccerPlayer(String playerName, int playerNumber, SoccerTeam team) {
		super();
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.team = team;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public SoccerTeam getTeam() {
		return team;
	}

	public void setTeam(SoccerTeam team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "SoccerPlayer [playerId=" + playerId + ", playerName=" + playerName + ", playerNumber=" + playerNumber + 
			   ", teamId=" + team.getId() + "]";
	}
	
}
