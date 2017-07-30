package org.belchan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name="staff")
@NamedQuery(name="Staff.findAll", query="SELECT s FROM Staff s")
public class Staff implements Serializable {
	private static final long serialVersionUID = 1L;
	public static String COL_USER_NAME = "username";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	private int addedon;

	@Lob
	private String boards;

	@JsonIgnore
	private int lastactive;

	@JsonIgnore
	private String password;

	@JsonIgnore
	private String salt;

	private byte type;

	private String username;

}