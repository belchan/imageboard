package org.belchan.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bannedhashes database table.
 * 
 */
@Entity
@Table(name="bannedhashes")
@NamedQuery(name="Bannedhashe.findAll", query="SELECT b FROM Bannedhashe b")
public class Bannedhashe implements Serializable {
	private static final long serialVersionUID = 1L;

	private int bantime;

	@Lob
	private String description;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String md5;

	public Bannedhashe() {
	}

	public int getBantime() {
		return this.bantime;
	}

	public void setBantime(int bantime) {
		this.bantime = bantime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMd5() {
		return this.md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}