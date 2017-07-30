package org.belchan.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;


@Data
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

}