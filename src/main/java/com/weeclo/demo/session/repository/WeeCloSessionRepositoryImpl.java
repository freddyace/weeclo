package com.weeclo.demo.session.repository;

import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.WeeCloSession;
import com.weeclo.demo.session.repository.WeeCloSessionRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class WeeCloSessionRepositoryImpl implements WeeCloSessionRepository {

    private RedisTemplate<String, WeeCloSession> redisSessionTemplate;
    private HashOperations hashOperations;

    public WeeCloSessionRepositoryImpl(RedisTemplate<String, WeeCloSession> redisSessionTemplate){
        this.redisSessionTemplate = redisSessionTemplate;
        hashOperations = redisSessionTemplate.opsForHash();
    }
    @Override
    public void save(WeeCloSession weeCloSession) {
        hashOperations.put("SESSION", weeCloSession.getId(), weeCloSession);
    }

    @Override
    public Map<String, WeeCloSession> findAll() {
        return hashOperations.entries("SESSION");
    }

    @Override
    public WeeCloSession findById(String id) {
        return (WeeCloSession) hashOperations.get("SESSION", id);
    }

    @Override
    public void update(WeeCloSession weeCloSession) {

    }

    @Override
    public void delete(String id) {

    }
}
