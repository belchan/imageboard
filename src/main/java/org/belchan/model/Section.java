package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sections database table.
 * 
 */
@Entity
@Table(name="sections")
@NamedQuery(name="Section.findAll", query="SELECT s FROM Section s")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String abbreviation;

	private byte hidden;

	private String name;

	private byte order;

	public Section() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public byte getHidden() {
		return this.hidden;
	}

	public void setHidden(byte hidden) {
		this.hidden = hidden;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getOrder() {
		return this.order;
	}

	public void setOrder(byte order) {
		this.order = order;
	}

}