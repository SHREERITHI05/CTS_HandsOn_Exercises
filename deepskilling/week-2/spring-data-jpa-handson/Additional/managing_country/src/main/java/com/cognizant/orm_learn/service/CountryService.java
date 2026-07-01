package com.cognizant.orm_learn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // 1. Find a country based on country code
    @Transactional
    public Country getCountryByCode(String code) {
        Optional<Country> country = countryRepository.findById(code);
        return country.orElse(null);
    }

    // 2. Add new country
    @Transactional
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // 3. Update country
    @Transactional
    public Country updateCountry(Country country) {
        return countryRepository.save(country);
    }

    // 4. Delete country
    @Transactional
    public void deleteCountry(String code) {
        countryRepository.deleteById(code);
    }

    // 5. Find list of countries matching a partial country name
    @Transactional
    public List<Country> getCountriesByPartialName(String partialName) {
        return countryRepository.findByNameContainingIgnoreCase(partialName);
    }

}