package com.example.springproject.repository;

import com.example.springproject.entity.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User>{

    Optional<User> findUserByUsername(String username);
}
