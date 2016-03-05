package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the blotter database table.
 * 
 */
@Entity
@Table(name="blotter")
@NamedQuery(name="Blotter.findAll", query="SELECT b FROM Blotter b")
public class Blotter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int at;

	private byte important;

	@Lob
	private String message;

	public Blotter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAt() {
		return this.at;
	}

	public void setAt(int at) {
		this.at = at;
	}

	public byte getImportant() {
		return this.important;
	}

	public void setImportant(byte important) {
		this.important = important;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}