package org.belchan.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the events database table.
 * 
 */
@Entity
@Table(name="events")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	//TODO review this entity
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int at;

	private String name;

	public Event() {
	}

	public int getAt() {
		return this.at;
	}

	public void setAt(int at) {
		this.at = at;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}