package com.weeclo.demo.weeclo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "owner", schema = "weeclodb", catalog = "")
public class OwnerEntity {
    private int id;
    private Double totalRevenue;
    private int totalRentals;
    private int totalItemsOwned;
    private Timestamp dateCreated;
    private String status;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "total_revenue", nullable = true, precision = 2)
    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Basic
    @Column(name = "total_rentals", nullable = false)
    public int getTotalRentals() {
        return totalRentals;
    }

    public void setTotalRentals(int totalRentals) {
        this.totalRentals = totalRentals;
    }

    @Basic
    @Column(name = "total_items_owned", nullable = false)
    public int getTotalItemsOwned() {
        return totalItemsOwned;
    }

    public void setTotalItemsOwned(int totalItemsOwned) {
        this.totalItemsOwned = totalItemsOwned;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerEntity that = (OwnerEntity) o;
        return id == that.id &&
                totalRentals == that.totalRentals &&
                totalItemsOwned == that.totalItemsOwned &&
                Objects.equals(totalRevenue, that.totalRevenue) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, totalRevenue, totalRentals, totalItemsOwned, dateCreated, status);
    }
}
