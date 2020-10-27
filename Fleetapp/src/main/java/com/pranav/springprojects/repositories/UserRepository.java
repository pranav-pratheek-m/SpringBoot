package com.pranav.springprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pranav.springprojects.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
