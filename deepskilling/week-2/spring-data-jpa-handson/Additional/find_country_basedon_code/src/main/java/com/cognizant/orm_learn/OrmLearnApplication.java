package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("Total countries={}", countries.size());
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start");

		Country newCountry = new Country();
		newCountry.setCode("ZZ");
		newCountry.setName("Test Land");

		countryService.addCountry(newCountry);

		Country fetchedCountry = countryService.findCountryByCode("ZZ");
		LOGGER.debug("Fetched Country after add:{}", fetchedCountry);

		LOGGER.info("End");
	}

}