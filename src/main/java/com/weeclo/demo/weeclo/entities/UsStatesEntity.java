package com.weeclo.demo.weeclo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "us_states", schema = "weeclodb", catalog = "")
public class UsStatesEntity {
    private int id;
    private String abbrev;
    private String name;

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "abbrev", nullable = false, length = 2)
    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsStatesEntity that = (UsStatesEntity) o;
        return id == that.id &&
                Objects.equals(abbrev, that.abbrev) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, abbrev, name);
    }
}
