package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data()
@Embeddable
public class Genre {

    @Column(insertable=false, updatable = false)
    private int id;
    @Column(insertable=false, updatable = false)
    private String name;

    public Genre() {
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
