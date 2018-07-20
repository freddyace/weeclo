package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "items_rented", schema = "weeclodb", catalog = "")
public class ItemsRentedEntity {
    private int id;
    private String duration;
    private double cost;

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
    @Column(name = "cost", nullable = false, precision = 2)
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsRentedEntity that = (ItemsRentedEntity) o;
        return id == that.id &&
                Double.compare(that.cost, cost) == 0 &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, duration, cost);
    }
}
