package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the loginattempts database table.
 * 
 */
@Entity
@Table(name="loginattempts")
@NamedQuery(name="Loginattempt.findAll", query="SELECT l FROM Loginattempt l")
public class Loginattempt implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ip;

	//TODO review This entity
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int timestamp;

	private String username;

	public Loginattempt() {
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}