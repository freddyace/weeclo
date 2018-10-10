package com.weeclo.demo.session;

import java.util.UUID;


/**
 * Internal reference to the token to be placed at the client-side
 */
public class Certificate {
    private String uniqueIdentificationNumber;
    private String ownerID;
    private String ownerFirstName;
    private String ownerLastName;
    Token token;

    public String getUniqueIdentificationNumber() {
        if(this.uniqueIdentificationNumber!=null) {
            return uniqueIdentificationNumber;
        }
        else{
            this.uniqueIdentificationNumber = UUID.randomUUID().toString();
            return this.uniqueIdentificationNumber;
        }
    }

    public void setUniqueIdentificationNumber() {
        if(this.uniqueIdentificationNumber.isEmpty() ||
                this.uniqueIdentificationNumber.equals(null)){
                this.uniqueIdentificationNumber = UUID.randomUUID().toString();
        }
        else if(!this.uniqueIdentificationNumber.isEmpty()){
            return;
        }
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }


}
