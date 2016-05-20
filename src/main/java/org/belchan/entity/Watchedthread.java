package org.belchan.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the watchedthreads database table.
 * 
 */
@Entity
@Table(name="watchedthreads")
@NamedQuery(name="Watchedthread.findAll", query="SELECT w FROM Watchedthread w")
public class Watchedthread implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String board;

	private String ip;

	private int lastsawreplyid;

	private int threadid;

	public Watchedthread() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBoard() {
		return this.board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getLastsawreplyid() {
		return this.lastsawreplyid;
	}

	public void setLastsawreplyid(int lastsawreplyid) {
		this.lastsawreplyid = lastsawreplyid;
	}

	public int getThreadid() {
		return this.threadid;
	}

	public void setThreadid(int threadid) {
		this.threadid = threadid;
	}

}