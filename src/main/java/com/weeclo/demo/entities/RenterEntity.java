package com.weeclo.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "renter", schema = "weeclodb", catalog = "")
public class RenterEntity {
    private int id;
    private Double totalSpent;
    private int totalRentals;
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
    @Column(name = "total_spent", nullable = true, precision = 2)
    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
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
        RenterEntity that = (RenterEntity) o;
        return id == that.id &&
                totalRentals == that.totalRentals &&
                Objects.equals(totalSpent, that.totalSpent) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, totalSpent, totalRentals, dateCreated, status);
    }
}
