package org.belchan.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="wordfilter")
@NamedQuery(name="Wordfilter.findAll", query="SELECT w FROM Wordfilter w")
public class Wordfilter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String boards;

	private String regex;

	private String replacedby;

	private int time;

	private String word;
}