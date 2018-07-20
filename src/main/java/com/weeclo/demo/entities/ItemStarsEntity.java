package com.weeclo.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item_stars", schema = "weeclodb", catalog = "")
public class ItemStarsEntity {
    private int id;
    private int stars;
    private Timestamp dateEntered;
    private String comment;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stars", nullable = false)
    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Basic
    @Column(name = "date_entered", nullable = false)
    public Timestamp getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Timestamp dateEntered) {
        this.dateEntered = dateEntered;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStarsEntity that = (ItemStarsEntity) o;
        return id == that.id &&
                stars == that.stars &&
                Objects.equals(dateEntered, that.dateEntered) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stars, dateEntered, comment);
    }
}
