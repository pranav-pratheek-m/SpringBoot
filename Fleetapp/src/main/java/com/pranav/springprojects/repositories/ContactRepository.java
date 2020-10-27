package com.pranav.springprojects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.springprojects.models.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
