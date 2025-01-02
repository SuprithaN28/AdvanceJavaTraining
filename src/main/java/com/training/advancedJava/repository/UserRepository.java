package com.training.advancedJava.repository;

import com.training.advancedJava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Customer Query
    @Query("select u from User u ")
    List<User> findUser();

    
    @Query("Select u.username as username ,u.email as email from User u where u.role=:role")
    List<UserProjection> findUserProjectionsByRole(@Param("role") String role);

    //Projections
    interface UserProjection {
        String getUsername();

        String getEmail();
    }
}
