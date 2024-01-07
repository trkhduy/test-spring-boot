package com.example.springproject.repository;


import com.example.springproject.dto.response.UserResponse;
import com.example.springproject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
  UserResponse getByUserId(String id);

  @Query("""
         select new com.example.springproject.dto.response.UserResponse
         (u.id, u.username,u.password,u.email,u.phone,u.role)
        from User u
         """)
  Page<UserResponse> findAllShipment(Pageable pageable);

  @Query("""
            select new com.example.springproject.dto.response.UserResponse
            (u.id, u.username, u.password, u.email, u.phone, u.role)
            from User u
            where (:keyword is null or
            lower(u.username) LIKE lower(concat('%', :keyword, '%')) or
            lower(u.phone) LIKE lower(concat('%', :keyword, '%')) or
            lower(u.email) LIKE lower(concat('%', :keyword, '%')) or
            lower(u.phone) LIKE lower(concat('%', :keyword, '%')) or
            lower(u.role) LIKE lower(concat('%', :keyword, '%')))
        """)
  Page<UserResponse> searchUser(Pageable pageable, String keyword);

}
