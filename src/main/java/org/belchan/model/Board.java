package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the boards database table.
 * 
 */
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

	public Board() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnonymous() {
		return this.anonymous;
	}

	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}

	public byte getCompactlist() {
		return this.compactlist;
	}

	public void setCompactlist(byte compactlist) {
		this.compactlist = compactlist;
	}

	public int getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(int createdon) {
		this.createdon = createdon;
	}

	public String getDefaultstyle() {
		return this.defaultstyle;
	}

	public void setDefaultstyle(String defaultstyle) {
		this.defaultstyle = defaultstyle;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEmbedsAllowed() {
		return this.embedsAllowed;
	}

	public void setEmbedsAllowed(String embedsAllowed) {
		this.embedsAllowed = embedsAllowed;
	}

	public byte getEnablearchiving() {
		return this.enablearchiving;
	}

	public void setEnablearchiving(byte enablearchiving) {
		this.enablearchiving = enablearchiving;
	}

	public byte getEnablecaptcha() {
		return this.enablecaptcha;
	}

	public void setEnablecaptcha(byte enablecaptcha) {
		this.enablecaptcha = enablecaptcha;
	}

	public byte getEnablecatalog() {
		return this.enablecatalog;
	}

	public void setEnablecatalog(byte enablecatalog) {
		this.enablecatalog = enablecatalog;
	}

	public byte getEnablenofile() {
		return this.enablenofile;
	}

	public void setEnablenofile(byte enablenofile) {
		this.enablenofile = enablenofile;
	}

	public byte getEnablereporting() {
		return this.enablereporting;
	}

	public void setEnablereporting(byte enablereporting) {
		this.enablereporting = enablereporting;
	}

	public byte getForcedanon() {
		return this.forcedanon;
	}

	public void setForcedanon(byte forcedanon) {
		this.forcedanon = forcedanon;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIncludeheader() {
		return this.includeheader;
	}

	public void setIncludeheader(String includeheader) {
		this.includeheader = includeheader;
	}

	public String getLoadbalancepassword() {
		return this.loadbalancepassword;
	}

	public void setLoadbalancepassword(String loadbalancepassword) {
		this.loadbalancepassword = loadbalancepassword;
	}

	public String getLoadbalanceurl() {
		return this.loadbalanceurl;
	}

	public void setLoadbalanceurl(String loadbalanceurl) {
		this.loadbalanceurl = loadbalanceurl;
	}

	public String getLocale() {
		return this.locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public byte getLocked() {
		return this.locked;
	}

	public void setLocked(byte locked) {
		this.locked = locked;
	}

	public byte getMarkpage() {
		return this.markpage;
	}

	public void setMarkpage(byte markpage) {
		this.markpage = markpage;
	}

	public int getMaxage() {
		return this.maxage;
	}

	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}

	public int getMaximagesize() {
		return this.maximagesize;
	}

	public void setMaximagesize(int maximagesize) {
		this.maximagesize = maximagesize;
	}

	public int getMaxpages() {
		return this.maxpages;
	}

	public void setMaxpages(int maxpages) {
		this.maxpages = maxpages;
	}

	public int getMaxreplies() {
		return this.maxreplies;
	}

	public void setMaxreplies(int maxreplies) {
		this.maxreplies = maxreplies;
	}

	public int getMessagelength() {
		return this.messagelength;
	}

	public void setMessagelength(int messagelength) {
		this.messagelength = messagelength;
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

	public byte getPopular() {
		return this.popular;
	}

	public void setPopular(byte popular) {
		this.popular = popular;
	}

	public byte getRedirecttothread() {
		return this.redirecttothread;
	}

	public void setRedirecttothread(byte redirecttothread) {
		this.redirecttothread = redirecttothread;
	}

	public byte getSection() {
		return this.section;
	}

	public void setSection(byte section) {
		this.section = section;
	}

	public byte getShowid() {
		return this.showid;
	}

	public void setShowid(byte showid) {
		this.showid = showid;
	}

	public int getStart() {
		return this.start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public byte getTrial() {
		return this.trial;
	}

	public void setTrial(byte trial) {
		this.trial = trial;
	}

	public byte getType() {
		return this.type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public byte getUploadtype() {
		return this.uploadtype;
	}

	public void setUploadtype(byte uploadtype) {
		this.uploadtype = uploadtype;
	}

}