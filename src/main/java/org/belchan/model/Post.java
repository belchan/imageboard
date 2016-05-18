package org.belchan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PostPK postPK;

	//private LocalDateTime bumped;
	@JsonIgnore
	private Timestamp bumped;

	@Column(name="deleted_timestamp")
	@JsonIgnore
	private Timestamp deletedTimestamp;

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
	private Timestamp timestamp;

	private String tripcode;

	public Post() {
	}

	public LocalDateTime getBumped() {
		return this.bumped.toLocalDateTime();
	}

	public void setBumped(LocalDateTime bumped) {
		this.bumped = Timestamp.valueOf(bumped);
	}

	public LocalDateTime getDeletedTimestamp() {
		return this.deletedTimestamp.toLocalDateTime();
	}

	public void setDeletedTimestamp(LocalDateTime deletedTimestamp) {
		this.deletedTimestamp = Timestamp.valueOf(deletedTimestamp);
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileMd5() {
		return this.fileMd5;
	}

	public void setFileMd5(String fileMd5) {
		this.fileMd5 = fileMd5;
	}

	public String getFileOriginal() {
		return this.fileOriginal;
	}

	public void setFileOriginal(String fileOriginal) {
		this.fileOriginal = fileOriginal;
	}

	public int getFileSize() {
		return this.fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileSizeFormatted() {
		return this.fileSizeFormatted;
	}

	public void setFileSizeFormatted(String fileSizeFormatted) {
		this.fileSizeFormatted = fileSizeFormatted;
	}

	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public short getImageH() {
		return this.imageH;
	}

	public void setImageH(short imageH) {
		this.imageH = imageH;
	}

	public short getImageW() {
		return this.imageW;
	}

	public void setImageW(short imageW) {
		this.imageW = imageW;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpmd5() {
		return this.ipmd5;
	}

	public void setIpmd5(String ipmd5) {
		this.ipmd5 = ipmd5;
	}

	public byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	public byte getLocked() {
		return this.locked;
	}

	public void setLocked(byte locked) {
		this.locked = locked;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentid() {
		return this.parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getPosterauthority() {
		return this.posterauthority;
	}

	public void setPosterauthority(byte posterauthority) {
		this.posterauthority = posterauthority;
	}

	public byte getReviewed() {
		return this.reviewed;
	}

	public void setReviewed(byte reviewed) {
		this.reviewed = reviewed;
	}

	public byte getStickied() {
		return this.stickied;
	}

	public void setStickied(byte stickied) {
		this.stickied = stickied;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		if (tag.length() > 20) {
			tag = tag.substring(0,19);
		}
		this.tag = tag;
	}

	public int getThumbH() {
		return this.thumbH;
	}

	public void setThumbH(int thumbH) {
		this.thumbH = thumbH;
	}

	public int getThumbW() {
		return this.thumbW;
	}

	public void setThumbW(int thumbW) {
		this.thumbW = thumbW;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp.toLocalDateTime();
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = Timestamp.valueOf(timestamp);
	}

	public String getTripcode() {
		return this.tripcode;
	}

	public void setTripcode(String tripcode) {
		this.tripcode = tripcode;
	}

	public PostPK getPostPK() {
		return postPK;
	}

	public void setPostPK(PostPK postPK) {
		this.postPK = postPK;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Post post = (Post) o;
		return fileSize == post.fileSize &&
				imageH == post.imageH &&
				imageW == post.imageW &&
				isDeleted == post.isDeleted &&
				locked == post.locked &&
				parentid == post.parentid &&
				posterauthority == post.posterauthority &&
				reviewed == post.reviewed &&
				stickied == post.stickied &&
				thumbH == post.thumbH &&
				thumbW == post.thumbW &&
				Objects.equals(postPK, post.postPK) &&
				Objects.equals(bumped, post.bumped) &&
				Objects.equals(deletedTimestamp, post.deletedTimestamp) &&
				Objects.equals(email, post.email) &&
				Objects.equals(file, post.file) &&
				Objects.equals(fileMd5, post.fileMd5) &&
				Objects.equals(fileOriginal, post.fileOriginal) &&
				Objects.equals(fileSizeFormatted, post.fileSizeFormatted) &&
				Objects.equals(fileType, post.fileType) &&
				Objects.equals(ip, post.ip) &&
				Objects.equals(ipmd5, post.ipmd5) &&
				Objects.equals(message, post.message) &&
				Objects.equals(name, post.name) &&
				Objects.equals(password, post.password) &&
				Objects.equals(subject, post.subject) &&
				Objects.equals(tag, post.tag) &&
				Objects.equals(timestamp, post.timestamp) &&
				Objects.equals(tripcode, post.tripcode);
	}

	@Override
	public int hashCode() {
		return Objects.hash(postPK, bumped, deletedTimestamp, email, file, fileMd5, fileOriginal, fileSize, fileSizeFormatted, fileType, imageH, imageW, ip, ipmd5, isDeleted, locked, message, name, parentid, password, posterauthority, reviewed, stickied, subject, tag, thumbH, thumbW, timestamp, tripcode);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Post{");
		sb.append("postPK=").append(postPK);
		sb.append(", bumped=").append(bumped);
		sb.append(", deletedTimestamp=").append(deletedTimestamp);
		sb.append(", email='").append(email).append('\'');
		sb.append(", file='").append(file).append('\'');
		sb.append(", fileMd5='").append(fileMd5).append('\'');
		sb.append(", fileOriginal='").append(fileOriginal).append('\'');
		sb.append(", fileSize=").append(fileSize);
		sb.append(", fileSizeFormatted='").append(fileSizeFormatted).append('\'');
		sb.append(", fileType='").append(fileType).append('\'');
		sb.append(", imageH=").append(imageH);
		sb.append(", imageW=").append(imageW);
		sb.append(", ip='").append(ip).append('\'');
		sb.append(", ipmd5='").append(ipmd5).append('\'');
		sb.append(", isDeleted=").append(isDeleted);
		sb.append(", locked=").append(locked);
		sb.append(", message='").append(message).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", parentid=").append(parentid);
		sb.append(", password='").append(password).append('\'');
		sb.append(", posterauthority=").append(posterauthority);
		sb.append(", reviewed=").append(reviewed);
		sb.append(", stickied=").append(stickied);
		sb.append(", subject='").append(subject).append('\'');
		sb.append(", tag='").append(tag).append('\'');
		sb.append(", thumbH=").append(thumbH);
		sb.append(", thumbW=").append(thumbW);
		sb.append(", timestamp=").append(timestamp);
		sb.append(", tripcode='").append(tripcode).append('\'');
		sb.append('}');
		return sb.toString();
	}
}