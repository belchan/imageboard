package org.belchan.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PostPK implements Serializable {

    public static final long serialVersionUID = 20160525L;

    private Integer id;

    private Integer boardid;

    public PostPK() {
    }

    public PostPK(int id, int boardid) {
        this.id = id;
        this.boardid = boardid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostPK postPK = (PostPK) o;
        return id == postPK.id &&
                boardid == postPK.boardid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, boardid);
    }
}
