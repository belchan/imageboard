package org.belchan.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Entity
@Table(name="watchedthreads")
@NamedQuery(name="Watchedthread.findAll", query="SELECT w FROM Watchedthread w")
public class Watchedthread implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String board;

	private String ip;

	private int lastsawreplyid;

	private int threadid;
}