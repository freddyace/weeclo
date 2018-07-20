package com.weeclo.demo.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ItemTagsEntityPK implements Serializable {
    private int itemId;
    private int tagId;

    @Column(name = "item_ID", nullable = false)
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name = "tag_ID", nullable = false)
    @Id
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemTagsEntityPK that = (ItemTagsEntityPK) o;
        return itemId == that.itemId &&
                tagId == that.tagId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemId, tagId);
    }
}
