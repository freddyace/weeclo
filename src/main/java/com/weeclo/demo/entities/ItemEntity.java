package com.weeclo.demo.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "item", schema = "weeclodb", catalog = "")
public class ItemEntity {
    private int id;
    private String itemName;
    private String itemDescription;
    private int timesRented;
    private String itemCondition;
    private Timestamp dateAdded;
    private String itemStatus;
    private String deliveryMode;
    private double costDay;
    private double costHour;
    private String availability;
    private Date nextAvail;
    private byte buyNow;
    private Double buyNowPrice;
    private double totalRevenue;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "item_name", nullable = false, length = 20)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_description", nullable = false, length = -1)
    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @Basic
    @Column(name = "times_rented", nullable = false)
    public int getTimesRented() {
        return timesRented;
    }

    public void setTimesRented(int timesRented) {
        this.timesRented = timesRented;
    }

    @Basic
    @Column(name = "item_condition", nullable = false, length = 20)
    public String getItemCondition() {
        return itemCondition;
    }

    public void setItemCondition(String itemCondition) {
        this.itemCondition = itemCondition;
    }

    @Basic
    @Column(name = "date_added", nullable = false)
    public Timestamp getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Timestamp dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Basic
    @Column(name = "item_status", nullable = false, length = 10)
    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Basic
    @Column(name = "delivery_mode", nullable = false, length = 10)
    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    @Basic
    @Column(name = "cost_day", nullable = false, precision = 2)
    public double getCostDay() {
        return costDay;
    }

    public void setCostDay(double costDay) {
        this.costDay = costDay;
    }

    @Basic
    @Column(name = "cost_hour", nullable = false, precision = 2)
    public double getCostHour() {
        return costHour;
    }

    public void setCostHour(double costHour) {
        this.costHour = costHour;
    }

    @Basic
    @Column(name = "availability", nullable = false, length = 15)
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Basic
    @Column(name = "next_avail", nullable = true)
    public Date getNextAvail() {
        return nextAvail;
    }

    public void setNextAvail(Date nextAvail) {
        this.nextAvail = nextAvail;
    }

    @Basic
    @Column(name = "buy_now", nullable = false)
    public byte getBuyNow() {
        return buyNow;
    }

    public void setBuyNow(byte buyNow) {
        this.buyNow = buyNow;
    }

    @Basic
    @Column(name = "buy_now_price", nullable = true, precision = 2)
    public Double getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(Double buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    @Basic
    @Column(name = "total_revenue", nullable = false, precision = 2)
    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return id == that.id &&
                timesRented == that.timesRented &&
                Double.compare(that.costDay, costDay) == 0 &&
                Double.compare(that.costHour, costHour) == 0 &&
                buyNow == that.buyNow &&
                Double.compare(that.totalRevenue, totalRevenue) == 0 &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(itemDescription, that.itemDescription) &&
                Objects.equals(itemCondition, that.itemCondition) &&
                Objects.equals(dateAdded, that.dateAdded) &&
                Objects.equals(itemStatus, that.itemStatus) &&
                Objects.equals(deliveryMode, that.deliveryMode) &&
                Objects.equals(availability, that.availability) &&
                Objects.equals(nextAvail, that.nextAvail) &&
                Objects.equals(buyNowPrice, that.buyNowPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, itemName, itemDescription, timesRented, itemCondition, dateAdded, itemStatus, deliveryMode, costDay, costHour, availability, nextAvail, buyNow, buyNowPrice, totalRevenue);
    }
}
