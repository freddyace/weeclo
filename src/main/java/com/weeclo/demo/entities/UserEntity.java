package com.weeclo.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "weeclodb", catalog = "")
public class UserEntity implements Serializable {
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
    private String stateId;
    private int zip;
    private int neighborhood;
    private Timestamp dateJoined;
    private Date dateOfBirth;
    private String status;
    private String profilePicturePath;
    private String profilePictureName;

    @JsonProperty
    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty
    @Basic
    @Column(name = "system_name", nullable = false, length = 20)
    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @JsonProperty
    @Basic
    @Column(name = "first_name", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty
    @Basic
    @Column(name = "last_name", nullable = false, length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty
    @Basic
    @Column(name = "email_address", nullable = false, length = 45)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty
    @Basic
    @Column(name = "password", nullable = false, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty
    @Basic
    @Column(name = "phone", nullable = false, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty
    @Basic
    @Column(name = "address1", nullable = false, length = 60)
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @JsonProperty
    @Basic
    @Column(name = "address2", nullable = true, length = 60)
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @JsonProperty
    @Basic
    @Column(name = "city", nullable = false, length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty
    @Basic
    @Column(name = "state_ID", nullable = false, length = 2)
    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    @JsonProperty
    @Basic
    @Column(name = "zip", nullable = false)
    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @JsonProperty
    @Basic
    @Column(name = "neighborhood", nullable = false)
    public int getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(int neighborhood) {
        this.neighborhood = neighborhood;
    }

    @JsonProperty
    @Basic
    @Column(name = "date_joined", nullable = false)
    public Timestamp getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    @JsonProperty
    @Basic
    @Column(name = "date_of_birth", nullable = true)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty
    @Basic
    @Column(name = "status", nullable = false, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty
    @Basic
    @Column(name = "profile_picture_path", nullable = true, length = 100)
    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    @JsonProperty
    @Basic
    @Column(name = "profile_picture_name", nullable = true, length = 45)
    public String getProfilePictureName() {
        return profilePictureName;
    }

    public void setProfilePictureName(String profilePictureName) {
        this.profilePictureName = profilePictureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                zip == that.zip &&
                neighborhood == that.neighborhood &&
                Objects.equals(systemName, that.systemName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address1, that.address1) &&
                Objects.equals(address2, that.address2) &&
                Objects.equals(city, that.city) &&
                Objects.equals(stateId, that.stateId) &&
                Objects.equals(dateJoined, that.dateJoined) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(status, that.status) &&
                Objects.equals(profilePicturePath, that.profilePicturePath) &&
                Objects.equals(profilePictureName, that.profilePictureName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, systemName, firstName, lastName, emailAddress, password, phone, address1, address2, city, stateId, zip, neighborhood, dateJoined, dateOfBirth, status, profilePicturePath, profilePictureName);
    }
}
