package org.belchan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the staff database table.
 * 
 */
@Entity
@Table(name="staff")
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;
	public static String COL_USER_NAME = "username";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	private int addedon;

	@Lob
	private String boards;

	@JsonIgnore
	private int lastactive;

	@JsonIgnore
	private String password;

	@JsonIgnore
	private String salt;

	private byte type;

	private String username;

	public Staff() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddedon() {
		return this.addedon;
	}

	public void setAddedon(int addedon) {
		this.addedon = addedon;
	}

	public String getBoards() {
		return this.boards;
	}

	public void setBoards(String boards) {
		this.boards = boards;
	}

	public int getLastactive() {
		return this.lastactive;
	}

	public void setLastactive(int lastactive) {
		this.lastactive = lastactive;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}