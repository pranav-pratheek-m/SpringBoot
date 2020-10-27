package com.pranav.springprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pranav.springprojects.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
