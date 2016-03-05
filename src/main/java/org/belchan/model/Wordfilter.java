package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wordfilter database table.
 * 
 */
@Entity
@Table(name="wordfilter")
@NamedQuery(name="Wordfilter.findAll", query="SELECT w FROM Wordfilter w")
public class Wordfilter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String boards;

	private byte regex;

	private String replacedby;

	private int time;

	private String word;

	public Wordfilter() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBoards() {
		return this.boards;
	}

	public void setBoards(String boards) {
		this.boards = boards;
	}

	public byte getRegex() {
		return this.regex;
	}

	public void setRegex(byte regex) {
		this.regex = regex;
	}

	public String getReplacedby() {
		return this.replacedby;
	}

	public void setReplacedby(String replacedby) {
		this.replacedby = replacedby;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}