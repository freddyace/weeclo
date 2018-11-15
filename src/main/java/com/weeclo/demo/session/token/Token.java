package com.weeclo.demo.session.token;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * External reference to Certificate. Consumed by client-side & server-side.
 * The Token object is used to give the user limited authentication.
 * When a user authenticates for the first time, a Certificate object is created, which contains
 * a Token object, any subsequent authentications result in usage of the same Certificate object.
 * The token id is passed to the client (unique number),
 * and is 'bound' to Certificate. The Certificate contains information regarding
 * the user's history of sign-in sessions and serves as a proxy class for
 * retrieving the pojos necessary for session info retrieval.
 */
public class Token implements Serializable{
    String ID;
    Date issuedDateTime;
    Date expirationDateTime;

    public Token(Boolean autoGenDates){
        if(autoGenDates) {
            this.ID = UUID.randomUUID().toString();
            this.issuedDateTime = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MINUTE, 30);
            this.expirationDateTime = calendar.getTime();
        }else{
            this.ID = null;
            this.issuedDateTime = null;
            this.expirationDateTime = null;
        }

    }


    public String getID() {
        return ID;
    }

    private void setID(String ID) {
        this.ID = ID;
    }

    public Date getIssuedDateTime() {
        return issuedDateTime;
    }

    public void setIssuedDateTime(Date issuedDateTime) {
        this.issuedDateTime = issuedDateTime;
    }

    public Date getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(Date expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }
}
