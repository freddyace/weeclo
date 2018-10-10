package com.weeclo.demo.session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Date;
import java.util.Enumeration;

/**
 * @param
 * @return
 * Session object to retain information from interactions, transactions, and various info when the user is logged in.
 *
 *
 */
public class WeeCloSession implements HttpSession{
    Certificate certificate;
    Long creationTime;
    Token token;

    //The WeeCloSession gets instantiated only by this constructor
    //This constructor creates an unmodifiable date that retains the
    //date in which the session was created. It also sets the
    //certificate field to the certificate passed into this function.
    public WeeCloSession(Certificate certificate){
        setCreationTime();
        this.certificate = certificate;
        this.token = new Token();
    }

    public Token getToken() {
        return token;
    }

    @Override
    public long getCreationTime() {
        return this.creationTime;
    }

    @Override
    public String getId() {
        return this.certificate.getUniqueIdentificationNumber();
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public Object getValue(String name) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String name, Object value) {

    }

    @Override
    public void putValue(String name, Object value) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public void removeValue(String name) {

    }

    @Override
    public void invalidate() {
        this.certificate = null;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    private void setCreationTime(){
        this.creationTime = new Date().getTime();
    }
}
