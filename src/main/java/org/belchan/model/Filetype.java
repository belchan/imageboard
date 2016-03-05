package org.belchan.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the filetypes database table.
 * 
 */
@Entity
@Table(name="filetypes")
@NamedQuery(name="Filetype.findAll", query="SELECT f FROM Filetype f")
public class Filetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String filetype;

	@Column(name="force_thumb")
	private int forceThumb;

	private String image;

	@Column(name="image_h")
	private int imageH;

	@Column(name="image_w")
	private int imageW;

	private String mime;

	public Filetype() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public int getForceThumb() {
		return this.forceThumb;
	}

	public void setForceThumb(int forceThumb) {
		this.forceThumb = forceThumb;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getImageH() {
		return this.imageH;
	}

	public void setImageH(int imageH) {
		this.imageH = imageH;
	}

	public int getImageW() {
		return this.imageW;
	}

	public void setImageW(int imageW) {
		this.imageW = imageW;
	}

	public String getMime() {
		return this.mime;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}

}