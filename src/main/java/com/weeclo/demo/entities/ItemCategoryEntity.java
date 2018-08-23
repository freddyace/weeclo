package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_category", schema = "weeclodb", catalog = "")
@IdClass(ItemCategoryEntityPK.class)
public class ItemCategoryEntity {
    private int itemId;
    private int categoryId;
    private int subCategoryId;

    @Id
    @Column(name = "item_ID", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Id
    @Column(name = "category_ID", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
        ItemCategoryEntity that = (ItemCategoryEntity) o;
        return itemId == that.itemId &&
                categoryId == that.categoryId &&
                subCategoryId == that.subCategoryId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemId, categoryId, subCategoryId);
    }
}
