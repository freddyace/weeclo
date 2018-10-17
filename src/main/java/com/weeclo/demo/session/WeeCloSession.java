package com.weeclo.demo.session;

import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.certificate.Certificate;
import com.weeclo.demo.session.sessionPojos.LoggedIn;
import com.weeclo.demo.session.token.Token;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.io.Serializable;
import java.util.Date;
import java.util.Enumeration;

/**
 * @param
 * @return
 * Session object to retain information from interactions, transactions, and various info when/if the user is logged in.
 *
 *
 */
public class WeeCloSession implements HttpSession,Serializable{
    Certificate certificate;
    Long creationTime;
    LoggedIn loggedIn;

    //The WeeCloSession can be instantiated by this constructor
    //This constructor creates an unmodifiable date that retains the
    //date in which the session was created. It also sets the
    //certificate field to the certificate passed into this function.
    public WeeCloSession(Certificate certificate){
        setCreationTime();
        this.certificate = certificate;
        //TODO:Work with built-in servlet context attributes
        //getServletContext()
    }
    public WeeCloSession(){

    }
    public void setLoggedIn(UserEntity userEntity){
        this.loggedIn = new LoggedIn();
        loggedIn.setActive(true);
        loggedIn.setUser(userEntity);
        loggedIn.setLastAccessedTime(System.currentTimeMillis());

    }

    public LoggedIn getLoggedIn(){
        return loggedIn;
    }

    public Certificate getCertificate() {
        return certificate;
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
