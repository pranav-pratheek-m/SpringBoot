package com.pranav.springprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.springprojects.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
