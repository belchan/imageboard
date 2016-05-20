package org.belchan.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ads database table.
 * 
 */
@Entity
@Table(name="ads")
@NamedQuery(name="Ad.findAll", query="SELECT a FROM Ad a")
public class Ad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String boards;

	@Lob
	private String code;

	private byte disp;

	private String position;

	public Ad() {
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte getDisp() {
		return this.disp;
	}

	public void setDisp(byte disp) {
		this.disp = disp;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}