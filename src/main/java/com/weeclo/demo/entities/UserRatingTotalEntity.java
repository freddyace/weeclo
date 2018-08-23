package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_rating_total", schema = "weeclodb", catalog = "")
public class UserRatingTotalEntity {
    private int id;
    private int totalUps;
    private int totalDowns;
    private double avgRating;
    private int userId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "total_ups", nullable = false)
    public int getTotalUps() {
        return totalUps;
    }

    public void setTotalUps(int totalUps) {
        this.totalUps = totalUps;
    }

    @Basic
    @Column(name = "total_downs", nullable = false)
    public int getTotalDowns() {
        return totalDowns;
    }

    public void setTotalDowns(int totalDowns) {
        this.totalDowns = totalDowns;
    }

    @Basic
    @Column(name = "avg_rating", nullable = false, precision = 2)
    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    @Basic
    @Column(name = "user_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRatingTotalEntity that = (UserRatingTotalEntity) o;
        return id == that.id &&
                totalUps == that.totalUps &&
                totalDowns == that.totalDowns &&
                Double.compare(that.avgRating, avgRating) == 0 &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, totalUps, totalDowns, avgRating, userId);
    }
}
