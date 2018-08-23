package com.weeclo.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_rating", schema = "weeclodb", catalog = "")
public class UserRatingEntity {
    private int id;
    private int toUserId;
    private int fromUserId;
    private int rateUp;
    private int rateDown;
    private Timestamp dateEntered;
    private String testimonial;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "to_user_ID", nullable = false)
    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    @Basic
    @Column(name = "from_user_ID", nullable = false)
    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    @Basic
    @Column(name = "rate_up", nullable = false)
    public int getRateUp() {
        return rateUp;
    }

    public void setRateUp(int rateUp) {
        this.rateUp = rateUp;
    }

    @Basic
    @Column(name = "rate_down", nullable = false)
    public int getRateDown() {
        return rateDown;
    }

    public void setRateDown(int rateDown) {
        this.rateDown = rateDown;
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
    @Column(name = "testimonial", nullable = true, length = -1)
    public String getTestimonial() {
        return testimonial;
    }

    public void setTestimonial(String testimonial) {
        this.testimonial = testimonial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRatingEntity that = (UserRatingEntity) o;
        return id == that.id &&
                toUserId == that.toUserId &&
                fromUserId == that.fromUserId &&
                rateUp == that.rateUp &&
                rateDown == that.rateDown &&
                Objects.equals(dateEntered, that.dateEntered) &&
                Objects.equals(testimonial, that.testimonial);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, toUserId, fromUserId, rateUp, rateDown, dateEntered, testimonial);
    }
}
