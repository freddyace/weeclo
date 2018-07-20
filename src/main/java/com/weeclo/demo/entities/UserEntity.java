package com.weeclo.demo.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "weeclodb", catalog = "")
public class UserEntity {
    private int id;
    private String systemName;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String phone;
    private String address1;
    private String address2;
    private String city;
    private int zip;
    private String neighborhood;
    private Timestamp dateJoined;
    private Date dateOfBirth;
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
    @Column(name = "system_name", nullable = false, length = 12)
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Basic
    @Column(name = "first_name", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email_address", nullable = true, length = 30)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address1", nullable = false, length = 40)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Basic
    @Column(name = "address2", nullable = true, length = 40)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "zip", nullable = false)
    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "neighborhood", nullable = false, length = 30)
    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Basic
    @Column(name = "date_joined", nullable = false)
    public Timestamp getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = true)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                zip == that.zip &&
                Objects.equals(systemName, that.systemName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address1, that.address1) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(neighborhood, that.neighborhood) &&
                Objects.equals(dateJoined, that.dateJoined) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, systemName, firstName, lastName, emailAddress, password, phone, address1, address2, city, zip, neighborhood, dateJoined, dateOfBirth, status);
    }
}
