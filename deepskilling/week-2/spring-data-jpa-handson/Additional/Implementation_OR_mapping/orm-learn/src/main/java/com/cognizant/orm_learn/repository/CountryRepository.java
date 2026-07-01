package com.cognizant.orm_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // 1. Search by partial name match (e.g. 'ou' matches Bouvet, Djibouti, Guadeloupe...)
    List<Country> findByNameContainingIgnoreCase(String partialName);

    // 2. Same search, but ordered ascending by name
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String partialName);

    // 3. Countries whose name starts with a given letter (e.g. 'Z' -> Zambia, Zimbabwe)
    List<Country> findByNameStartingWithIgnoreCase(String letter);

}