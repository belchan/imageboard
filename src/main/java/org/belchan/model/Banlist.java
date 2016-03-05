package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the banlist database table.
 * 
 */
@Entity
@Table(name="banlist")
@NamedQuery(name="Banlist.findAll", query="SELECT b FROM Banlist b")
public class Banlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte allowread;

	@Lob
	private String appeal;

	private int appealat;

	private int at;

	private String boards;

	private String by;

	private byte expired;

	private byte globalban;

	private String ip;

	private String ipmd5;

	@Lob
	private String reason;

	@Lob
	private String staffnote;

	private byte type;

	private int until;

	public Banlist() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAllowread() {
		return this.allowread;
	}

	public void setAllowread(byte allowread) {
		this.allowread = allowread;
	}

	public String getAppeal() {
		return this.appeal;
	}

	public void setAppeal(String appeal) {
		this.appeal = appeal;
	}

	public int getAppealat() {
		return this.appealat;
	}

	public void setAppealat(int appealat) {
		this.appealat = appealat;
	}

	public int getAt() {
		return this.at;
	}

	public void setAt(int at) {
		this.at = at;
	}

	public String getBoards() {
		return this.boards;
	}

	public void setBoards(String boards) {
		this.boards = boards;
	}

	public String getBy() {
		return this.by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public byte getExpired() {
		return this.expired;
	}

	public void setExpired(byte expired) {
		this.expired = expired;
	}

	public byte getGlobalban() {
		return this.globalban;
	}

	public void setGlobalban(byte globalban) {
		this.globalban = globalban;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpmd5() {
		return this.ipmd5;
	}

	public void setIpmd5(String ipmd5) {
		this.ipmd5 = ipmd5;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStaffnote() {
		return this.staffnote;
	}

	public void setStaffnote(String staffnote) {
		this.staffnote = staffnote;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public int getUntil() {
		return this.until;
	}

	public void setUntil(int until) {
		this.until = until;
	}

}