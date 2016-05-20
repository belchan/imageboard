package org.belchan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int boardid;


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


	public int getBoardid() {
		return this.boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Post)) return false;

		Post post = (Post) o;

		if (getId() != post.getId()) return false;
		if (getBoardid() != post.getBoardid()) return false;
		if (getBumped() != post.getBumped()) return false;
		if (getDeletedTimestamp() != post.getDeletedTimestamp()) return false;
		if (getFileSize() != post.getFileSize()) return false;
		if (getImageH() != post.getImageH()) return false;
		if (getImageW() != post.getImageW()) return false;
		if (getIsDeleted() != post.getIsDeleted()) return false;
		if (getLocked() != post.getLocked()) return false;
		if (getParentid() != post.getParentid()) return false;
		if (getPosterauthority() != post.getPosterauthority()) return false;
		if (getReviewed() != post.getReviewed()) return false;
		if (getStickied() != post.getStickied()) return false;
		if (getThumbH() != post.getThumbH()) return false;
		if (getThumbW() != post.getThumbW()) return false;
		if (getTimestamp() != post.getTimestamp()) return false;
		if (getEmail() != null ? !getEmail().equals(post.getEmail()) : post.getEmail() != null) return false;
		if (getFile() != null ? !getFile().equals(post.getFile()) : post.getFile() != null) return false;
		if (getFileMd5() != null ? !getFileMd5().equals(post.getFileMd5()) : post.getFileMd5() != null) return false;
		if (getFileOriginal() != null ? !getFileOriginal().equals(post.getFileOriginal()) : post.getFileOriginal() != null)
			return false;
		if (getFileSizeFormatted() != null ? !getFileSizeFormatted().equals(post.getFileSizeFormatted()) : post.getFileSizeFormatted() != null)
			return false;
		if (getFileType() != null ? !getFileType().equals(post.getFileType()) : post.getFileType() != null)
			return false;
		if (getIp() != null ? !getIp().equals(post.getIp()) : post.getIp() != null) return false;
		if (getIpmd5() != null ? !getIpmd5().equals(post.getIpmd5()) : post.getIpmd5() != null) return false;
		if (getMessage() != null ? !getMessage().equals(post.getMessage()) : post.getMessage() != null) return false;
		if (getName() != null ? !getName().equals(post.getName()) : post.getName() != null) return false;
		if (getPassword() != null ? !getPassword().equals(post.getPassword()) : post.getPassword() != null)
			return false;
		if (getSubject() != null ? !getSubject().equals(post.getSubject()) : post.getSubject() != null) return false;
		if (getTag() != null ? !getTag().equals(post.getTag()) : post.getTag() != null) return false;
		return !(getTripcode() != null ? !getTripcode().equals(post.getTripcode()) : post.getTripcode() != null);

	}

	@Override
	public int hashCode() {
		int result = getId();
		result = 31 * result + getBoardid();
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		result = 31 * result + (getFile() != null ? getFile().hashCode() : 0);
		result = 31 * result + (getFileMd5() != null ? getFileMd5().hashCode() : 0);
		result = 31 * result + (getFileOriginal() != null ? getFileOriginal().hashCode() : 0);
		result = 31 * result + getFileSize();
		result = 31 * result + (getFileSizeFormatted() != null ? getFileSizeFormatted().hashCode() : 0);
		result = 31 * result + (getFileType() != null ? getFileType().hashCode() : 0);
		result = 31 * result + (int) getImageH();
		result = 31 * result + (int) getImageW();
		result = 31 * result + (getIp() != null ? getIp().hashCode() : 0);
		result = 31 * result + (getIpmd5() != null ? getIpmd5().hashCode() : 0);
		result = 31 * result + (int) getIsDeleted();
		result = 31 * result + (int) getLocked();
		result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + getParentid();
		result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
		result = 31 * result + (int) getPosterauthority();
		result = 31 * result + (int) getReviewed();
		result = 31 * result + (int) getStickied();
		result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
		result = 31 * result + (getTag() != null ? getTag().hashCode() : 0);
		result = 31 * result + getThumbH();
		result = 31 * result + getThumbW();
		result = 31 * result + (getTripcode() != null ? getTripcode().hashCode() : 0);
		return result;
	}

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", boardid=" + boardid +
                ", bumped=" + bumped +
                ", deletedTimestamp=" + deletedTimestamp +
                ", email='" + email + '\'' +
                ", file='" + file + '\'' +
                ", fileMd5='" + fileMd5 + '\'' +
                ", fileOriginal='" + fileOriginal + '\'' +
                ", fileSize=" + fileSize +
                ", fileSizeFormatted='" + fileSizeFormatted + '\'' +
                ", fileType='" + fileType + '\'' +
                ", imageH=" + imageH +
                ", imageW=" + imageW +
                ", ip='" + ip + '\'' +
                ", ipmd5='" + ipmd5 + '\'' +
                ", isDeleted=" + isDeleted +
                ", locked=" + locked +
                ", message='" + message + '\'' +
                ", name='" + name + '\'' +
                ", parentid=" + parentid +
                ", password='" + password + '\'' +
                ", posterauthority=" + posterauthority +
                ", reviewed=" + reviewed +
                ", stickied=" + stickied +
                ", subject='" + subject + '\'' +
                ", tag='" + tag + '\'' +
                ", thumbH=" + thumbH +
                ", thumbW=" + thumbW +
                ", timestamp=" + timestamp +
                ", tripcode='" + tripcode + '\'' +
                '}';
    }
}