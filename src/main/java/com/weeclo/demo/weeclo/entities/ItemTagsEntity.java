package com.weeclo.demo.weeclo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item_tags", schema = "weeclodb", catalog = "")
@IdClass(ItemTagsEntityPK.class)
public class ItemTagsEntity {
    private int itemId;
    private int tagId;

    @Id
    @Column(name = "item_ID", nullable = false)
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Id
    @Column(name = "tag_ID", nullable = false)
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
        ItemTagsEntity that = (ItemTagsEntity) o;
        return itemId == that.itemId &&
                tagId == that.tagId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemId, tagId);
    }
}
