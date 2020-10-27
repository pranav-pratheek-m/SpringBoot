package com.pranav.springprojects.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pranav.springprojects.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	@Query("select distinct description from Country")
   public List<String> findCountryNamesDistinct();

}
