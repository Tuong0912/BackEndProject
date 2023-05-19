package com.example.demo.repository.user;

import com.example.demo.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String user);
    @Query(value = "select u from User as u where u.email = :email")
    User findByUserEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean findByUsernameAndPassword(String username, String password);

    @Query(value = "select u from User as u where u.aBoolean is false ")
    Page<User> findAllByABooleanIsFalse(Pageable pageable);

    @Modifying
    @Query(value = "update User as u set u.aBoolean = true where u.id = :id")
    int browseAUser(@PathVariable long id);
}
