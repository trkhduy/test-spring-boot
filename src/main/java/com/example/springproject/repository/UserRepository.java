package com.example.springproject.repository;


import com.example.springproject.dto.response.UserResponse;
import com.example.springproject.entity.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends BaseRepository<User> {
  @Query(
        """
                select new com.example.springproject.dto.response.UserResponse
                (u.id, u.username,u.password,u.email,u.phone,u.role)
                from User u
                where u.id=:id
              """
  )
  UserResponse getByUserId(Long id);
}
