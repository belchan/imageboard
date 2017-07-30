package org.belchan.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity
@Table(name="front")
@NamedQuery(name="Front.findAll", query="SELECT f FROM Front f")
public class Front implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	@Lob
	private String message;

	private int order;

	private int page;

	private String poster;

	private String subject;

	private int timestamp;
}