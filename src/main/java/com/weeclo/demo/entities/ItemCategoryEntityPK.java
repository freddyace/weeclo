package com.weeclo.demo.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ItemCategoryEntityPK implements Serializable {
    private int itemId;
    private int categoryId;
    private int subCategoryId;

    @Column(name = "item_ID", nullable = false)
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name = "category_ID", nullable = false)
    @Id
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
        ItemCategoryEntityPK that = (ItemCategoryEntityPK) o;
        return itemId == that.itemId &&
                categoryId == that.categoryId &&
                subCategoryId == that.subCategoryId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemId, categoryId, subCategoryId);
    }
}
