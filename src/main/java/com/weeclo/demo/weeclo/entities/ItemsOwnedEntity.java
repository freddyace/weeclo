package com.weeclo.demo.weeclo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items_owned", schema = "weeclodb", catalog = "")
public class ItemsOwnedEntity {
    private int id;
    private String duration;
    private double revenue;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "duration", nullable = false, length = 10)
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "revenue", nullable = false, precision = 2)
    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsOwnedEntity that = (ItemsOwnedEntity) o;
        return id == that.id &&
                Double.compare(that.revenue, revenue) == 0 &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, duration, revenue);
    }
}
