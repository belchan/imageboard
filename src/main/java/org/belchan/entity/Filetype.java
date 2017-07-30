package org.belchan.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


@Data
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
}