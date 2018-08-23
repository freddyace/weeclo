package com.weeclo.demo.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class InterestsEntityPK implements Serializable {
    private int userId;
    private int subCategoryId;

    @Column(name = "user_ID", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "sub_category_ID", nullable = false)
    @Id
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
        InterestsEntityPK that = (InterestsEntityPK) o;
        return userId == that.userId &&
                subCategoryId == that.subCategoryId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, subCategoryId);
    }
}
