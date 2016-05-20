package org.belchan.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the announcements database table.
 * 
 */
@Entity
@Table(name="announcements")
@NamedQuery(name="Announcement.findAll", query="SELECT a FROM Announcement a")
public class Announcement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String message;

	private int parentid;

	private int postedat;

	private String postedby;

	private String subject;

	public Announcement() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getParentid() {
		return this.parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public int getPostedat() {
		return this.postedat;
	}

	public void setPostedat(int postedat) {
		this.postedat = postedat;
	}

	public String getPostedby() {
		return this.postedby;
	}

	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}