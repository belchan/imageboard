package org.belchan.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name="modlog")
@NamedQuery(name="Modlog.findAll", query="SELECT m FROM Modlog m")
public class Modlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte category;

	@Lob
	private String entry;

	private int timestamp;

	private String user;
}