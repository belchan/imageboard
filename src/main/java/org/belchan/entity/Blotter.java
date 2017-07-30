package org.belchan.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity
@Table(name="blotter")
@NamedQuery(name="Blotter.findAll", query="SELECT b FROM Blotter b")
public class Blotter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int at;

	private byte important;

	@Lob
	private String message;
}