package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the embeds database table.
 * 
 */
@Entity
@Table(name="embeds")
@NamedQuery(name="Embed.findAll", query="SELECT e FROM Embed e")
public class Embed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private byte id;

	@Lob
	private String code;

	private String filetype;

	private byte height;

	private String name;

	private String videourl;

	private byte width;

	public Embed() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte getHeight() {
		return this.height;
	}

	public void setHeight(byte height) {
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVideourl() {
		return this.videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	public byte getWidth() {
		return this.width;
	}

	public void setWidth(byte width) {
		this.width = width;
	}

}