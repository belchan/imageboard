package org.belchan.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="ads")
@NamedQuery(name="Ad.findAll", query="SELECT a FROM Ad a")
public class Ad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String boards;

	@Lob
	private String code;

	private byte disp;

	private String position;
}