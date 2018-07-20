package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "us_states", schema = "weeclodb", catalog = "")
public class UsStatesEntity {
    private String abbrev;
    private String name;

    @Id
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
        return Objects.equals(abbrev, that.abbrev) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(abbrev, name);
    }
}
