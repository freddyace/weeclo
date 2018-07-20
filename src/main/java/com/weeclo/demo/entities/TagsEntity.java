package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tags", schema = "weeclodb", catalog = "")
public class TagsEntity {
    private int id;
    private String tagName;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tag_name", nullable = false, length = 30)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagsEntity that = (TagsEntity) o;
        return id == that.id &&
                Objects.equals(tagName, that.tagName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, tagName);
    }
}
