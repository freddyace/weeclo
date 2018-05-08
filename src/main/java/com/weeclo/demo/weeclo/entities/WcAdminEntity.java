package com.weeclo.demo.weeclo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "wc_admin", schema = "weeclodb", catalog = "")
public class WcAdminEntity {
    private int userId;

    @Id
    @Column(name = "user_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WcAdminEntity that = (WcAdminEntity) o;
        return userId == that.userId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId);
    }
}
