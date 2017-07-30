package org.belchan.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity
@Table(name="loginattempts")
@NamedQuery(name="Loginattempt.findAll", query="SELECT l FROM Loginattempt l")
public class Loginattempt implements Serializable {
	private static final long serialVersionUID = 1L;

	private String ip;

	//TODO review This entity
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int timestamp;

	private String username;
}