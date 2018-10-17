package com.weeclo.demo.session.repository;

import com.weeclo.demo.entities.UserEntity;
import com.weeclo.demo.session.repository.UserEntityRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserEntityRepositoryImpl implements UserEntityRepository {

    private RedisTemplate<String, UserEntity> redisTemplate;

    private HashOperations hashOperations;


    public UserEntityRepositoryImpl(RedisTemplate<String, UserEntity> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }
    @Override
    public void save(UserEntity user) {
        hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<Integer, UserEntity> findAll() {
        return hashOperations.entries("USER");
    }

    @Override
    public UserEntity findById(String id) {
        return (UserEntity) hashOperations.get("USER", id);
    }

    @Override
    public void update(UserEntity user) {
        save(user);
    }

    @Override
    public void delete(String id) {

        hashOperations.delete("USER", id);
    }

}
