package org.belchan.entity;

import lombok.Data;
import java.io.Serializable;
import javax.persistence.*;


@Data
@Entity
@Table(name="announcements")
@NamedQuery(name="Announcement.findAll", query="SELECT a FROM Announcement a")
public class Announcement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	private String message;

	private int parentid;

	private int postedat;

	private String postedby;

	private String subject;
}