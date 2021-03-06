package com.pranav.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pranav.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien,Integer> {

  List<Alien> findByTech(String tech);
  List<Alien> findByAidGreaterThan(int aid);
  List<Alien> findByAidLessThan(int aid);
  
  @Query("from Alien where tech = ?1 order by aname desc")
  List<Alien> findByTechSortedName(String tech);
}
