package org.belchan.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity
@Table(name="boards")
@NamedQuery(name="Board.findAll", query="SELECT b FROM Board b")
public class Board implements Serializable {
	private static final long serialVersionUID = 1L;
	public final static String COL_NAME = "name";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String anonymous;

	private byte compactlist;

	private int createdon;

	private String defaultstyle;

	private String desc;

	@Column(name="embeds_allowed")
	private String embedsAllowed;

	private byte enablearchiving;

	private byte enablecaptcha;

	private byte enablecatalog;

	private byte enablenofile;

	private byte enablereporting;

	private byte forcedanon;

	private String image;

	@Lob
	private String includeheader;

	private String loadbalancepassword;

	private String loadbalanceurl;

	private String locale;

	private byte locked;

	private byte markpage;

	private int maxage;

	private int maximagesize;

	private int maxpages;

	private int maxreplies;

	private int messagelength;

	private String name;

	private byte order;

	private byte popular;

	private byte redirecttothread;

	private byte section;

	private byte showid;

	private int start;

	private byte trial;

	private byte type;

	private byte uploadtype;
}