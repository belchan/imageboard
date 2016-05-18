package org.belchan.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
public class PostPK implements Serializable {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private int boardid;

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

        if (id != postPK.id) return false;
        return boardid == postPK.boardid;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + boardid;
        return result;
    }
}
