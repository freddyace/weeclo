package com.weeclo.demo.session.repository;

import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.WeeCloSession;

import java.util.Map;

public interface WeeCloSessionRepository {
    //Save a WeeCloSession
    void save(WeeCloSession weeCloSession);
    //Function to return all sessions by mapping a WeeCloSession's Certificate's unique id to each WeeCloSession
    Map<String, WeeCloSession> findAll();
    //Function to return a session by retrieveing it by it's corresponding certificate's unique id
    WeeCloSession findById(String id);
    //Function to update an existing session
    void update(WeeCloSession weeCloSession);
    //Function to delete an existing session
    void delete(String id);
}
