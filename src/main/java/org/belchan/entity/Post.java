package org.belchan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@Entity
@Table(name="posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private PostPK postPK;

	//private LocalDateTime bumped;
	@JsonIgnore
	private long bumped;

	@Column(name="deleted_timestamp")
	@JsonIgnore
	private Long deletedTimestamp;

	private String email;

	private String file;

	@Column(name="file_md5")
	private String fileMd5;

	@Column(name="file_original")
	private String fileOriginal;

	@Column(name="file_size")
	private int fileSize;

	@Column(name="file_size_formatted")
	private String fileSizeFormatted;

	@Column(name="file_type")
	private String fileType;

	@Column(name="image_h")
	private short imageH;

	@Column(name="image_w")
	private short imageW;

	private String ip;

	private String ipmd5;

	@Column(name="IS_DELETED")
	private byte isDeleted;

	private byte locked;

	@Lob
	private String message;

	private String name;

	private int parentid;

	private String password;

	private byte posterauthority;

	private byte reviewed;

	private byte stickied;

	private String subject;

	private String tag;

	@Column(name="thumb_h")
	private int thumbH;

	@Column(name="thumb_w")
	private int thumbW;

	//private LocalDateTime timestamp;
	@JsonIgnore
	private long timestamp;

	private String tripcode;

	public void setBumped(LocalDateTime time) {
		bumped = time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		bumped = bumped / 1000;
	}

	public void setTimestamp(LocalDateTime time) {
		timestamp = time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
		timestamp = timestamp / 1000;
	}

	@JsonProperty("id")
    public int getId() {
	    return postPK.getId();
    }

	@JsonProperty("boardid")
    public int getBoardid() {
	    return postPK.getBoardid();
    }
}