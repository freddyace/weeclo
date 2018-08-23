package com.weeclo.demo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "images", schema = "weeclodb", catalog = "")
public class ImagesEntity {
    private int id;
    private String imagePath;
    private String imageName;
    private String type;
    private Timestamp dateUploaded;
    private int userId;
    private int itemId;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "image_path", nullable = false, length = 100)
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Basic
    @Column(name = "image_name", nullable = false, length = 45)
    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "date_uploaded", nullable = false)
    public Timestamp getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Timestamp dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    @Basic
    @Column(name = "user_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "item_ID", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagesEntity that = (ImagesEntity) o;
        return id == that.id &&
                userId == that.userId &&
                itemId == that.itemId &&
                Objects.equals(imagePath, that.imagePath) &&
                Objects.equals(imageName, that.imageName) &&
                Objects.equals(type, that.type) &&
                Objects.equals(dateUploaded, that.dateUploaded);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, imagePath, imageName, type, dateUploaded, userId, itemId);
    }
}
