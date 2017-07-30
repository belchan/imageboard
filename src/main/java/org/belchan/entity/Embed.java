package org.belchan.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


@Data
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
}