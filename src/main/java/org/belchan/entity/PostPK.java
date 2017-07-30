package org.belchan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PostPK implements Serializable {

    public static final long serialVersionUID = 20160525L;

	private Integer id;

	private Integer boardid;

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
