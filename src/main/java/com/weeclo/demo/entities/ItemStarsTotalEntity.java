package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_stars_total", schema = "weeclodb", catalog = "")
public class ItemStarsTotalEntity {
    private int id;
    private int totalStars;
    private int totalReviews;
    private double avgStars;
    private int itemStarsId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "total_stars", nullable = false)
    public int getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }

    @Basic
    @Column(name = "total_reviews", nullable = false)
    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    @Basic
    @Column(name = "avg_stars", nullable = false, precision = 1)
    public double getAvgStars() {
        return avgStars;
    }

    public void setAvgStars(double avgStars) {
        this.avgStars = avgStars;
    }

    @Basic
    @Column(name = "item_stars_ID", nullable = false)
    public int getItemStarsId() {
        return itemStarsId;
    }

    public void setItemStarsId(int itemStarsId) {
        this.itemStarsId = itemStarsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemStarsTotalEntity that = (ItemStarsTotalEntity) o;
        return id == that.id &&
                totalStars == that.totalStars &&
                totalReviews == that.totalReviews &&
                Double.compare(that.avgStars, avgStars) == 0 &&
                itemStarsId == that.itemStarsId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, totalStars, totalReviews, avgStars, itemStarsId);
    }
}
