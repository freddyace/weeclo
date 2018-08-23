package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "interests", schema = "weeclodb", catalog = "")
@IdClass(InterestsEntityPK.class)
public class InterestsEntity {
    private int userId;
    private int subCategoryId;

    @Id
    @Column(name = "user_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "sub_category_ID", nullable = false)
    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterestsEntity that = (InterestsEntity) o;
        return userId == that.userId &&
                subCategoryId == that.subCategoryId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, subCategoryId);
    }
}
