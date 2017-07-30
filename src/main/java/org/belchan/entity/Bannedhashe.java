package org.belchan.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity
@Table(name="bannedhashes")
@NamedQuery(name="Bannedhashe.findAll", query="SELECT b FROM Bannedhashe b")
public class Bannedhashe implements Serializable {
	private static final long serialVersionUID = 1L;

	private int bantime;

	@Lob
	private String description;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String md5;
}