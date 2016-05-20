package org.belchan.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the modlog database table.
 * 
 */
@Entity
@Table(name="modlog")
@NamedQuery(name="Modlog.findAll", query="SELECT m FROM Modlog m")
public class Modlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte category;

	@Lob
	private String entry;

	private int timestamp;

	private String user;

	public Modlog() {
	}

	public byte getCategory() {
		return this.category;
	}

	public void setCategory(byte category) {
		this.category = category;
	}

	public String getEntry() {
		return this.entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public int getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}