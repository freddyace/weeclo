package com.weeclo.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tokens", schema = "weeclodb", catalog = "")
public class TokensEntity {
    private int userId;
    private String tokenValue;

    @Id
    @Column(name = "user_ID", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "token_value", nullable = false, length = 32)
    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokensEntity that = (TokensEntity) o;
        return userId == that.userId &&
                Objects.equals(tokenValue, that.tokenValue);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, tokenValue);
    }
}
