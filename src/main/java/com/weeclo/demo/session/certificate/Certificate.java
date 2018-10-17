package com.weeclo.demo.session.certificate;

import com.weeclo.demo.session.token.Token;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;


/**
 * Internal reference to the token to be placed at the client-side.
 * This Certificate serves as a proxy class to retrieve session information
 * mapped as pojos.
 */
public class Certificate implements Serializable{
    private String uniqueIdentificationNumber;
    private String ownerID;
    private String ownerFirstName;
    private String ownerLastName;
    //List of IpAddresses associated with an account with their last accessed times.
    private Map<String, String> trustedIPaddresses;
    Token token;

    public Certificate(){
        this.uniqueIdentificationNumber = UUID.randomUUID().toString();
    }

    public void setUniqueIdentificationNumber(String uniqueIdentificationNumber) {
        this.uniqueIdentificationNumber = uniqueIdentificationNumber;
    }

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
                this.uniqueIdentificationNumber==null){
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
